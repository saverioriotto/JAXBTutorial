package com.saverioriotto;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"Name", "Surname", "Age", "Username", "Email"})
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class User {
	
	@XmlAttribute	
	int id;
	
	@XmlElement(name = "name")
	String Name;
		
	@XmlElement(name = "surname")
	String Surname;
	
	@XmlElement(name = "age")
	int Age;
	
	@XmlElement(name = "email")
	String Email;
	
	@XmlElement(name = "username")
	String Username;
	
	@XmlTransient()
	String Phone;
	
	public User() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSurname() {
		return Surname;
	}

	public void setSurname(String surname) {
		Surname = surname;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}	
	
	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String toString() {
		
		 return "User{" +
			     "id=" + id +
			     ", name ='" + Name + '\'' +
			     ", surname ='" + Surname + '\'' +
			     ", age ='" + Age + '\'' +
			     ", email ='" + Email + '\'' +
			     ", username ='" + Username + '\'' +
			     ", phone ='" + Phone + '\'' +
			     '}';
	}
	
	
}
