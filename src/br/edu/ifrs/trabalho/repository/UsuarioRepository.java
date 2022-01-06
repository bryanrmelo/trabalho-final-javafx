package br.edu.ifrs.trabalho.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import br.edu.ifrs.trabalho.exceptions.SenhaInvalidaException;
import br.edu.ifrs.trabalho.exceptions.UsuarioNaoEncontrado;
import br.edu.ifrs.trabalho.model.Usuario;
import br.edu.ifrs.trabalho.utils.MD5Util;

//Bryan Melo

public class UsuarioRepository {

	public static boolean logar(Usuario usuario) throws SenhaInvalidaException, UsuarioNaoEncontrado {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("games");
		EntityManager em = emf.createEntityManager();
		Usuario u = new Usuario();

		try {
			Query q = em.createNamedQuery(Usuario.USUARIO_LOGIN, Usuario.class);
			q.setParameter(1, usuario.getLogin());
			u = (Usuario) q.getSingleResult();

		} catch (NonUniqueResultException e) {
			Query q = em.createNamedQuery(Usuario.USUARIO_LOGIN, Usuario.class);
			q.setParameter(1, usuario.getLogin());
			u = (Usuario) q.getResultList().get(0);

		} catch (NoResultException e) {
			throw new UsuarioNaoEncontrado();
		}

		em.close();
		emf.close();

		try {
			if (MD5Util.convertStringToMd5(usuario.getSenha()).equals(u.getSenha())) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			throw new SenhaInvalidaException();
		}

	}

}
