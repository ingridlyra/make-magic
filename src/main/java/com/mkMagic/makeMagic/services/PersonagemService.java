package com.mkMagic.makeMagic.services;

import com.mkMagic.makeMagic.models.Personagem;
import com.mkMagic.makeMagic.models.PersonagemResponse;
import com.mkMagic.makeMagic.models.exceptions.HouseNotFoundException;
import com.mkMagic.makeMagic.models.exceptions.IdNotFoundException;
import com.mkMagic.makeMagic.repositories.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class PersonagemService {
    @Autowired
    PersonagemRepository personagemRepository;

    public PersonagemResponse create(Personagem personagem) throws HouseNotFoundException{
        boolean exist = verifyHouse(personagem.getHouse());
        if (!exist){
            throw new HouseNotFoundException(personagem.getHouse());
        }
        Personagem newPersonagem = personagemRepository.save(personagem);
        return new PersonagemResponse(newPersonagem);
    }

    public PersonagemResponse research(Long id) throws IdNotFoundException {
        Personagem personagem = this.findById(id);
        return new PersonagemResponse(personagem);
    }

    public void update(Personagem personagem) {
        personagemRepository.save(personagem);
    }

    public void delete(Long id) {
        personagemRepository.deleteById(id);
    }

    public Personagem findById(Long id) throws IdNotFoundException {
        Optional<Personagem> personagem = personagemRepository.findById(id);
        return personagem.get();
    }

    public boolean verifyHouse(String id) {
        final String uri = "http://us-central1-rh-challenges.cloudfunctions.net/potterApi/houses";
        HttpHeaders headers = new HttpHeaders();
        headers.set("apikey", "ceb66ae1-5af4-405a-b30d-00d2a5a68b70");

        HttpEntity<String> entity = new HttpEntity<String>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

        return response.getBody().contains("\"id\":\"" + id + "\"");
    }

}
