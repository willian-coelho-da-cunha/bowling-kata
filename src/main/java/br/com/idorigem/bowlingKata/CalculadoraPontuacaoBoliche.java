package br.com.idorigem.bowlingKata;

public class CalculadoraPontuacaoBoliche {

	private void validarJogadas(int[] jogadas) {
		if (jogadas != null) {
			for(int jogada : jogadas) {
				if (jogada < 0) {
					throw new IllegalArgumentException(
						"Sentimos muito! Algo não ocorreu bem :( , Algumas jogadas possuem valor negativo."
					);
				} else if (jogada > 10) {
					throw new IllegalArgumentException(
						"Sentimos muito! Algo não ocorreu bem :( , Algumas jogadas possuem valor maior do que 10."
					);
				}
			}
		} else {
			throw new NullPointerException(
				"Sentimos muito! Algo não ocorreu bem :( , O argumento informado ao método não pode ser null."
			);
		}
	}

	private void validarRodadas(int[] jogadas) {
		byte quantidadeRodadas = 0;

		for(int jogada : jogadas) {
			quantidadeRodadas += jogada == 10 ? 2 : 1;
		}

		if (!(quantidadeRodadas == 24 || quantidadeRodadas == 23 || quantidadeRodadas == 22 || quantidadeRodadas == 21 || quantidadeRodadas == 20)) {
			throw new IllegalArgumentException(
				"Sentimos muito! Algo não ocorreu bem :( , A quantidade de rodadas é diferente do que o esperado. " +
				"Por gentileza, verifique os valores informados."
			);
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
