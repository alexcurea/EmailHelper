package com.emailhelper.emailhelper.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "emails")
public class FeedbackDto {
	
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Id
	@Column(name = "email_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "adress", nullable = false)
	private String adress;
	
	@Column(name = "subject", nullable = false)
	private String subject;
	
	@Column(name = "content", nullable = false)
	private String content;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "timestamp", nullable = false)
	private Date timestamp;
	
	public FeedbackDto() {
		
	}
	
	public FeedbackDto(FeedbackDto feedback) {
		this.id = feedback.getId();
		this.adress = feedback.getAdress();
		this.subject = feedback.getSubject();
		this.content = feedback.getContent();
		this.timestamp = feedback.getTimestamp();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
