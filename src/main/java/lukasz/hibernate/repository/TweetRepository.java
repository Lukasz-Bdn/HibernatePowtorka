package lukasz.hibernate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import lukasz.hibernate.entity.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long>{
	List<Tweet> findAllByUserId(long id);
	@Query("SELECT t FROM Tweet t WHERE title LIKE :start%")
	List<Tweet> findStartingWith(@Param(value = "start") String start);
}