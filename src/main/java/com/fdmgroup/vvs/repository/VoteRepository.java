package com.fdmgroup.vvs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.vvs.model.Vote;

public interface VoteRepository extends JpaRepository<Vote, Integer>{
//  List<Vote> findVoteByCandidateId(int id);
}
