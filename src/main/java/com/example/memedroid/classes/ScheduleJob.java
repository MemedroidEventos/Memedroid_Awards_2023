package com.example.memedroid.classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.memedroid.repository.Repository;
import com.example.memedroid.repository.RepositoryBackup;
import com.example.memedroid.repository.RepositoryUserPlayOff;
import com.example.memedroid.service.Services;
import com.example.memedroid.user.Backup;
import com.example.memedroid.user.User;
import com.example.memedroid.user.UserPlayOff;

@Component
public class ScheduleJob {

	@Autowired
	Services service;
	
	@Autowired
	Repository repository;
	
	@Autowired
	RepositoryUserPlayOff repositoryUserPlayOff;
	
	@Autowired
	RepositoryBackup repositoryBackup;
	
		
	@Scheduled(cron = "00 00 00 08 * *")
	public void execute(){
		
		service.keyValueStore.setValue("classification", false);
		service.keyValueStore.setValue("play-off", true);

		System.out.print("\nEncerrado !");
		
		for(User user : repository.getUsers()) {			
			repositoryBackup.classification(user.getNick(), user.getVotes(), user.getVoted());
			
		}
				
		int index = 1;
		for (User user : service.getUsersClassificationsDatabase()) {
			System.out.print("\n" + user.getNick());
			
			UserPlayOff userPlayOff = new UserPlayOff();
			
			userPlayOff.setPosition(index);
			userPlayOff.setNick(user.getNick());
			userPlayOff.setScore(user.getScore());
			
			repositoryUserPlayOff.save(userPlayOff);
			index++;
		}
		
		for (User user : repository.getUsers()) {
			user.setVotes("[]");
			repository.save(user);
		}
		
	}
	
	@Scheduled(cron = " 00 00 00 9 * * ")
	@Scheduled(cron = " 00 00 00 10 * *")
	public void playoff() {

		List<UserPlayOff> list = repositoryUserPlayOff.findAll();
		List<UserPlayOff> listUserClassifications = new ArrayList<>();
		int sizeList =list.size();
		
		backup(sizeList);
		
		for(int i = 0; i < (sizeList/2);i++) {
			if(list.get(i).getVoted() > list.get((sizeList -1)-i).getVoted()) {
				list.get(i).setVoted(0);
				listUserClassifications.add(list.get(i));

			}else if(list.get(i).getVoted() == list.get((sizeList-1)-i).getVoted()) {
				if(list.get(i).getScore() > list.get((sizeList-1)-i).getScore()){
					list.get(i).setVoted(0);
					listUserClassifications.add(list.get(i));

				}else {
					list.get((sizeList-1)-i).setVoted(0);
					listUserClassifications.add(list.get((sizeList-1)-i));
				}

			} else {
				list.get((sizeList -1)-i).setVoted(0);
				listUserClassifications.add(list.get((sizeList-1)-i));

			}
		}
		
		listUserClassifications.forEach((user)->{
			System.out.print("\n username: " + user.getNick() + " position: " + user.getPosition() );
			if(user.getPosition() > sizeList/2) {
				user.setPosition((sizeList+1)-user.getPosition());
			}
			
		});
		listUserClassifications.forEach((user)->{
			System.out.print("\n username: " + user.getNick() + " position: " + user.getPosition() );
			
		});
		
		for (User user : repository.getUsers()) {
			user.setVotes("[]");
			repository.save(user);
		}
				
		repositoryUserPlayOff.deleteAll();
		repositoryUserPlayOff.saveAll(listUserClassifications);
		
		
	}
	@Scheduled(cron = " 00 00 00 11 * * ")
	public void playerWin() {
		playoff();
		service.keyValueStore.setValue("play-off", false);

	}
	public void backup(int phase) {
		
		List<Backup> list = repositoryBackup.findAll();
		
		System.out.print("\nPhase:  " + phase);

		
		if(phase == 8) {
			
			for (User user : repository.findAll()) {
				repositoryBackup.roundOf8Votes(user.getNick(), user.getVotes());
			}
			for (UserPlayOff user : repositoryUserPlayOff.findAll()) {
				repositoryBackup.roundOf8Voted(user.getNick(), user.getVoted());
			}
						
		}else if(phase == 4) {
			for (User user : repository.findAll()) {
				repositoryBackup.roundOf4Votes(user.getNick(), user.getVotes());
			}
			for (UserPlayOff user : repositoryUserPlayOff.findAll()) {
				repositoryBackup.roundOf4Voted(user.getNick(), user.getVoted());
			}
			
		} else if (phase == 2) {
			for (User user : repository.findAll()) {
				repositoryBackup.roundFinalVotes(user.getNick(), user.getVotes());
			}
			for (UserPlayOff user : repositoryUserPlayOff.findAll()) {
				repositoryBackup.roundFinalVoted(user.getNick(), user.getVoted());
			}
			
		}
		
	}
}
