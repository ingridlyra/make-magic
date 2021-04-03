package com.mkMagic.makeMagic.controllers;

import com.mkMagic.makeMagic.models.Personagem;
import com.mkMagic.makeMagic.models.PersonagemResponse;
import com.mkMagic.makeMagic.services.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNullApi;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/personagem")
public class PersonagemController {

    @Autowired
    PersonagemService personagemService;

    public ResponseEntity<PersonagemResponse> create(@RequestBody Personagem personagem) {
        PersonagemResponse personagemResponse = personagemService.create(personagem);
        return ResponseEntity.status(HttpStatus.CREATED).body(personagemResponse);
    }


}
