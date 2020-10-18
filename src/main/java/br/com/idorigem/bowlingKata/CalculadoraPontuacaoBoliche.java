package br.com.idorigem.bowlingKata;

import br.com.idorigem.bowlingKata.exception.MatchesQuantityBiggerThanExpectedException;
import br.com.idorigem.bowlingKata.exception.NegativeValueException;
import br.com.idorigem.bowlingKata.exception.ValueBiggerThanExpectedException;

public class CalculadoraPontuacaoBoliche {

	private void validarJogadas(int[] jogadas) {
		if (jogadas != null) {
			for (int jogada : jogadas) {
				if (jogada < 0) {
					throw new NegativeValueException();
				} else if (jogada > 10) {
					throw new ValueBiggerThanExpectedException();
				}
			}
		} else {
			throw new NullPointerException("Sentimos muito! Algo não ocorreu bem :( , O argumento informado ao método não pode ser null.");
		}
	}

	private void validarRodadas(int[] jogadas) {
		byte quantidadeRodadas = 0;
		byte quantidadeJogadas = 0;

		for (int jogada : jogadas) {
			if (jogada == 10) {
				quantidadeRodadas++;
				quantidadeJogadas = 0;
			} else {
				quantidadeJogadas++;
				if (quantidadeJogadas == 2) {
					quantidadeRodadas++;
					quantidadeJogadas = 0;
				}
			}
		}

		if (quantidadeRodadas != 10 && quantidadeRodadas != 11 && quantidadeRodadas != 12) {
			throw new MatchesQuantityBiggerThanExpectedException();
		} else if (quantidadeJogadas != 0) {
			if (jogadas[jogadas.length - 3] != 10 && (jogadas[jogadas.length - 3] + jogadas[jogadas.length - 2]) != 10) {
				throw new MatchesQuantityBiggerThanExpectedException();
			}
		}
	}

	private int calcularPontuacaoStrike(int[] jogadas) {
		byte proximoFatorMultiplicacao = 0;
		byte fatorMultiplicacao = 0;
		byte quantidadeRodadas = 0;
		int pontuacao = 0;

		for(int jogada : jogadas) {
			pontuacao += jogada * fatorMultiplicacao;
			if (quantidadeRodadas < 20) {
				if (jogada == 10) {
					fatorMultiplicacao = (byte)(proximoFatorMultiplicacao != 0 ? 2 : 1);
					proximoFatorMultiplicacao = 1;
					quantidadeRodadas += 2;
				} else {
					fatorMultiplicacao = proximoFatorMultiplicacao;
					proximoFatorMultiplicacao = 0;
					quantidadeRodadas += 1;
				}
			} else {
				fatorMultiplicacao = proximoFatorMultiplicacao = 1;
			}
		}
		return pontuacao;
	}

	private int calcularPontuacaoSpare(int[] jogadas) {
		byte quantidadeJogadasRodada = 0;
		boolean somarProximaJogada = false;
		int[] jogadasRodada = new int[2];
		int pontuacao = 0;

		for(int jogada : jogadas) {
			quantidadeJogadasRodada++;
			if (somarProximaJogada) {
				pontuacao += jogada;
				somarProximaJogada = false;
			}
			if (jogada != 10) {
				jogadasRodada[quantidadeJogadasRodada - 1] = jogada;
				if (quantidadeJogadasRodada == 2) {
					somarProximaJogada = (jogadasRodada[0] + jogadasRodada[1]) == 10;
					quantidadeJogadasRodada = 0;
					jogadasRodada = new int[2];
				}
			} else {
				quantidadeJogadasRodada = 0;
			}
		}
		return pontuacao;
	}

	private int calcularPontuacao(int[] jogadas) {
		byte quantidadeJogadasRodada = 0;
		byte quantidadeRodadas = 0;
		int pontuacao = 0;

		for(int jogada : jogadas) {
			if (quantidadeRodadas < 10) {
				if (jogada != 10) {
					quantidadeJogadasRodada = (byte)(quantidadeJogadasRodada == 0 ? 1 : 0);
				}
				if (quantidadeJogadasRodada == 0) {
					quantidadeRodadas++;
				}
				pontuacao += jogada;
			}
		}
		return pontuacao;
	}

	public int pontuacaoDoJogo(int[] jogadas) {
		this.validarJogadas(jogadas);
		this.validarRodadas(jogadas);

		int pontuacao = 0;
		pontuacao += this.calcularPontuacao(jogadas);
		pontuacao += this.calcularPontuacaoSpare(jogadas);
		pontuacao += this.calcularPontuacaoStrike(jogadas);
		return pontuacao;
	}
}
