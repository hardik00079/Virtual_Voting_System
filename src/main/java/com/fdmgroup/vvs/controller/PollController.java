package com.fdmgroup.vvs.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fdmgroup.vvs.model.Poll;
import com.fdmgroup.vvs.model.User;
import com.fdmgroup.vvs.service.PollService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/polls")
public class PollController {
	private PollService pollService;

	@Autowired
	public PollController(PollService pollService) {
		super();
		this.pollService = pollService;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/")
	public ResponseEntity<List<Poll>> getAll(){
		return ResponseEntity.ok(pollService.retrievePolls());
	}
	
	@RequestMapping("/id/{id}")
	public ResponseEntity<Poll> findById(@PathVariable int id){
		return ResponseEntity.ok(pollService.retrievePoll(id));
	}
	
	@RequestMapping("/pollName/{pollName}")
	public ResponseEntity<Poll> findByPollName(@PathVariable String pollName){
		return ResponseEntity.ok(pollService.findUserByPollName(pollName));
	}
	
	@PostMapping
	public ResponseEntity<Poll> createPoll(@Valid@RequestBody Poll poll){
		Poll createdPoll = pollService.createPoll(poll);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(createdPoll.getPollId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Poll> updatePoll(@Valid@RequestBody Poll poll){
		pollService.updatePoll(poll);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public void deletePoll(@PathVariable int id) {
		pollService.deletePollById(id);
	}
}
