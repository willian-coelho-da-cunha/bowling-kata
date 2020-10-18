package br.com.idorigem.bowlingKata.exception;

public class MatchesQuantityBiggerThanExpectedException extends IllegalArgumentException {

	private static final long serialVersionUID = 8749351902984843138L;

	public MatchesQuantityBiggerThanExpectedException() {
		super("Sentimos muito! Algo não ocorreu bem :( , A quantidade de rodadas é diferente do que o esperado. Por gentileza, verifique os valores informados.");
	}
}
