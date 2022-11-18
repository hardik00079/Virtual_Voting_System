package com.fdmgroup.vvs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//@Entity
//@Table
public class CandidatePosition {
	@Id
	@SequenceGenerator(name = "CANDIDATEPOSITION_SEQ", sequenceName = "CANDIDATEPOSITION_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CANDIDATEPOSITION_SEQ")
	private int positionId;
	private String candidatePositionName;
	/**
	 * @return the positionId
	 */
	public int getPositionId() {
		return positionId;
	}
	/**
	 * @param positionId the positionId to set
	 */
	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}
	/**
	 * @return the candidateName
	 */
	public String getCandidateName() {
		return candidatePositionName;
	}
	/**
	 * @param candidateName the candidateName to set
	 */
	public void setCandidateName(String candidateName) {
		this.candidatePositionName = candidateName;
	}
	/**
	 * @return the nbOfVotes
	 */

	@Override
	public String toString() {
		return "candidatePosition [positionId=" + positionId + ", candidateName=" + candidatePositionName + ", nbOfVotes="
				 + "]";
	}
	public CandidatePosition(int positionId, String candidateName) {
		super();
		this.positionId = positionId;
		this.candidatePositionName = candidateName;
	}
	public CandidatePosition() {
		super();
		// TODO Auto-generated constructor stub
	}
}
