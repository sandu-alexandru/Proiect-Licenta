package com.training.quizzer.repository;

import com.training.quizzer.model.User;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Query(value = "select u from User u where u.name = :name and u.password = :password ")
//	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value = "true") })
	User findByNameAndPassword(@Param("name") String name, @Param("password")String password);

	User findByName(String userName);
}
