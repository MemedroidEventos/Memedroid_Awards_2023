package com.example.memedroid.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;


@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private int id;
	
	@Column
	private String nick;
	
	@Column
	@JsonIgnore
	private String password;
	
	@Column(columnDefinition = "VARCHAR(255) DEFAULT '[]' ")
	@JsonIgnore
	private String votes ="{[]}";
	
	@Column
	@JsonIgnore
	private int score;
	
	@Column(columnDefinition = "INTEGER DEFAULT 0")
	@JsonIgnore
	private int voted;
	
    public int getVoted() {
		return voted;
	}

	public void setVoted(int voted) {
		this.voted = voted;
	}

	@PrePersist
    public void prePersist() {
        
       this.votes = "{[]}";
        
    }

	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVotes() {
		return votes;
	}

	public void setVotes(String votes) {
		this.votes = votes;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
}
