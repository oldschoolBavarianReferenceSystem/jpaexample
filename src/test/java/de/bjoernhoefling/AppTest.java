package de.bjoernhoefling;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import de.bjoernhoefling.persistence.Book;

/**
 * Unit test for simple App.
 */
public class AppTest {
    
	private EntityManagerFactory entityManagerFactory;
	@Before
	public void setUp() {
		entityManagerFactory = Persistence.createEntityManagerFactory( "org.hibernate.tutorial.jpa" );
		
	}
	@Test
	public void testTrivial() {
		assertTrue(true);
		
	}
	
	@Test
	public void testCreate() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Book book = new Book();
		book.setTitle("Java for Coffee fellowers");
		entityManager.persist(book); // new Event( "Our very first event!", new Date() ) );
		//entityManager.persist( new Event( "A follow up event", new Date() ) );
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}
}
