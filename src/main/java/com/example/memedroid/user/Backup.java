package com.example.memedroid.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Backup {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String nick;
	
	@Column
	private String classificationVotes;
	
	@Column
	private Integer classificationVoted;
	
	@Column
	private String roundOf8Votes;
	
	@Column
	private Integer roundOf8Voted;
	
	@Column
	private String roundOf4Votes;
	
	@Column
	private Integer roundOf4Voted;
	
	@Column
	private String roundFinalVotes;
	
	@Column
	private Integer roundFinalVoted;

	public Integer getId() {
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

	public String getClassificationVotes() {
		return classificationVotes;
	}

	public void setClassificationVotes(String classificationVotes) {
		this.classificationVotes = classificationVotes;
	}

	public Integer getClassificationVoted() {
		return classificationVoted;
	}

	public void setClassificationVoted(int classificationVoted) {
		this.classificationVoted = classificationVoted;
	}

	public String getRoundOf8Votes() {
		return roundOf8Votes;
	}

	public void setRoundOf8Votes(String roundOf8Votes) {
		this.roundOf8Votes = roundOf8Votes;
	}

	public Integer getRoundOf8Voted() {
		return roundOf8Voted;
	}

	public void setRoundOf8Voted(int roundOf8Voted) {
		this.roundOf8Voted = roundOf8Voted;
	}

	public String getRoundOf4Votes() {
		return roundOf4Votes;
	}

	public void setRoundOf4Votes(String roundOf4Votes) {
		this.roundOf4Votes = roundOf4Votes;
	}

	public Integer getRoundOf4Voted() {
		return roundOf4Voted;
	}

	public void setRoundOf4Voted(int roundOf4Voted) {
		this.roundOf4Voted = roundOf4Voted;
	}

	public String getRoundFinalVotes() {
		return roundFinalVotes;
	}

	public void setRoundFinalVotes(String roundFinalVotes) {
		this.roundFinalVotes = roundFinalVotes;
	}

	public Integer getRoundFinalVoted() {
		return roundFinalVoted;
	}

	public void setRoundFinalVoted(int roundFinalVoted) {
		this.roundFinalVoted = roundFinalVoted;
	}

}
