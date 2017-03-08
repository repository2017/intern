package com.people.net;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.NumberFormat;


/**
 *  That is the command object DTO
 *  used to transfer data in the most comfortable way
 *  doing validation too
 * 
 * @author nikolai
 *
 */
public class UserInfo {
	//Unicode check
	@Pattern(regexp="^[\\p{L}0-9]*$", message="latin chars chars max 90")
	String name;
	int id;

	@Pattern(regexp="(^$|[0-9]{10})", message="minLength=maxLength=10 only numbers")
	String pin;
	
	@Email
	String email;

	@Size(max=5, message="5 chars max")
	String emailType;
	@Size(max=5, message="5 chars max")
	String addressType;

	@Size(max=300, message="5 chars max")
	String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Its a custom contructor for custom page.
	 * There are some security issues that will
	 *  be covered in a later version
	 * @param name
	 * @param pin
	 */
	public UserInfo(String name, String pin, String id) {
		super();
		this.id = Integer.parseInt(id);
		this.name = name;
		this.pin = pin;
	}
	public UserInfo(int id,String name, String pin, String email, String emailType, String addressType, String address) {
		super();
		this.id = id;
		this.name = name;
		this.pin = pin;
		this.email = email;
		this.emailType = emailType;
		this.addressType = addressType;
		this.address = address;
	}
	public UserInfo() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmailType() {
		return emailType;
	}
	public void setEmailType(String emailType) {
		this.emailType = emailType;
	}
	public String getAddressType() {
		return addressType;
	}
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
