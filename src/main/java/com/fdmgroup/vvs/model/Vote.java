package com.fdmgroup.vvs.model;

import java.util.Date;
import java.util.List;

import javax.management.loading.PrivateClassLoader;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="VOTE")
public class Vote {
	@Id
	@SequenceGenerator(name = "VOTE_SEQ", sequenceName = "VOTE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VOTE_SEQ")
	@Column(name = "VOTE_ID")
	private int voteId;

	// UserId of the candidate
	// Will use to count the num of votes in the user model
	@ManyToOne
	@JoinColumn(name = "CANDIDATE_ID", referencedColumnName = "USER_ID", updatable = false, insertable = false)
	private User user;

	@Column(name = "VOTE_DATE")
	private Date date;

	// UserId of the Voter
	@OneToOne
	@JoinColumn(name = "FK_USER_ID")
	private User voter;

	@ManyToOne
	@JoinColumn(name = "FK_POLL_ID")
	private Poll poll;

	public Vote() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vote(int voteId, User user, Date date, User voter, Poll poll) {
		super();
		this.voteId = voteId;
		this.user = user;
		this.date = date;
		this.voter = voter;
		this.poll = poll;
	}

	public int getVoteId() {
		return voteId;
	}

	public void setVoteId(int voteId) {
		this.voteId = voteId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getVoter() {
		return voter;
	}

	public void setVoter(User voter) {
		this.voter = voter;
	}

	public Poll getPoll() {
		return poll;
	}

	public void setPoll(Poll poll) {
		this.poll = poll;
	}

	@Override
	public String toString() {
		return "Vote [voteId=" + voteId + ", user=" + user + ", date=" + date + ", voter=" + voter + ", poll=" + poll
				+ "]";
	}

}
