package com.example.memedroid.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.memedroid.classes.userBackup;
import com.example.memedroid.service.Services;
import com.example.memedroid.user.Backup;

@Controller
public class PageController implements ErrorController{

	
	@Autowired
	Services service;
		

	@GetMapping("/")
	public ModelAndView home() {
		
		ModelAndView model; 
		
		if((Boolean)service.keyValueStore.getValue("classification")) {
			model = new ModelAndView("PAGES/index.html");
			model.addObject("users",service.getUsers());
			model.addObject("UsersClassifications",service.getUsersClassifications());
			
		}else if ((Boolean)service.keyValueStore.getValue("play-off")){			
			model = new ModelAndView("PAGES/playoff.html");
			
			List<List<String>> list = new ArrayList<>();
			List<String> listUser = service.getUsersPlayOff();
			int listSize = listUser.size();
			
			for(int i = 0;i < listSize/2; i++ ) {
				list.add( Arrays.asList(listUser.get(i),listUser.get((listSize-1)-i)));
			}
						
			model.addObject("userPlayOff",list);

			
		} else {

			String user = service.getWinner();
			
			model = new ModelAndView("PAGES/winPage.html");
			
			model.addObject("userWinner",user);
			
			
					
			model.addObject("final",service.repositoryBackup.getRoundFinal() );
			model.addObject("round_4",service.repositoryBackup.getRound4());
			model.addObject("round_8",service.repositoryBackup.getRound8() );
			model.addObject("classification",service.repositoryBackup.getClassificationBackup());

		}
		
		return model;
		
	}

	@GetMapping("/rules")
	public String rules() {
	
		
		return "PAGES/rules.html";
	}
	
    @RequestMapping("/error")
    public String handleError() {
        return "PAGES/PageError404.html";
    }
	
}
