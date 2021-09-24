package com.sean.exam.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="ideas")
public class Idea {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String iText;
	@NotBlank
	private String nText;
	@NotBlank
	private String dText;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	public Idea() {
	
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getiText() {
		return iText;
	}
	public void setiText(String iText) {
		this.iText = iText;
	}
	public String getnText() {
		return nText;
	}
	public void setnText(String nText) {
		this.nText = nText;
	}
	public String getdText() {
		return dText;
	}
	public void setdText(String dText) {
		this.dText = dText;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
