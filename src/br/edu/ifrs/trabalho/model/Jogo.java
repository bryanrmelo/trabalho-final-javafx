package br.edu.ifrs.trabalho.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "jogo")
@NamedQueries({ @NamedQuery(name = Jogo.POR_ID, query = "SELECT j FROM Jogo j WHERE j.id = :id") })
@Entity
public class Jogo implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String POR_ID = "jogo.id";

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
