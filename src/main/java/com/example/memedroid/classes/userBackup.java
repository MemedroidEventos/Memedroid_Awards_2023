package com.example.memedroid.classes;

public class userBackup {

	private String nick;

	private int voted;

	public userBackup(String nick, int voted) {
		this.nick = nick;
		this.voted = voted;
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
