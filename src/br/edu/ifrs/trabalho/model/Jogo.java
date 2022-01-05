package br.edu.ifrs.trabalho.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "jogo")
@Entity

public class Jogo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", nullable = false)
	private long id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "desenvolvedor", nullable = false)
	private String desenvolvedor;

	@Column(name = "categoria", nullable = false)
	private String categoria;

	@Column(name = "ano", nullable = false)
	private int ano;

	public String getNome() {
		return nome;
	}

	public String getDesenvolvedor() {
		return desenvolvedor;
	}

	public String getCategoria() {
		return categoria;
	}

	public int getAno() {
		return ano;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDesenvolvedor(String desenvolvedor) {
		this.desenvolvedor = desenvolvedor;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
}
