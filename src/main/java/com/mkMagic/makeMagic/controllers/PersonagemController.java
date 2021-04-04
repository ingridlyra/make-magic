package com.mkMagic.makeMagic.controllers;

import com.mkMagic.makeMagic.models.Personagem;
import com.mkMagic.makeMagic.models.PersonagemResponse;
import com.mkMagic.makeMagic.models.exceptions.HouseNotFoundException;
import com.mkMagic.makeMagic.models.exceptions.IdNotFoundException;
import com.mkMagic.makeMagic.models.exceptions.NoRecordsException;
import com.mkMagic.makeMagic.services.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/personagem")
public class PersonagemController {

    @Autowired
    PersonagemService personagemService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Personagem personagem) throws HouseNotFoundException {
        try {
            PersonagemResponse personagemResponse = personagemService.create(personagem);
            return ResponseEntity.status(HttpStatus.CREATED).body(personagemResponse);
        } catch (HouseNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable(name = "id") Long id) {
        try {
            PersonagemResponse personagemResponse = personagemService.research(id);
            return ResponseEntity.status(HttpStatus.FOUND).body(personagemResponse);
        } catch (IdNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> listAll(@RequestParam (name = "house", required = false) String house) {
        try {
            List<PersonagemResponse> listaPersonagens;
            if (house != null && !house.isEmpty()) {
                listaPersonagens = personagemService.listFilter(house);
            } else {
                listaPersonagens = personagemService.list();
            }
            return ResponseEntity.status(HttpStatus.FOUND).body(listaPersonagens);
        } catch (NoRecordsException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable(name = "id") Long id, @RequestBody Personagem personagem) {
        personagem.setId(id);
        personagemService.update(personagem);
        String message = "Personagem atualizado";
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") Long id) {
        personagemService.delete(id);
        String message = "Personagem excluído";
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }
}
