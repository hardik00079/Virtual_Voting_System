package com.fdmgroup.vvs.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fdmgroup.vvs.model.Candidate;
import com.fdmgroup.vvs.service.CandidateNotFoundException;


//
//@CrossOrigin(origins = "http://localhost:4200")
//@RestController
//public class CandidateController {
//	private CandidateService candidateService;
//
//	@Autowired
//	public CandidateController(CandidateService candidateService) {
//		super();
//		this.candidateService = candidateService;
//	}
//	
//	@GetMapping
//	public ResponseEntity<List<Candidate>> getCandidats(){
//		List<Candidate> candidates = candidateService.retrieveAllCandidates();
//		return ResponseEntity.ok(candidates);
//	}
//	@GetMapping("/{id}")
//	public ResponseEntity<Candidate> getCandidatebyId(@PathVariable("id") int candidatId ) throws CandidateNotFoundException{
//		Candidate candidate = candidateService.retrieveCandidateById(candidatId);
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
//		return ResponseEntity.created(location).body(candidate);
//	}
//	
//	@PostMapping
//	public ResponseEntity<Candidate> addCandidate(@RequestBody Candidate candidate){
//		Candidate newCandidate = candidateService.addCandidate(candidate);
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newCandidate.getCandidateId()).toUri();
//		
//		return ResponseEntity.created(location).body(newCandidate);
//	}
//	
//	@PutMapping("/{id}")
//	public ResponseEntity<Candidate> updateCandidate(@PathVariable("id") int candidateId, @RequestBody Candidate candidate){
//		Candidate updateCandidate = candidateService.updateCandidate(candidate);
//		return ResponseEntity.ok().build();
//	}
//	
//	@DeleteMapping("/{id}")
//	public void deleteCandidate(@PathVariable("id") int candidateId)
//	{
//		candidateService.deleteCandidate(candidateId);
//	}
//}
