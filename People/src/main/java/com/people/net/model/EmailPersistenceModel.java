package com.people.net.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_mails")
public class EmailPersistenceModel {
	
	
	@Id
    @Column(name = "id")
    @GeneratedValue
    private int id;
	
	@Column(name = "email_type")
	private String emailType;
	
	@Column(name = "email")
	private String email;
	
	@JoinColumn(name="t_people_id")
	@OneToOne(cascade = CascadeType.ALL)
	private PersonPersistenceModel person;
	

	public EmailPersistenceModel() {
		super();
	}
	
	public EmailPersistenceModel(int id, String emailType, String email, PersonPersistenceModel person) {
		super();
		this.id = id;
		this.emailType = emailType;
		this.email = email;
		this.person = person;
	}

	
	
	

	public String getEmailType() {
		return emailType;
	}

	public void setEmailType(String emailType) {
		this.emailType = emailType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public PersonPersistenceModel getPerson() {
		return person;
	}

	public void setPerson(PersonPersistenceModel person) {
		this.person = person;
	}

	
	
}
