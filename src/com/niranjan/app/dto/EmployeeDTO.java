package com.niranjan.app.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="employee")
public class EmployeeDTO implements Serializable {
	
	@Id
	@Column(name="id") 
	@GenericGenerator(name="custom",strategy="increment")
	@GeneratedValue(generator="custom")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="dob")
	private Date dob;
	
	@Column(name="salary")
	private long salary;
	
	@Column(name="isPermanent")
	private boolean isPermanent;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="address_id")
	private Set<AddressDTO> addresses;
	
	public EmployeeDTO(){
		System.out.println(this.getClass().getSimpleName()+" created...");
	}


	@Override
	public String toString() {
		return "EmployeeDTO [id=" + id + ", name=" + name + ", dob=" + dob + ", salary=" + salary + ", isPermanent="
				+ isPermanent + ", addresses=" + addresses + "]";
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public boolean isPermanent() {
		return isPermanent;
	}

	public void setPermanent(boolean isPermanent) {
		this.isPermanent = isPermanent;
	}

	public Set<AddressDTO> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<AddressDTO> addresses) {
		this.addresses = addresses;
	}
	

}
