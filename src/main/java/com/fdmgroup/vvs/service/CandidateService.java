package com.fdmgroup.vvs.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//
//import com.fdmgroup.vvs.model.Candidate;
//import com.fdmgroup.vvs.model.CandidatePosition;
//import com.fdmgroup.vvs.model.Poll;
//import com.fdmgroup.vvs.model.User;
//import com.fdmgroup.vvs.repository.CandidateRepository;

//@Service
//public class CandidateService {
//	private CandidateRepository candidateRepository;
//	
//	@Autowired
//	public CandidateService(CandidateRepository candidateRepository) {
//		super();
//		this.candidateRepository = candidateRepository;
//	}
//	public List<User> retrieveAllCandidates() {
//		return candidateRepository.findAll();
//	}
//
//	public Candidate retrieveCandidateByPoll(int pollId) throws CandidateNotFoundException {
//		Optional<User> candidate = candidateRepository.findUserById(pollId) ;
//		if(!candidate.isPresent()) {
//			throw new CandidateNotFoundException(candidateId+" is not found");
//		}
//		return candidate.get();
//	}
//	public Candidate addCandidate(User user, Poll poll) {
//		return candidateRepository.save(user, poll);
//	}
//	

//	public Candidate updateCandidate(Candidate candidate) {
//		return candidateRepository.save(candidate);
//	}

//	public void deleteCandidate(int candidateId) {
//		candidateRepository.deleteById(candidateId);
//	}

//}
