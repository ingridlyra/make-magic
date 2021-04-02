package com.mkMagic.makeMagic.services;

import com.mkMagic.makeMagic.models.Personagem;
import com.mkMagic.makeMagic.models.PersonagemResponse;
import com.mkMagic.makeMagic.models.exceptions.IdNotFoundException;
import com.mkMagic.makeMagic.repositories.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonagemService {
    @Autowired
    PersonagemRepository personagemRepository;

    public Personagem create(Personagem personagem) {
        return personagemRepository.save(personagem);
    }

    public PersonagemResponse research(Long id) throws IdNotFoundException {
        Personagem personagem = this.findById(id);
        return new PersonagemResponse(personagem);
    }

    public Personagem update(Personagem personagem) {
        return personagemRepository.save(personagem);
    }

    public void delete(Long id) {
        personagemRepository.deleteById(id);
    }

    public Personagem findById(Long id) throws IdNotFoundException{
        Optional<Personagem> personagem = personagemRepository.findById(id);
        return personagem.get();
    }

}
