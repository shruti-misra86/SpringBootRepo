package com.example.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Bank_Customer_Table")
public class BankCustomer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CustomerId")
	private int custId;

	@Column(name = "FirstName", length = 10)
	private String firstName;

	@Column(name = "LastName", length = 20)
	private String lastName;

	@Column(name = "Email", length = 30)
	private String email;

	@Column(name = "Contact", length = 12)
	private String contact;

	@Column(name = "AadharNo", length = 16)
	private String aadharNo;

	@Column(name = "panNo", length = 16)
	private String panNo;

	@Column(name = "Address1", length = 60)
	private String address1;

	@Column(name = "Address2", length = 60)
	private String address2;

	@Column(name = "City", length = 15)
	private String city;

	@Column(name = "State", length = 15)
	private String state;

	@Column(name = "Gender", length = 10)
	private String gender;

	@Column(name = "DOB")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dob;

	@Column(name = "Password", length = 20)
	private String password;

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
