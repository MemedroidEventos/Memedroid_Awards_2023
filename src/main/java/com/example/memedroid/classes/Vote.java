package com.example.memedroid.classes;


public class Vote {
	
	private String username;
	private String password;
	private String vote;


	public Vote(String username, String password, String vote) {
		this.username = username;
		this.password = password;
		this.vote = vote;
	}


	public String getUsername() {
		return username.trim();
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password.trim();
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getVote() {
		return vote.trim();
	}


	public void setVote(String vote) {
		this.vote = vote;
	}


	
	
}
