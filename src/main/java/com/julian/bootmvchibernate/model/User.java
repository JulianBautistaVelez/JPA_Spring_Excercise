package com.julian.bootmvchibernate.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.julian.bootmvchibernate.model.Post;

@Entity
@Table(name = "USERS")
public class User {
	@Id
	@GeneratedValue
	@Column( name ="USER_ID")
	private int id;
	
	@Column( name ="username")
	private String username;
	
	@Column( name ="password")
	private String password;
	
	@Column( name ="email")
	private String email;
	
	@OneToMany(fetch= FetchType.LAZY, mappedBy="user", cascade = CascadeType.ALL)
    private List<Post> posts;
	
	
	public User() {
		super();
	}
	//@OneToMany(cascade = CascadeType.ALL, mappedBy="userIdPost")
    //@JoinColumn(name = "user_id")
	//private List<Post> posts;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email +"]\n";
	}

	
	
	
	
}
