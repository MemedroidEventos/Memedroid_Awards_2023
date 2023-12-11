package com.example.memedroid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.memedroid.classes.Vote;
import com.example.memedroid.service.Services;
import com.example.memedroid.user.User;
import com.example.memedroid.user.UserPlayOff;

@RestController
public class Controller {
		
	@Autowired
	private Services service;

	@GetMapping("/getusers")
	public List<User> hello() {
						
		return service.findAll();
	}
	
	@PostMapping("/login/{username},{password}")
	public String login(@PathVariable String username ,@PathVariable String password ) {
		
		System.out.print("\nSolicitação de login recebida\n"
				+ " - Username: " + username + "\n"
				+ " - Password: " + password + "\n" );

		return service.login(username,password);
	}
	
	@PostMapping("/vote")
	public String vote(@RequestBody Vote vote) {
		System.out.print("\nSolicitação de voto recebida para votação de voto geral\n"
				+ " - Username: " + vote.getUsername() + "\n"
				+ " - Password: " + vote.getPassword() + "\n"
				+ " - Vote: " + vote.getVote() + "\n");

		if((Boolean)service.keyValueStore.getValue("classification")) {
			return service.vote(vote);
			
		}else {
			return "voting closed";
		}
		 
	}
	
	@PostMapping("/playoff/vote")
	public String playOffVote(@RequestBody Vote vote) {
		System.out.print("\nSolicitação de voto recebida para mata-mata\n"
				+ " - Username: " + vote.getUsername() + "\n"
				+ " - Password: " + vote.getPassword() + "\n"
				+ " - Vote: " + vote.getVote() + "\n");
		if((Boolean)service.keyValueStore.getValue("play-off")) {
			return service.votePlayOff(vote);			
		} else {
			return "voting closed";
		}
		
	}
	
}
