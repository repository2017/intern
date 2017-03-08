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
@Table(name = "t_addresses")
public class AddressPersistenceModel {
	
	
	@Id
    @Column(name = "id")
    @GeneratedValue
    private int id;
	
	@Column(name = "addr_type")
	private String addrType;
	
	@Column(name = "addr_info")
	private String addrInfo;
	
	@JoinColumn(name="t_people_id")
	@OneToOne(cascade = CascadeType.ALL)
	private PersonPersistenceModel person;
	

	public AddressPersistenceModel() {
		super();
	}
	
	public AddressPersistenceModel(int id, String addrType, String addrInfo, PersonPersistenceModel person) {
		super();
		this.id = id;
		this.addrType = addrType;
		this.addrInfo = addrInfo;
		this.person = person;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddrType() {
		return addrType;
	}

	public void setAddrType(String addrType) {
		this.addrType = addrType;
	}

	public String getAddrInfo() {
		return addrInfo;
	}

	public void setAddrInfo(String addrInfo) {
		this.addrInfo = addrInfo;
	}

	public PersonPersistenceModel getPerson() {
		return person;
	}

	public void setPerson(PersonPersistenceModel person) {
		this.person = person;
	}


	
	
	
	
}
