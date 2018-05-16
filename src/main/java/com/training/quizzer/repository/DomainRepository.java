package com.training.quizzer.repository;

import com.training.quizzer.model.Domain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DomainRepository extends JpaRepository<Domain, Long> {

    @Query(value = "select d.name from Domain d")
    List<String> getDomains();

    @Query(value = "select d from Domain d where d.name = :name")
    Domain getDomainByName(@Param("name") String name);
}
