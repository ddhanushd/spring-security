package com.exam;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int questionId;
	private String question;
	
	@ManyToOne
	@JoinColumn(name = "exam_id")
	private Exam exam;
	private String option1;
	private String option2;
	private String option3;
	private String correctAnswer;

	public Question() {
	}

	public Question(int questionId, String question, Exam exam, String option1, String option2, String option3,
			String correctAnswer) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.exam = exam;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.correctAnswer = correctAnswer;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", question=" + question + ", exam=" + exam + ", option1="
				+ option1 + ", option2=" + option2 + ", option3=" + option3 + ", correctAnswer=" + correctAnswer + "]";
	}


}
