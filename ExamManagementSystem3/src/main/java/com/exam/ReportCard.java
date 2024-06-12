package com.exam;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ReportCard")
public class ReportCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reportcardId")
	private int reportCardId;
    
    @OneToOne
    @JoinColumn(name = "studentRollNumber", referencedColumnName = "studentRollNumber")
    private Student student;
    
	private int score;
	private Date dateOfExam;

	public ReportCard() {
	}

	public ReportCard(int reportCardId, Student student, int score, Date dateOfExam) {
		super();
		this.reportCardId = reportCardId;
		this.student = student;
		this.score = score;
		this.dateOfExam = dateOfExam;
	}

	public int getReportCardId() {
		return reportCardId;
	}

	public void setReportCardId(int reportCardId) {
		this.reportCardId = reportCardId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Date getDateOfExam() {
		return dateOfExam;
	}

	public void setDateOfExam(Date dateOfExam) {
		this.dateOfExam = dateOfExam;
	}

	@Override
	public String toString() {
		return "ReportCard [reportCardId=" + reportCardId + ", student=" + student + ", score=" + score
				+ ", dateOfExam=" + dateOfExam + "]";
	}

	 

}
