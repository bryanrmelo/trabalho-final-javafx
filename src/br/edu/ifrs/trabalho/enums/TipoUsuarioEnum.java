package br.edu.ifrs.trabalho.enums;

public enum TipoUsuarioEnum {

	A(1, "Administrador"), P(1, "Padrão");

	private long id;
	private String descricao;

	private TipoUsuarioEnum(long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public long getId() {
		return id;
	}
}
