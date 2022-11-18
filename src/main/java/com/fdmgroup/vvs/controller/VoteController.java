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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fdmgroup.vvs.model.Vote;
import com.fdmgroup.vvs.service.VoteService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/votes")
public class VoteController {
    private VoteService voteService;

    @Autowired
    public VoteController(VoteService voteService) {
        super();
        this.voteService = voteService;
    }

    @GetMapping
    public ResponseEntity<List<Vote>> getAllVotes() {
        List<Vote> votes = voteService.getVotes();
        return ResponseEntity.ok(votes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vote> getVote(@PathVariable("id") int id) {
        Vote vote = voteService.getVote(id);
        URI locationUri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        return ResponseEntity.created(locationUri).body(vote);
    }

    @PostMapping()
    public ResponseEntity<Vote> createVote(Vote incomingVote) {
        Vote createdVote = voteService.createVote(incomingVote);
        URI voteUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdVote.getVoteId()).toUri();
        return ResponseEntity.created(voteUri).body(createdVote);
    }


    
    @DeleteMapping("/{id}")
    public void deleteVote(@PathVariable("id") int id) {
        voteService.deleteVote(id);
    }
}