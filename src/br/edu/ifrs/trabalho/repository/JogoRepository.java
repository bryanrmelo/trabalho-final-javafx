package br.edu.ifrs.trabalho.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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

	public static void remove(Jogo jogo) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("games");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.remove(jogo);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}

}
