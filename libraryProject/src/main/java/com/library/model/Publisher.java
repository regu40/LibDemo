package com.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

	
	@Entity
	@Table(name = "publisher")
	public class Publisher {
	 
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "id")
	    private Long id;
	 
	    @OneToOne(mappedBy = "publisher")
	    private Book book;
	    
	    private String publisher_name;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Book getBook() {
			return book;
		}

		public void setBook(Book book) {
			this.book = book;
		}

		public String getPublisher_name() {
			return publisher_name;
		}

		public void setPublisher_name(String publisher_name) {
			this.publisher_name = publisher_name;
		}


}
