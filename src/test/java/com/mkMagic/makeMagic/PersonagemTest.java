package com.mkMagic.makeMagic;

import static org.assertj.core.api.Assertions.assertThat;
import com.mkMagic.makeMagic.models.Personagem;
import com.mkMagic.makeMagic.models.PersonagemResponse;
import com.mkMagic.makeMagic.models.exceptions.HouseNotFoundException;
import com.mkMagic.makeMagic.repositories.PersonagemRepository;
import com.mkMagic.makeMagic.services.PersonagemService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class PersonagemTest {

    @Autowired
    PersonagemService personagemService;

    @MockBean
    PersonagemRepository personagemRepository;

    @Test
    public void creatingSuccess() throws HouseNotFoundException {
        //Cenário
        Personagem personagem = new Personagem();
        personagem.setName("Ingrid Lyra");
        personagem.setHouse("df01bd60-e3ed-478c-b760-cdbd9afe51fc");
        personagem.setRole("student");
        personagem.setPatronus("Cat");
        personagem.setSchool("Slytherin");

        Mockito.when(personagemRepository.save(Mockito.any(Personagem.class))).thenAnswer(i -> {
            Personagem personagemToReturn = i.getArgument(0);
            personagemToReturn.setId(1L);
            return personagemToReturn;
        } );
        //Ação
        PersonagemResponse personagemReturned = personagemService.create(personagem);
        //Verificação
        assertThat(personagemReturned.getName()).isEqualTo(personagem.getName());
        assertThat(personagemReturned.getHouse()).isEqualTo(personagem.getHouse());
        assertThat(personagemReturned.getSchool()).isEqualTo(personagem.getSchool());
        assertThat(personagemReturned.getRole()).isEqualTo(personagem.getRole());
        assertThat(personagemReturned.getPatronus()).isEqualTo(personagem.getPatronus());
    }

    @Test
    public void updateSuccess() throws HouseNotFoundException {
        //Cenário

        //Ação

        //Verificação

    }

    @Test
    public void listSuccess() throws HouseNotFoundException {
        //Cenário
        List<Personagem> personagemList = new ArrayList<>();
        personagemList.add(new Personagem(1L, "Ana", "Aluna", "Hogwarts School of Witchcraft and Wizardry", "df01bd60-e3ed-478c-b760-cdbd9afe51fc", "Peixe"));
        personagemList.add(new Personagem(2L, "Mariana", "Estudante", "Hogwarts School of Witchcraft and Wizardry", "df01bd60-e3ed-478c-b760-cdbd9afe51fc", "Cabra"));
        personagemList.add(new Personagem(3L, "Carol", "Desenvolvedora", "Hogwarts School of Witchcraft and Wizardry", "56cabe3a-9bce-4b83-ba63-dcd156e9be45", "Unicórnio"));
        personagemList.add(new Personagem(4L, "Ariana", "Designer", "Hogwarts School of Witchcraft and Wizardry", "542b28e2-9904-4008-b038-034ab312ad7e", "Panda"));

        Mockito.when(personagemRepository.findAll())
                .thenReturn(personagemList);
        //Ação
        List<PersonagemResponse> returnedList = personagemService.list();
        //Verificação
        assertThat(returnedList).isNotEmpty();
        assertThat(returnedList.size()).isEqualTo(personagemList.size());
    }

    @Test
    public void deleteSuccess() throws HouseNotFoundException {
        //Cenário

        //Ação

        //Verificação

    }

    @Test
    public void researchSuccess() throws HouseNotFoundException {
        //Cenário

        //Ação

        //Verificação

    }



}
