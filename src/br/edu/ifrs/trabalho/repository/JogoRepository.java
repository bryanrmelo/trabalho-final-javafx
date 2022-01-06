package br.edu.ifrs.trabalho.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import br.edu.ifrs.trabalho.model.Jogo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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

	@SuppressWarnings("unchecked")
	public static ObservableList<Jogo> buscarTodos() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("games");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query q = entityManager.createNamedQuery(Jogo.TODOS);

		ObservableList<Jogo> jogos = FXCollections.observableArrayList(q.getResultList());

		entityManager.close();
		entityManagerFactory.close();

		return jogos;

	}

}
