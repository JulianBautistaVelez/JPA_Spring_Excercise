package com.julian.bootmvchibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.julian.bootmvchibernate.model.User;

@Entity
@Table(name="POSTS")
public class Post {

	@Id
	@GeneratedValue
	@Column(name="POST_ID")
	private int id;
	
	@Column(name="tittle")
	private String tittle;
	
	@Column(name="text")
	private String text;
	
	@ManyToOne
	@JoinColumn(name="USER_ID",referencedColumnName="USER_ID")
	private User user;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", tittle=" + tittle +  ", text=" + text + "]\n";
	}
	
}
