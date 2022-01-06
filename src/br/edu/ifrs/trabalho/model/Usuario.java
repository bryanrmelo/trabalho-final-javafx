package br.edu.ifrs.trabalho.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

//Bryan Melo

@Table(name = "usuario")
@Entity
@NamedQuery(name = Usuario.USUARIO_LOGIN, query = "SELECT u FROM Usuario AS u WHERE u.login = ?1")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String USUARIO_LOGIN = "usuario.login";

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "login", nullable = false)
	private String login;

	@Column(name = "senha", nullable = false)
	private String senha;

	@Column(name = "tipo", nullable = false)
	private String tipo;

	public Usuario() {
	}

	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}

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
