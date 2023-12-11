package com.example.memedroid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.memedroid.user.User;

@org.springframework.stereotype.Repository
public interface Repository extends CrudRepository<User, Integer> {
	
	List<User> findAll();
	
	User findByNick(String nick);
	
	@Query(value = "SELECT * FROM user",nativeQuery = true)
	List<User> getUsers();

	@Query(value = "SELECT nick FROM user WHERE voted > 0 ORDER BY voted DESC , score DESC LIMIT 8", nativeQuery = true)
	List<String>getUsersClassications();
	
	@Query(value = "SELECT * FROM user WHERE voted > 0 ORDER BY voted DESC , score DESC LIMIT 8", nativeQuery = true)
	List<User>getUsersClassicationsDataBase();
	
	@Query(value = "SELECT nick FROM user", nativeQuery = true)
	List<String> getUsersNick();
	
}
