package com.example.memedroid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.memedroid.user.UserPlayOff;

@Repository
public interface RepositoryUserPlayOff extends CrudRepository<UserPlayOff, Integer>{
	
	@Query(value = "SELECT Nick FROM user_play_off",nativeQuery = true)
	List<String> findAllNick();
	
	List<UserPlayOff> findAll();

	UserPlayOff findByNick(String nick);
	
	UserPlayOff findByPosition(int position);
	
	@Query(value = "SELECT nick FROM user_play_off WHERE position = :position",nativeQuery = true)
	String findNickByPosition(@Param("position")int position);
	
	long count();
}
