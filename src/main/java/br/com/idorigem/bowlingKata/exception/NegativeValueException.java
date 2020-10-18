package br.com.idorigem.bowlingKata.exception;

public class NegativeValueException extends IllegalArgumentException {

	private static final long serialVersionUID = -5695381689796611921L;

	public NegativeValueException() {
		super("Sentimos muito! Algo não ocorreu bem :( , Algumas jogadas possuem valor negativo.");
	}
}
