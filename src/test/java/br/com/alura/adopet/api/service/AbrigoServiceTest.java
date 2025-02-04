package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.repository.AbrigoRepository;
import br.com.alura.adopet.api.repository.PetRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class AbrigoServiceTest {

    @InjectMocks
    private AbrigoService service;

    @Mock
    private AbrigoRepository abrigoRepository;

    @Mock
    private PetRepository petRepository;

    @Mock
    private Abrigo abrigo;

    @Test
    void deveriaChamarListaDeTodosOsAbrigos(){
        //Act
        service.listar();

        //Assert
        then(abrigoRepository).should().findAll();
    }

    @Test
    void deveriaChamarListaDePetsDoAbrigoAtravesDoNome(){
        //Arrange
        String nome = "Miau";
        given(abrigoRepository.findByNome(nome))
                .willReturn(Optional.of(abrigo));

        //Act
        service.listarPetsDoAbrigo(nome);

        //Assert
        then(petRepository).should().findByAbrigo(abrigo);
    }


}