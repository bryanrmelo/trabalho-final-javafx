package br.edu.ifrs.trabalho.exceptions;

//Bryan Melo

public class SenhaInvalidaException extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "A senha inserida está incorreta.";
	}

}
