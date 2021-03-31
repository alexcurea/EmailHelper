package com.emailhelper.emailhelper.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.emailhelper.emailhelper.model.enums.CandidateStatus;

@Entity
@Table(name = "candidates")
public class Candidate {

	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Id
	@Column(name = "candidate_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "first_name", nullable = false, length = 100)
	private String firstName;
	
	@Column(name = "last_name", nullable = false, length = 100)
	private String lastName;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "birth_date", nullable = false)
	private Date birthDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "candidate_status", nullable = false)
	private CandidateStatus candidateStatus;
	
	@Column(name = "city", nullable = false, length = 100)
	private String city;
	
	@Column(name = "country", nullable = false, length = 100)
	private String country;
	
	@Column(name = "phone_number", nullable = false, length = 10)
	private String phoneNumber;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@JsonIgnore
	@OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE}, mappedBy = "candidate")
	private
	List<Enrollment> enrollments = new ArrayList<Enrollment>();
	
	public Candidate() {
		
	}

	public Candidate(Candidate candidate) {
		this.setBirthDate(candidate.getBirthDate());
		this.setCandidateStatus(candidate.getCandidateStatus());
		this.setCity(candidate.getCity());
		this.setCountry(candidate.getCountry());
		this.setEmail(candidate.getEmail());
		this.setFirstName(candidate.getFirstName());
		this.setLastName(candidate.getLastName());
		this.setPhoneNumber(candidate.getPhoneNumber());
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public CandidateStatus getCandidateStatus() {
		return candidateStatus;
	}

	public void setCandidateStatus(CandidateStatus candidateStatus) {
		this.candidateStatus = candidateStatus;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
