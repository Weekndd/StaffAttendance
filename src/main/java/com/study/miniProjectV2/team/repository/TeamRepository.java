package com.study.miniProjectV2.team.repository;

import com.study.miniProjectV2.team.entity.Team;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {
    @EntityGraph(attributePaths = {"teamUsers", "manager"}, type = EntityGraph.EntityGraphType.LOAD)
    List<Team> findAll();
}
