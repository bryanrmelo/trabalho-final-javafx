package br.edu.ifrs.trabalho.exceptions;

//Bryan Melo

public class UsuarioNaoEncontrado extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Usuário não encontrado";
	}
}
