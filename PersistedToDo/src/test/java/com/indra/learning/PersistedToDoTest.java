package com.indra.learning;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

public class PersistedToDoTest {

	@Test
	public void testPersistence() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("ToDo");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		Date creationDate = new Date();
		String taskDesc = "Descripcion de la tarea";
		ToDo task = new ToDo(taskDesc, false, creationDate);

		tx.begin();
		try {
			em.persist(task);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}

		String jpql = "SELECT t FROM ToDo t";
		Query query = em.createQuery(jpql);
		List<ToDo> resultados = query.getResultList();

		assertEquals(1, resultados.size());

		ToDo t2 = resultados.get(0);
		assertEquals(task, t2);

		em.close();
		emf.close();
	}
}
