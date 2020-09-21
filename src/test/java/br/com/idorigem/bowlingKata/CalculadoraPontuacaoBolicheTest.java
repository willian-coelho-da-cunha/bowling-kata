package br.com.idorigem.bowlingKata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CalculadoraPontuacaoBolicheTest {

	private final CalculadoraPontuacaoBoliche calculadoraPontuacaoBoliche = new CalculadoraPontuacaoBoliche();

	@Test
	public void umJogoComStrikeDeveRetornarPontuacaoEquivalente() {
		final int[] pinosDerrubados = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 2, 3, 0, 0 };
		assertEquals(20, calculadoraPontuacaoBoliche.pontuacaoDoJogo(pinosDerrubados));
	}

	@Test
	public void umJogoComSpareDeveRetornarPontuacaoEquivalente() {
		final int[] pinosDerrubados = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 8, 2, 3, 0,0 };
		assertEquals(17, calculadoraPontuacaoBoliche.pontuacaoDoJogo(pinosDerrubados));
	}

	@Test
	public void umJogoCompletoComSpareEStrikeDeveRetornarPontuacaoEquivalente() {
		final int[] pinosDerrubados = { 1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 1, 7, 3, 6, 4, 10, 2, 8, 6 };
		assertEquals(133, calculadoraPontuacaoBoliche.pontuacaoDoJogo(pinosDerrubados));
	}

	@Test
	public void umJogoPerfeitoDeveRetornarPontuacaoTrezentos() {
		final int[] pinosDerrubados = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };
		assertEquals(300, calculadoraPontuacaoBoliche.pontuacaoDoJogo(pinosDerrubados));
	}

	@Test
	public void umJogoComMaisDeDezRodadasDeveResultarEmUmaExcessaoDoTipoArgumentoIlegal() {
		final int[] pinosDerrubados = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };
		
		Exception exception = assertThrows(
			IllegalArgumentException.class,
			() -> calculadoraPontuacaoBoliche.pontuacaoDoJogo(pinosDerrubados)
		);
		assertEquals(
			"Sentimos muito! Algo não ocorreu bem :( , A quantidade de rodadas é diferente do que o esperado. " +
			"Por gentileza, verifique os valores informados.",
			exception.getMessage()
		);
	}

	@Test
	public void umJogoQueTenhaUmaOuMaisRodadasComPontuacaoNegativaDeveResultarEmUmaExcessaoDoTipoArgumentoIlegal() {
		final int[] pinosDerrubados = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -10, 2, 3, 0, 0 };
		
		Exception exception = assertThrows(
			IllegalArgumentException.class,
			() -> calculadoraPontuacaoBoliche.pontuacaoDoJogo(pinosDerrubados)
		);
		assertEquals(
			"Sentimos muito! Algo não ocorreu bem :( , Algumas jogadas possuem valor negativo.",
			exception.getMessage()
		);
	}

	@Test
	public void umJogoQueTenhaUmaOuMaisRodadasComPontuacaoMaiorQueDezDeveResultarEmUmaExcessaoDoTipoArgumentoIlegal() {
		final int[] pinosDerrubados = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11, 2, 3, 0, 0 };
		
		Exception exception = assertThrows(
			IllegalArgumentException.class,
			() -> calculadoraPontuacaoBoliche.pontuacaoDoJogo(pinosDerrubados)
		);
		assertEquals(
			"Sentimos muito! Algo não ocorreu bem :( , Algumas jogadas possuem valor maior do que 10.",
			exception.getMessage()
		);
	}

	@Test
	public void umJogoQueTenhaComoJogadasOValorNullDeveResultarEmUmaExcessaoDePontoNulo() {
		Exception exception = assertThrows(
			NullPointerException.class,
			() -> calculadoraPontuacaoBoliche.pontuacaoDoJogo(null)
		);
		assertEquals(
			"Sentimos muito! Algo não ocorreu bem :( , O argumento informado ao método não pode ser null.",
			exception.getMessage()
		);
	}
}
