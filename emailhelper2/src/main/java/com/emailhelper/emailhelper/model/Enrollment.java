package com.emailhelper.emailhelper.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.emailhelper.emailhelper.model.enums.EnrollmentStatus;
import com.emailhelper.emailhelper.model.enums.EnrollmentType;

@Entity
@Table(name = "enrollments")
public class Enrollment {
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Id
	@Column(name = "enrollment_id", unique = true, nullable = false)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "enrollment_type", nullable = false)
	private EnrollmentType enrollmentType;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "enrollment_status", nullable = false)
	private EnrollmentStatus enrollmentStatus;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "enrollment_date", nullable = false)
	private Date enrollmentDate;
	
	@ManyToOne(optional = false, cascade = {CascadeType.MERGE},fetch = FetchType.EAGER)
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
	public Enrollment() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EnrollmentType getEnrollmentType() {
		return enrollmentType;
	}

	public void setEnrollmentType(EnrollmentType enrollmentType) {
		this.enrollmentType = enrollmentType;
	}

	public EnrollmentStatus getEnrollmentStatus() {
		return enrollmentStatus;
	}

	public void setEnrollmentStatus(EnrollmentStatus enrollmentStatus) {
		this.enrollmentStatus = enrollmentStatus;
	}

	public Date getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(Date enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

}
