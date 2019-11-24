package com.idorigem.softplan.bowlingKata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.idorigem.softplan.bowlingKata.CalculadoraPontuacaoBoliche;

public class CalculadoraPontuacaoBolicheTest {
	
	CalculadoraPontuacaoBoliche calculadoraPontuacaoBoliche = new CalculadoraPontuacaoBoliche();

	/** Second example from PDF. */
	@Test
	public void pontuacaoDoJogoTestA() {
		int[] pinosDerrubados = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 2, 3, 0, 0};
		int pontuacaoDoJogo = 0;
		int retornoEsperado = 20;
		
		pontuacaoDoJogo = calculadoraPontuacaoBoliche.pontuacaoDoJogo(pinosDerrubados);
		assertEquals(retornoEsperado, pontuacaoDoJogo);
	}
	
	/** Third example from PDF. */
	@Test
	public void pontuacaoDoJogoTestB() {
		int[] pinosDerrubados = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 8, 2, 3, 0,0};
		int pontuacaoDoJogo = 0;
		int retornoEsperado = 17;

		pontuacaoDoJogo = calculadoraPontuacaoBoliche.pontuacaoDoJogo(pinosDerrubados);
		assertEquals(retornoEsperado, pontuacaoDoJogo);
	}

	/** First example from PDF. */
	@Test
	public void pontuacaoDoJogoTestC() {
		int[] pinosDerrubados = {1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 1, 7, 3, 6, 4, 10, 2, 8, 6};
		int pontuacaoDoJogo = 0;
		int retornoEsperado = 133;

		pontuacaoDoJogo = calculadoraPontuacaoBoliche.pontuacaoDoJogo(pinosDerrubados);
		assertEquals(retornoEsperado, pontuacaoDoJogo);
	}
	
	/** Fourth example from PDF. */
	@Test
	public void pontuacaoDoJogoTestD() {
		int[] pinosDerrubados = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
		int pontuacaoDoJogo = 0;
		int retornoEsperado = 300;

		pontuacaoDoJogo = calculadoraPontuacaoBoliche.pontuacaoDoJogo(pinosDerrubados);
		assertEquals(retornoEsperado, pontuacaoDoJogo);
	}

	/** Test if there are less plays than expected. */
	@Test
	public void pontuacaoDoJogoTestE() {
		int[] pinosDerrubados = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 2, 3};
		
		Exception exception = assertThrows(RuntimeException.class, () -> calculadoraPontuacaoBoliche.pontuacaoDoJogo(pinosDerrubados));
		assertEquals("Sentimos muito! Algo não ocorreu bem :( , Rodadas inválidas.", exception.getMessage());
	}
	
	/** Test if there are more plays than expected. */
	@Test
	public void pontuacaoDoJogoTestF() {
		int[] pinosDerrubados = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
		
		Exception exception = assertThrows(RuntimeException.class, () -> calculadoraPontuacaoBoliche.pontuacaoDoJogo(pinosDerrubados));
		assertEquals(
			"Sentimos muito! Algo não ocorreu bem :( , Há mais jogadas do que o esperado. " +
			"Por gentileza, verifique os valores informados.",
			exception.getMessage()
		);
	}

	/** Test if there are some negative play. */
	@Test
	public void pontuacaoDoJogoTestG() {
		int[] pinosDerrubados = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -10, 2, 3, 0, 0};
		
		Exception exception = assertThrows(RuntimeException.class, () -> calculadoraPontuacaoBoliche.pontuacaoDoJogo(pinosDerrubados));
		assertEquals(
			"Sentimos muito! Algo não ocorreu bem :( , Algumas jogadas possuem valor negativo.",
			exception.getMessage()
		);
	}

	/** Test if there are some play with its value is greater than 10. */
	@Test
	public void pontuacaoDoJogoTestH() {
		int[] pinosDerrubados = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11, 2, 3, 0, 0};
		
		Exception exception = assertThrows(RuntimeException.class, () -> calculadoraPontuacaoBoliche.pontuacaoDoJogo(pinosDerrubados));
		assertEquals(
			"Sentimos muito! Algo não ocorreu bem :( , Algumas jogadas possuem valor maior do que 10.",
			exception.getMessage()
		);
	}
}
