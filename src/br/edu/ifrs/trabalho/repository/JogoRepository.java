package br.edu.ifrs.trabalho.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import br.edu.ifrs.trabalho.model.Jogo;

public class JogoRepository {

	public static void adiciona(Jogo jogo) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("games");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(jogo);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}

	public void remove(Jogo jogo) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("games");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.remove(entityManager.getReference(Jogo.class, jogo.getId()));
		// entityManager.remove(jogo);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}

	@SuppressWarnings("unchecked")
	public List<Jogo> buscarTodos() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("games");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query q = entityManager.createNamedQuery(Jogo.TODOS, Jogo.class);

		List<Jogo> jogos = q.getResultList();

		entityManager.close();
		entityManagerFactory.close();

		return jogos;

	}

}
