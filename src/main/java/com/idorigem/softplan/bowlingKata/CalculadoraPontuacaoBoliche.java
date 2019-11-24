package com.idorigem.softplan.bowlingkata;

public class CalculadoraPontuacaoBoliche {

	/**
	 * @param posicaoUltimaJogada Normal position (without strike(s) and spare(s)).
	 */
	private void validarQuantidadeJogadas(int[] jogadas, int posicaoUltimaJogada) {
		int quantidadeJogadas = 0;

		if (jogadas[posicaoUltimaJogada] == 10) {
			/** strike */
			quantidadeJogadas = posicaoUltimaJogada + 2;
		} else {
			int rodadaFinal = jogadas[posicaoUltimaJogada -1] + jogadas[posicaoUltimaJogada];
			if (rodadaFinal == 10) {
				/** spare */
				quantidadeJogadas = posicaoUltimaJogada + 1;
			} else {
				quantidadeJogadas = posicaoUltimaJogada;
			}
		}
		
		if ((jogadas.length - 1) > quantidadeJogadas) {
			throw new RuntimeException(
				"Sentimos muito! Algo não ocorreu bem :( , Há mais jogadas do que o esperado. " +
				"Por gentileza, verifique os valores informados."
			);
		}
	}

	private int validarRodadas(int[] jogadas) {
		try {
			int posicaoUltimaJogada = 0;

			for(int rodada = 1; rodada <= 10; rodada++) {
				if (jogadas[posicaoUltimaJogada] == 10) {
					if (rodada < 10) {
						posicaoUltimaJogada++;
					}
				} else {
					if (rodada < 10) {
						posicaoUltimaJogada += 2;
					} else {
						posicaoUltimaJogada++;
					}
				}
			}
			
			return posicaoUltimaJogada;

		} catch(Exception exception) {
			throw new RuntimeException("Sentimos muito! Algo não ocorreu bem :( , Rodadas inválidas.");
		}
	}

	private void validarJogadas(int[] jogadas) {
		for(int posicao = 0; posicao < jogadas.length; posicao++) {
			if (jogadas[posicao] < 0) {
				throw new RuntimeException("Sentimos muito! Algo não ocorreu bem :( , Algumas jogadas possuem valor negativo.");
			}
			
			if (jogadas[posicao] > 10) {
				throw new RuntimeException("Sentimos muito! Algo não ocorreu bem :( , Algumas jogadas possuem valor maior do que 10.");
			}
		}
	}

	public int pontuacaoDoJogo(int[] jogadas) {
		this.validarJogadas(jogadas);

		int posicaoUltimaJogada = this.validarRodadas(jogadas);
		this.validarQuantidadeJogadas(jogadas, posicaoUltimaJogada);

		int pontuacaoDoJogo = 0;
		int posicao = 0;
		
		for(int rodada = 1; rodada <= 10; rodada++) {
			pontuacaoDoJogo += jogadas[posicao];
			
			if (jogadas[posicao] == 10) {
				pontuacaoDoJogo += jogadas[posicao + 1];
				pontuacaoDoJogo += jogadas[posicao + 2];
				posicao++;
				continue;
			} else {
				pontuacaoDoJogo += jogadas[posicao + 1];

				if ((jogadas[posicao] + jogadas[posicao + 1]) == 10) {
					pontuacaoDoJogo += jogadas[posicao + 2];
				}
				
				posicao += 2;
			}
		}
		return pontuacaoDoJogo;
	}
}
