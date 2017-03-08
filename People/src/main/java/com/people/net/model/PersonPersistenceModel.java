package com.people.net.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_people")
public class PersonPersistenceModel {
	
	
	@Id
    @Column(name = "id")
    @GeneratedValue
    private int id;
	
	@Column(name = "full_name")
	private String name;
	
	@Column(name = "pin")
	private String pin;
	
	
	

	public PersonPersistenceModel() {
		super();
	}

	public PersonPersistenceModel(int id, String name, String pin) {
		super();
		this.id = id;
		this.name = name;
		this.pin = pin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}
	
	
	
}
