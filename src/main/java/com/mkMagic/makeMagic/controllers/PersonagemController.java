package com.mkMagic.makeMagic.controllers;

import com.mkMagic.makeMagic.models.Personagem;
import com.mkMagic.makeMagic.models.PersonagemResponse;
import com.mkMagic.makeMagic.services.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/personagem")
public class PersonagemController {

    @Autowired
    PersonagemService personagemService;

    @PostMapping
    public ResponseEntity<PersonagemResponse> create(@RequestBody Personagem personagem) {
        PersonagemResponse personagemResponse = personagemService.create(personagem);
        return ResponseEntity.status(HttpStatus.CREATED).body(personagemResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonagemResponse> find(@PathVariable(name = "id") Long id) {
        PersonagemResponse personagemResponse = personagemService.research(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(personagemResponse);
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