package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int age;
	private String emailAddress;

	public Student() {	}

	public Student(int id, String name, int age, String emailAddress) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.emailAddress = emailAddress;
	}

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
}
