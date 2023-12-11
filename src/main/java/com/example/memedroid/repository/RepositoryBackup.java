package com.example.memedroid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.memedroid.classes.userBackup;
import com.example.memedroid.user.Backup;

@Repository
public interface RepositoryBackup extends JpaRepository<Backup, Integer> {
	
	List<Backup> findAll();
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO backup (nick, classification_votes , classification_voted ) VALUES (:Nick , :Votes , :Voted)",
			nativeQuery = true)
	void classification(@Param("Nick") String Nick, @Param("Votes") String Votes ,  @Param("Voted") int Voted );
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE backup SET round_of8votes = :Votes WHERE nick = :Nick",
			nativeQuery = true)
	void roundOf8Votes(@Param("Nick") String Nick , @Param("Votes") String round_of8votes);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE backup SET round_of8voted = :Voted WHERE nick = :Nick",
			nativeQuery = true)
	void roundOf8Voted(@Param("Nick") String Nick , @Param("Voted") int round_of8voted);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE backup SET round_of4votes = :Votes WHERE nick = :Nick",
			nativeQuery = true)
	void roundOf4Votes(@Param("Nick") String Nick , @Param("Votes") String round_of4votes);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE backup SET round_of4voted = :Voted WHERE nick = :Nick",
			nativeQuery = true)
	void roundOf4Voted(@Param("Nick") String Nick , @Param("Voted") int round_of4voted);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE backup SET round_final_votes = :Votes WHERE nick = :Nick",
			nativeQuery = true)
	void roundFinalVotes(@Param("Nick") String Nick , @Param("Votes") String round_final_votes);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE backup SET round_final_voted = :Voted WHERE nick = :Nick",
			nativeQuery = true)
	void roundFinalVoted(@Param("Nick") String Nick , @Param("Voted") int round_final_votes);
	
	@Query(value = "SELECT * FROM backup ORDER BY classification_voted DESC", nativeQuery = true)
	List<Backup> getClassificationBackup ();
	
	@Query(value = "SELECT * FROM backup WHERE round_of8voted IS NOT NULL ORDER BY round_of8voted DESC", nativeQuery = true)
	List<Backup> getRound8 ();	
	
	@Query(value = "SELECT * FROM backup WHERE round_of4voted IS NOT NULL ORDER BY round_of4voted DESC", nativeQuery = true)
	List<Backup> getRound4 ();	
	
	@Query(value = "SELECT * FROM backup WHERE round_final_voted IS NOT NULL ORDER BY round_final_voted DESC", nativeQuery = true)
	List<Backup> getRoundFinal ();	

}
