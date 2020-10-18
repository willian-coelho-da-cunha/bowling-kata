package br.com.idorigem.bowlingKata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.idorigem.bowlingKata.exception.MatchesQuantityBiggerThanExpectedException;
import br.com.idorigem.bowlingKata.exception.NegativeValueException;
import br.com.idorigem.bowlingKata.exception.ValueBiggerThanExpectedException;

public class CalculadoraPontuacaoBolicheTest {

	private final CalculadoraPontuacaoBoliche calculadoraPontuacaoBoliche = new CalculadoraPontuacaoBoliche();

	@Test
	public void umJogoComStrikeDeveRetornarPontuacaoEquivalente() {
		final int[] pinosDerrubadosPrimeiroJogo = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 2, 3, 0, 0 };
		final int[] pinosDerrubadosSegundoJogo = { 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 2, 3, 0, 0 };
		final int[] pinosDerrubadosTerceiroJogo = { 10, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 2, 3, 0, 0 };
		final int[] pinosDerrubadosQuartoJogo = { 1, 0, 5, 2, 10, 0, 4, 0, 0, 0, 0, 0, 0, 10, 2, 3, 0, 0 };
		final int[] pinosDerrubadosQuintoJogo = { 5, 5, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 2, 3, 0, 0 };
		final int[] pinosDerrubadosSextoJogo = { 4, 6, 1, 0, 10, 0, 7, 1, 9, 4, 0, 0, 0, 10, 2, 3, 0, 0 };
		final int[] pinosDerrubadosSetimoJogo = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 2, 3, 10, 10, 10 };
		final int[] pinosDerrubadosOitavoJogo = { 10, 7, 1, 10, 5, 5, 10, 0, 7, 0, 0, 10, 2, 3, 10, 10, 10 };

		assertEquals(20, calculadoraPontuacaoBoliche.pontuacaoDoJogo(pinosDerrubadosPrimeiroJogo));
		assertEquals(30, calculadoraPontuacaoBoliche.pontuacaoDoJogo(pinosDerrubadosSegundoJogo));
		assertEquals(32, calculadoraPontuacaoBoliche.pontuacaoDoJogo(pinosDerrubadosTerceiroJogo));
		assertEquals(46, calculadoraPontuacaoBoliche.pontuacaoDoJogo(pinosDerrubadosQuartoJogo));
		assertEquals(50, calculadoraPontuacaoBoliche.pontuacaoDoJogo(pinosDerrubadosQuintoJogo));
		assertEquals(74, calculadoraPontuacaoBoliche.pontuacaoDoJogo(pinosDerrubadosSextoJogo));
		assertEquals(50, calculadoraPontuacaoBoliche.pontuacaoDoJogo(pinosDerrubadosSetimoJogo));
		assertEquals(140, calculadoraPontuacaoBoliche.pontuacaoDoJogo(pinosDerrubadosOitavoJogo));
	}

	@Test
	public void umJogoComSpareDeveRetornarPontuacaoEquivalente() {
		final int[] pinosDerrubadosPrimeiroJogo = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 8, 2, 3, 0, 0 };
		final int[] pinosDerrubadosSegundoJogo = { 10, 7, 3, 10, 5, 0, 0, 0, 0, 0, 0, 0, 2, 8, 2, 3, 0, 0 };
		final int[] pinosDerrubadosTerceiroJogo = { 7, 1, 9, 0, 10, 0, 9, 10, 0, 8, 0, 0, 2, 8, 2, 3, 0, 0 };
		final int[] pinosDerrubadosQuartoJogo = { 10, 10, 0, 9, 0, 1, 5, 3, 10, 0, 0, 2, 8, 2, 3, 0, 0 };
		final int[] pinosDerrubadosQuintoJogo = { 0, 0, 0, 0, 10, 0, 0, 10, 0, 0, 2, 8, 2, 3, 0, 0, 0, 0 };
		final int[] pinosDerrubadosSextoJogo = { 10, 10, 10, 10, 10, 0, 0, 0, 0, 2, 8, 2, 3, 0, 0 };
		final int[] pinosDerrubadosSetimoJogo = { 10, 0, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 2, 8, 2, 3, 10, 10, 10 };
		final int[] pinosDerrubadosOitavoJogo = { 0, 0, 10, 5, 5, 10, 0, 8, 0, 0, 0, 0, 2, 8, 2, 3, 0, 0 };

		assertEquals(17, calculadoraPontuacaoBoliche.pontuacaoDoJogo(pinosDerrubadosPrimeiroJogo));
		assertEquals(77, calculadoraPontuacaoBoliche.pontuacaoDoJogo(pinosDerrubadosSegundoJogo));
		assertEquals(88, calculadoraPontuacaoBoliche.pontuacaoDoJogo(pinosDerrubadosTerceiroJogo));
		assertEquals(84, calculadoraPontuacaoBoliche.pontuacaoDoJogo(pinosDerrubadosQuartoJogo));
		assertEquals(37, calculadoraPontuacaoBoliche.pontuacaoDoJogo(pinosDerrubadosQuintoJogo));
		assertEquals(137, calculadoraPontuacaoBoliche.pontuacaoDoJogo(pinosDerrubadosSextoJogo));
		assertEquals(67, calculadoraPontuacaoBoliche.pontuacaoDoJogo(pinosDerrubadosSetimoJogo));
		assertEquals(83, calculadoraPontuacaoBoliche.pontuacaoDoJogo(pinosDerrubadosOitavoJogo));
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
		final int[] pinosDerrubadosPrimeiroJogo = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };
		final int[] pinosDerrubadosSegundoJogo = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 2, 3, 0, 0, 0 };
		final int[] pinosDerrubadosTerceiroJogo = { 10, 7, 1, 10, 5, 5, 10, 0, 7, 0, 0, 10, 2, 3, 10, 10, 10, 10 };
		
		Exception exceptionFirstGame = assertThrows(MatchesQuantityBiggerThanExpectedException.class, () -> calculadoraPontuacaoBoliche.pontuacaoDoJogo(pinosDerrubadosPrimeiroJogo));
		assertEquals("Sentimos muito! Algo não ocorreu bem :( , A quantidade de rodadas é diferente do que o esperado. Por gentileza, verifique os valores informados.", exceptionFirstGame.getMessage());

		Exception exceptionSecondGame = assertThrows(MatchesQuantityBiggerThanExpectedException.class, () -> calculadoraPontuacaoBoliche.pontuacaoDoJogo(pinosDerrubadosSegundoJogo));
		assertEquals("Sentimos muito! Algo não ocorreu bem :( , A quantidade de rodadas é diferente do que o esperado. Por gentileza, verifique os valores informados.", exceptionSecondGame.getMessage());

		Exception exceptionThirdGame = assertThrows(MatchesQuantityBiggerThanExpectedException.class, () -> calculadoraPontuacaoBoliche.pontuacaoDoJogo(pinosDerrubadosTerceiroJogo));
		assertEquals("Sentimos muito! Algo não ocorreu bem :( , A quantidade de rodadas é diferente do que o esperado. Por gentileza, verifique os valores informados.", exceptionThirdGame.getMessage());
	}

	@Test
	public void umJogoQueTenhaUmaOuMaisRodadasComPontuacaoNegativaDeveResultarEmUmaExcessaoDoTipoArgumentoIlegal() {
		final int[] pinosDerrubados = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -10, 2, 3, 0, 0 };
		
		Exception exception = assertThrows(NegativeValueException.class, () -> calculadoraPontuacaoBoliche.pontuacaoDoJogo(pinosDerrubados));
		assertEquals("Sentimos muito! Algo não ocorreu bem :( , Algumas jogadas possuem valor negativo.", exception.getMessage());
	}

	@Test
	public void umJogoQueTenhaUmaOuMaisRodadasComPontuacaoMaiorQueDezDeveResultarEmUmaExcessaoDoTipoArgumentoIlegal() {
		final int[] pinosDerrubados = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11, 2, 3, 0, 0 };
		
		Exception exception = assertThrows(ValueBiggerThanExpectedException.class, () -> calculadoraPontuacaoBoliche.pontuacaoDoJogo(pinosDerrubados));
		assertEquals("Sentimos muito! Algo não ocorreu bem :( , Algumas jogadas possuem valor maior do que 10.", exception.getMessage());
	}

	@Test
	public void umJogoQueTenhaComoJogadasOValorNullDeveResultarEmUmaExcessaoDePontoNulo() {
		Exception exception = assertThrows(NullPointerException.class, () -> calculadoraPontuacaoBoliche.pontuacaoDoJogo(null));
		assertEquals("Sentimos muito! Algo não ocorreu bem :( , O argumento informado ao método não pode ser null.", exception.getMessage());
	}
}
