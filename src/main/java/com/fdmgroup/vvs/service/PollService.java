package com.fdmgroup.vvs.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.vvs.model.Poll;
import com.fdmgroup.vvs.model.User;
import com.fdmgroup.vvs.repository.PollRepository;

@Service
public class PollService {
	private PollRepository pollRepository;

	@Autowired
	public PollService(PollRepository pollRepository) {
		super();
		this.pollRepository = pollRepository;
	}
	
	public List<Poll> retrievePolls() {
		
		return pollRepository.findAll();
	}

	public Poll retrievePoll(int id) {
		
		Optional<Poll> optPoll = pollRepository.findById(id);
		
		if(!optPoll.isPresent()) {
			throw new NullPointerException("Poll with id " + id + " not found");
		} else {
			return optPoll.get();
		}
		
	}
	
	public Poll findUserByPollName(String pollName) {
		Optional<Poll> poll = pollRepository.findByPollName(pollName);
		
		if(poll.isPresent()) return poll.get();
		
		throw new NullPointerException("User not found.");
	}

	public Poll createPoll(@Valid Poll poll) {
		
		return pollRepository.save(poll);
	}

	public void updatePoll(Poll poll) {
		// TODO Auto-generated method stub
		pollRepository.save(poll);
	}

	public void deletePollById(int id) {
		// TODO Auto-generated method stub
		pollRepository.deleteById(id);
	}
	
}
