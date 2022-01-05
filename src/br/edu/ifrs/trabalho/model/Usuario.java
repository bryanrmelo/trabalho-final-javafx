package br.edu.ifrs.trabalho.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "usuario")
@Entity

@NamedQueries({ @NamedQuery(name = Usuario.USUARIO_LOGIN, query = "SELECT u FROM Usuario AS u WHERE login = :login"), })
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String USUARIO_LOGIN = "usuario.login";

	@Id
	@Column(name = "id", nullable = false)
	private long id;

	@Column(name = "login", nullable = false)
	private String login;

	@Column(name = "senha", nullable = false)
	private String senha;

	@Column(name = "tipo", nullable = false)
	private String tipo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
