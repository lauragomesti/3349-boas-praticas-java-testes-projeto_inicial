package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.CadastroAbrigoDto;
import br.com.alura.adopet.api.dto.CadastroPetDto;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.model.ProbabilidadeAdocao;
import br.com.alura.adopet.api.model.TipoPet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraProbabilidadeAdocaoTest {


    @Test
    void deveriaRetornarProbabilidadeAltaParaPetComIdadeBaixaEPesoBaixo(){

        //ARRANGE
        Abrigo abrigo = new Abrigo(new CadastroAbrigoDto(
                "Abrigo feliz",
                    "99999999",
                    "abrigoFeliz@gmail.com"
        ));

        Pet pet = new Pet(new CadastroPetDto(
                TipoPet.GATO,
                "Miaiu",
                "Siames",
                4,
                "Cinza",
                4.0f), abrigo);

        CalculadoraProbabilidadeAdocao calculadora = new CalculadoraProbabilidadeAdocao();
        //ACT
        ProbabilidadeAdocao probabilidade = calculadora.calcular(pet);
       // ASSERT
        Assertions.assertEquals(ProbabilidadeAdocao.ALTA, probabilidade);

    }
    /*Idade 15 anos e 4Kg - Probalidade MEDIA*/
    @Test
    void deveriaRetornarProbabilidadeMediaParaPetComIdadeAltaEPesoBaixo(){

        Abrigo abrigo = new Abrigo(new CadastroAbrigoDto(
                "Abrigo feliz",
                "99999999",
                "abrigoFeliz@gmail.com"
        ));

        Pet pet = new Pet(new CadastroPetDto(
                TipoPet.GATO,
                "Miaiu",
                "Siames",
                15,
                "Cinza",
                4.0f), abrigo);

        CalculadoraProbabilidadeAdocao calculadora = new CalculadoraProbabilidadeAdocao();
        ProbabilidadeAdocao probabilidade = calculadora.calcular(pet);
        Assertions.assertEquals(ProbabilidadeAdocao.MEDIA, probabilidade);

    }

}