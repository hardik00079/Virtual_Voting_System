package com.fdmgroup.vvs.service;



import java.util.List;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



import com.fdmgroup.vvs.model.Vote;

import com.fdmgroup.vvs.repository.VoteRepository;



@Service

public class VoteService {

    private VoteRepository voteRepository;



    @Autowired

    public VoteService(VoteRepository voteRepository) {

        super();

        this.voteRepository = voteRepository;

    }

    

    public List<Vote> getVotes() {

        return voteRepository.findAll();

    }



    public Vote getVote(int id) {

        Optional<Vote> voteOptional = voteRepository.findById(id);

        if(!voteOptional.isPresent()) {

            throw new VoteNotFoundException("Vote with id " + id + " was not found");

        }

        return voteOptional.get();

    }



    public Vote createVote(Vote incomingVote) {

        return voteRepository.save(incomingVote);

    }

    

    public void deleteVote(int id) {

        voteRepository.deleteById(id);

    }



//    public List<Vote> getVotesByCandidateId(int candidateId) {

//        return voteRepository.findVoteByCandidateId(candidateId);

//    }

}
