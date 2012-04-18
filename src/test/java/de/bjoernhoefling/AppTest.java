package de.bjoernhoefling;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.bjoernhoefling.persistence.Book;

public class AppTest {
    
	private EntityManagerFactory entityManagerFactory;

	
	/**
	 * Setup Persistence Factory
	 */
	@Before
	public void setUp() {
		entityManagerFactory = Persistence.createEntityManagerFactory( "org.hibernate.tutorial.jpa" );
		
	}
	
	/**
	 * Persists an Entity of type Book,
	 * get it back from database and check some assertions about it.
	 * 
	 */
	@Test
	public void testPersist() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		// persist a book
		Book book = new Book();
		book.setTitle("Java for Coffee fellowers");
		entityManager.persist(book);
		entityManager.getTransaction().commit();
		entityManager.close();
		
		
		//now get it back:
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<Book> result = entityManager.createQuery( "from Book", Book.class ).getResultList();
		Book resultBook = null;
		for ( Book theBook : result) {
			//TODO: Use logger instead of System.out
			System.out.println( "Book: (" + theBook.getId() + ") : " + theBook.getTitle() );
		    resultBook = theBook;
		}
		entityManager.getTransaction().commit();
		entityManager.close();

		// check result
		assertNotNull("Result list is null!", result);
		assertEquals("We expected exactly one result. This is not the case!", 1, result.size());
		assertNotNull("Result book is null!", resultBook);
		assertEquals("Book title differs!", "Java for Coffee fellowers", resultBook.getTitle());
		
	}
	
	
	/**
	 * Tear down Factory
	 * @throws Exception
	 */
	@After
    public void tearDown() throws Exception {
        entityManagerFactory.close();
}

	
	
	
}
