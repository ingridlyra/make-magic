package com.mkMagic.makeMagic.repositories;

import com.mkMagic.makeMagic.models.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonagemRepository extends JpaRepository<Personagem, Long> {
}
