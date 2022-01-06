package br.edu.ifrs.trabalho.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "jogo")
@NamedQuery(name = Jogo.POR_ID, query = "SELECT j FROM Jogo j WHERE j.id = :id")
@NamedQuery(name = Jogo.TODOS, query = "SELECT j FROM Jogo j")
@Entity
public class Jogo implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String POR_ID = "jogo.id";

	public static final String TODOS = "jogo.todos";

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "desenvolvedor", nullable = false)
	private String desenvolvedor;

	@Column(name = "categoria", nullable = false)
	private String categoria;

	@Column(name = "ano", nullable = false)
	private int ano;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		return "Jogo [id=" + id + ", nome=" + nome + ", desenvolvedor=" + desenvolvedor + ", categoria=" + categoria + ", ano=" + ano + "]";
	}
}
