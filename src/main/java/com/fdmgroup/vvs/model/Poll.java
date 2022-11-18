package com.fdmgroup.vvs.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Poll {
	@Id
	@SequenceGenerator(name = "POLL_SEQ", sequenceName = "POLL_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POLL_SEQ")
	@Column(name = "POLL_ID")
	private int pollId;
	private String pollName;
	private String category;
	private Date publishDate;
//	private String poll;
	@ManyToMany
	@JoinTable(name = "USER_POLL", joinColumns = @JoinColumn(name="FK_USER_ID"), inverseJoinColumns = @JoinColumn(name = "FK_POLL_ID"))
	private List<User> candidates;
	
	@OneToMany(mappedBy = "poll")
	private List<Vote> voters;
	
	public Poll(int pollId, String pollName, String category, Date publishDate) {
		super();
		this.pollId = pollId;
		this.pollName = pollName;
		this.category = category;
		this.publishDate = new Date();;
//		this.poll = poll;
//		this.candidates = candidates;
	}
	
	

public Poll(int pollId, String pollName, String category, Date publishDate, List<User> candidates,
			List<Vote> voters) {
		super();
		this.pollId = pollId;
		this.pollName = pollName;
		this.category = category;
		this.publishDate = publishDate;
		this.candidates = candidates;
		this.voters = voters;
	}



//	public Poll(int pollId, String pollName, String category, String poll
//			) {
//		super();
//		this.pollId = pollId;
//		this.pollName = pollName;
//		this.category = category;
//		this.publishDate = new Date();
////		this.poll = poll;
////		this.candidates = candidates;
//	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return the creationDate
	 */

	

	/**
	 * @return the pollId
	 */
	public int getPollId() {
		return pollId;
	}
	/**
	 * @return the publishDate
	 */
	public Date getPublishDate() {
		return publishDate;
	}

	/**
	 * @param publishDate the publishDate to set
	 */
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	/**
	 * @return the voters
	 */
	public List<Vote> getVoters() {
		return voters;
	}

	/**
	 * @param voters the voters to set
	 */
	public void setVoters(List<Vote> voters) {
		this.voters = voters;
	}

	/**
	 * @param pollId the pollId to set
	 */
	public void setPollId(int pollId) {
		this.pollId = pollId;
	}
	/**
	 * @return the pollName
	 */
	public String getPollName() {
		return pollName;
	}
	/**
	 * @param pollName the pollName to set
	 */
	public void setPollName(String pollName) {
		this.pollName = pollName;
	}
	/**
	 * @return the poll
	 */
//	public String getPoll() {
//		return poll;
//	}
//	/**
//	 * @param poll the poll to set
//	 */
//	public void setPoll(String poll) {
//		this.poll = poll;
//	}
	/**
	 * @return the candidates
	 */
//	public List<Candidate> getCandidates() {
//		return candidates;
//	}
	/**
	 * @param candidates the candidates to set
	 */
//	public void setCandidates(List<Candidate> candidates) {
//		this.candidates = candidates;
//	}
	
	public Poll(int pollId, String pollName, String poll) {
		super();
		this.pollId = pollId;
		this.pollName = pollName;
//		this.poll = poll;
//		this.candidates = candidates;
	}

	@Override
	public String toString() {
		System.out.println("Poll [pollId=" + pollId + ", pollName=" + pollName + ", category=" + category + ", publishDate="
				+ publishDate + ", voters=" + voters + "]");
		return "Poll [pollId=" + pollId + ", pollName=" + pollName + ", category=" + category + ", publishDate="
				+ publishDate + ", voters=" + voters + "]";
	}

	public Poll() {
		super();
		// TODO Auto-generated constructor stub
	}
}
