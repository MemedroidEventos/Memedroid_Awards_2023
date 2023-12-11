package com.example.memedroid.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserPlayOff {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore	
	private int id;

	@Column
	private int position;
	
	@Column
	private String nick;
	
	@Column(columnDefinition = "INTEGER DEFAULT 0")
	@JsonIgnore
	private int voted;
	
	@Column
	@JsonIgnore
	private int score;
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public int getVoted() {
		return voted;
	}

	public void setVoted(int voted) {
		this.voted = voted;
	}

	
	
}
