package de.bjoernhoefling.persistence;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="BOOK")
public class Book {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	protected long id;
	
	@Basic
	protected String title;

	@Basic
	protected String isbn;

	@Basic
	protected int numpages;
	
	@Lob
	protected String summary;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getNumpages() {
		return numpages;
	}

	public void setNumpages(int numpages) {
		this.numpages = numpages;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	//TODO: add language entry
	//protected Language lang;
	
}
