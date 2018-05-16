package com.training.quizzer.repository;

import com.training.quizzer.model.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface Level1Repository extends JpaRepository<Level1, Long> {

    @Query(value = "select l from Level1 l ")
    List<Level1> getLevel1Questions();

    @Query(value = "select l from Level1 l where l.domain = :domain ")
    List<Level1> getLevel1QuestionsByDomain(@Param("domain") String domain);

    @Query(value = "select l from Level2 l where l.domain = :domain ")
    List<Level2> getLevel2QuestionsByDomain(@Param("domain") String domain);

    @Query(value = "select l from Level3 l where l.domain = :domain ")
    List<Level3> getLevel3QuestionsByDomain(@Param("domain") String domain);

    @Query(value = "select l from Level4 l where l.domain = :domain ")
    List<Level4> getLevel4QuestionsByDomain(@Param("domain") String domain);

    @Query(value = "select l from Level5 l where l.domain = :domain ")
    List<Level5> getLevel5QuestionsByDomain(@Param("domain") String domain);

    @Query(value = "select l from Level6 l where l.domain = :domain ")
    List<Level6> getLevel6QuestionsByDomain(@Param("domain") String domain);

    @Query(value = "select l from Level7 l where l.domain = :domain ")
    List<Level7> getLevel7QuestionsByDomain(@Param("domain") String domain);

    @Query(value = "select l from Level2 l ")
    List<Level2> getLevel2Questions();

    @Query(value = "select l from Level3 l ")
    List<Level1> getLevel3Questions();

    @Query(value = "select l from Level4 l ")
    List<Level1> getLevel4Questions();

    @Query(value = "select l from Level5 l ")
    List<Level1> getLevel5Questions();

    @Query(value = "select l from Level6 l ")
    List<Level1> getLevel6Questions();

    @Query(value = "select l from Level7 l ")
    List<Level1> getLevel7Questions();

    @Query(value = "select d from Level1 d where d.question = :question")
    Level1 getQuestionByQuestion(@Param("question") String question);

    void save(User user);
}
