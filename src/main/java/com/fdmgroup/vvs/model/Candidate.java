package com.fdmgroup.vvs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//@Entity
//@Table
public class Candidate {
	@Id
	@SequenceGenerator(name = "CANDIDATE_SEQ", sequenceName = "CANDIDATE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CANDIDATE_SEQ")
	private int candidateId;
	@ManyToOne
	@JoinColumn(referencedColumnName = "positionId")
	private CandidatePosition candidatePosition;
	@OneToOne //(mappedBy = "userId")
	@JoinColumn(referencedColumnName = "userId")
	private User user;
	
	/**
	 * @return the candidateId
	 */
	public int getCandidateId() {
		return candidateId;
	}
	/**
	 * @param candidateId the candidateId to set
	 */
	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}
	/**
	 * @return the candidatePosition
	 */
	public CandidatePosition getCandidatePosition() {
		return candidatePosition;
	}
	/**
	 * @param candidatePosition the candidatePosition to set
	 */
	public void setCandidatePosition(CandidatePosition candidatePosition) {
		this.candidatePosition = candidatePosition;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Candidate [candidateId=" + candidateId + ", candidatePosition=" + candidatePosition + ", user=" + user
				+ "]";
	}
	public Candidate(int candidateId, CandidatePosition candidatePosition, User user) {
		super();
		this.candidateId = candidateId;
		this.candidatePosition = candidatePosition;
		this.user = user;
	}
	public Candidate() {
		super();
		// TODO Auto-generated constructor stub
	}
}
