package com.exam;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Exam")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "examID")
	private int examId;
    
    @Column(name = "examName")
	private String examName;
    
    @Column(name = "createdBy")
	private String createdBy;
    
    @Column(name = "subject")
	private String subject;
    
    @Column(name = "description")
	private String description;
    
    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL)
    private List<Question> questions = new ArrayList<>();

	public Exam() {

	}

	public Exam(int examId, String examName, String createdBy, String subject, String description,
			List<Question> questions) {
		super();
		this.examId = examId;
		this.examName = examName;
		this.createdBy = createdBy;
		this.subject = subject;
		this.description = description;
		this.questions = questions;
	}

	public int getExamId() {
		return examId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "Exam [examId=" + examId + ", examName=" + examName + ", createdBy=" + createdBy + ", subject=" + subject
				+ ", description=" + description + ", questions=" + questions + "]";
	}

	
}
