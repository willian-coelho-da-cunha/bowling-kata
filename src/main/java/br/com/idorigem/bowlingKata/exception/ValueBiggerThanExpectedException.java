package br.com.idorigem.bowlingKata.exception;

public class ValueBiggerThanExpectedException extends IllegalArgumentException {

	private static final long serialVersionUID = -8559081845020375822L;

	public ValueBiggerThanExpectedException() {
		super("Sentimos muito! Algo não ocorreu bem :( , Algumas jogadas possuem valor maior do que 10.");
	}
}
