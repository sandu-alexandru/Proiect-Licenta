package com.training.quizzer.repository;

import com.training.quizzer.model.Level1;
import com.training.quizzer.model.Level2;
import com.training.quizzer.model.Level3;
import com.training.quizzer.model.Level4;
import com.training.quizzer.model.Level5;
import com.training.quizzer.model.Level6;
import com.training.quizzer.model.Level7;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface Level3Repository extends JpaRepository<Level3, Long> {

    @Query(value = "select l from Level1 l ")
    List<Level1> getLevel1Questions();

    @Query(value = "select l from Level2 l ")
    List<Level2> getLevel2Questions();

    @Query(value = "select l from Level3 l ")
    List<Level1> getLevel3Questions();

    @Query(value = "select l from Level3 l where l.domain = :domain ")
    List<Level3> getLevel3QuestionsByDomain(@Param("domain") String domain);

    @Query(value = "select l from Level4 l ")
    List<Level1> getLevel4Questions();

    @Query(value = "select l from Level5 l ")
    List<Level1> getLevel5Questions();

    @Query(value = "select l from Level6 l ")
    List<Level1> getLevel6Questions();

    @Query(value = "select l from Level7 l ")
    List<Level1> getLevel7Questions();

    @Query(value = "select d from Level3 d where d.question = :question")
    Level3 getQuestionByQuestion(@Param("question") String question);

}
