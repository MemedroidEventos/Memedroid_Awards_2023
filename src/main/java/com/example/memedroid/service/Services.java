package com.example.memedroid.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.json.JSONArray;
import org.springframework.stereotype.Service;

import com.example.memedroid.classes.KeyValueStore;
import com.example.memedroid.classes.Vote;
import com.example.memedroid.repository.RepositoryBackup;
import com.example.memedroid.repository.RepositoryUserPlayOff;
import com.example.memedroid.user.User;
import com.example.memedroid.user.UserPlayOff;

@Service
public class Services {
	

	@Autowired
	com.example.memedroid.repository.Repository repository;
	
	@Autowired
	RepositoryUserPlayOff repositoryUserPlayOff;
	
	@Autowired
	public RepositoryBackup repositoryBackup;
	
	@Autowired
	public KeyValueStore keyValueStore;
	
	public String login(String username, String password) {
		
		User user = repository.findByNick(username);
		
		if(user == null) {
			System.out.print("\nUsuario não encontrado na lista, login invalido X\n");
			return "not registered"; 


		}else {
			if(user.getPassword().toLowerCase().equals(password)) {
				System.out.print("\nSenha correta, login valido ✔\n ");
				
				return "password correct";
			} else {
				System.out.print("\nSenha incorreta, login invalido X\n");

				return "password incorrect"; 
			}

		}
	
	}
	private Boolean validationLogin(String username , String password) {
		User user = repository.findByNick(username);

		if(user == null) {
			return false; 
		} else if(user.getNick().toLowerCase().equals(username.toLowerCase()) && user.getPassword().toLowerCase().equals(password.toLowerCase())){
			return true;
		} else{
			return false;
		}
		
	}
	
	public String vote(Vote vote) {
		
		//validationLoginL() return always "true" or "false"; 
		if(validationLogin(vote.getUsername().trim(), vote.getPassword().trim())) {
			System.out.print("\nCredenciais do login valida ✔");
			
			User user = repository.findByNick(vote.getUsername());

			JSONArray json;
			
			try {
				json = new JSONArray(user.getVotes());
				if(json.length() < 3) {
					for(int i = 0; i < json.length();i++) {
						if(json.get(i).equals(vote.getVote())) {
							System.out.print("\nVotante já votou nesse candidato, voto invalido X\n");
							return "you have already voted in this user";
						}
					}
					json.put(vote.getVote());
					
					user.setVotes(json.toString());
					
					repository.save(user);
					
					User userVoted = repository.findByNick(vote.getVote());
					userVoted.setVoted((userVoted.getVoted() + 1));
					
					repository.save(userVoted);
					System.out.print("\nVoto computado com sucesso, voto valido ✔\n");
					return "vote counted";
					
				} else {
					System.out.print("\nO Vontante não possuí mais votos, voto invalido X\n");
					return "votes sold out";
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.print("\nHouve algum problema no código\n");
				return "erro";
			}
			
		} else {
			System.out.print("\nCredenciais do login invalidas X\n");
			return "error login";
		}
		
	}
	
	public List<User> getUsersClassificationsDatabase(){
		
		return repository.getUsersClassicationsDataBase(); 
	}
	
	public List<String> getUsersClassifications(){
		
		return repository.getUsersClassications(); 
	}
	
	public List<User> findAll(){
		
		return repository.getUsers();
	}
	
	public List<String> getUsers(){
		
		List<String> list = repository.getUsersNick();
		Collections.shuffle(list);
		
		return list;
	}
	
	public List<String> getUsersPlayOff(){
		
		return repositoryUserPlayOff.findAllNick(); 
	}
	
	public String votePlayOff(Vote vote) {
		
		if(!validationLogin(vote.getUsername(), vote.getPassword() )) {
			System.out.print("\nCredenciais do login invalidas X\n");

			return "error login";
		}
		System.out.print("\nCredenciais do login valida ✔");

		User user = repository.findByNick(vote.getUsername());
		
		UserPlayOff userPlayOffVoting = repositoryUserPlayOff.findByNick(vote.getVote());
		
		if(userPlayOffVoting == null) {
			System.out.print("\nEsse usuário  não existe, voto invalido X\n");
			return "erro user null"; 
		}
		
		UserPlayOff userPlayOffEnemy = repositoryUserPlayOff.findByPosition(( (int)repositoryUserPlayOff.count() + 1) - userPlayOffVoting.getPosition());
				
		
		JSONArray json; 
		try {
			
			json = new JSONArray(user.getVotes());

			for(int i =0; i < json.length();i++) {
				if(json.get(i).equals(userPlayOffVoting.getNick().toLowerCase())) {
					System.out.print("\nVotante já votou nesse candidato, voto invalido X\n");
					return "you have already voted in this user";

				} else if(json.get(i).equals(userPlayOffEnemy.getNick().toLowerCase())) {
					System.out.print("\nVotante votou no adversário, voto invalido X\n");
					return "you have already voted in this enemy user";
				}

			}
				
			json.put(vote.getVote());
			
			user.setVotes(json.toString());
			
			repository.save(user);
			
			UserPlayOff userVoted = repositoryUserPlayOff.findByNick(vote.getVote());
			userVoted.setVoted((userVoted.getVoted() + 1));
			
			repositoryUserPlayOff.save(userVoted);
			
			System.out.print("\nVoto computado com sucesso, voto valido ✔\n");

			return "vote counted";
			
		}catch(Exception e) {
			System.out.print("\nHouve algum problema no código\n");
			e.printStackTrace();
			return "erro";
		}
				
	}
	
	public String getWinner() {
		
		return repositoryUserPlayOff.findNickByPosition(1);
	}
	
}
