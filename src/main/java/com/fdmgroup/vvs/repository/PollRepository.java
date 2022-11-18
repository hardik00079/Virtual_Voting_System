package com.fdmgroup.vvs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.vvs.model.Poll;
import com.fdmgroup.vvs.model.User;

public interface PollRepository extends JpaRepository<Poll, Integer>{
	Optional<Poll> findByPollName(String pollName);
}
