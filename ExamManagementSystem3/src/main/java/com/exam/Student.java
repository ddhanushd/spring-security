package com.exam;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {

    @Id
    @Column(name = "studentRollNumber")
	private int studentRollNumber;
    
    @Column(name = "studentFirstName")
	private String studentFirstName;
    
    @Column(name = "studentLastName")
	private String studentLastName;
    
    @Column(name = "studentGender")
	private String studentGender;
    
    @Column(name = "studentPassword")
	private String studentPassword;
    
    @Column(name = "studentAddress")
	private String studentAddress;
    
    @Column(name = "studentEmail")
	private String studentEmail;
    
    @Column(name = "studentCourse")
	private String studentCourse;
    
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private ReportCard reportCard;

	public Student() {
	}

	public Student(int studentRollNumber, String studentFirstName, String studentLastName, String studentGender,
			String studentPassword, String studentAddress, String studentEmail, String studentCourse,
			ReportCard reportCard) {
		super();
		this.studentRollNumber = studentRollNumber;
		this.studentFirstName = studentFirstName;
		this.studentLastName = studentLastName;
		this.studentGender = studentGender;
		this.studentPassword = studentPassword;
		this.studentAddress = studentAddress;
		this.studentEmail = studentEmail;
		this.studentCourse = studentCourse;
		this.reportCard = reportCard;
	}

	public int getStudentRollNumber() {
		return studentRollNumber;
	}

	public void setStudentRollNumber(int studentRollNumber) {
		this.studentRollNumber = studentRollNumber;
	}

	public String getStudentFirstName() {
		return studentFirstName;
	}

	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}

	public String getStudentLastName() {
		return studentLastName;
	}

	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}

	public String getStudentGender() {
		return studentGender;
	}

	public void setStudentGender(String studentGender) {
		this.studentGender = studentGender;
	}

	public String getStudentPassword() {
		return studentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getStudentCourse() {
		return studentCourse;
	}

	public void setStudentCourse(String studentCourse) {
		this.studentCourse = studentCourse;
	}

	public ReportCard getReportCard() {
		return reportCard;
	}

	public void setReportCard(ReportCard reportCard) {
		this.reportCard = reportCard;
	}

	@Override
	public String toString() {
		return "Student [studentRollNumber=" + studentRollNumber + ", studentFirstName=" + studentFirstName
				+ ", studentLastName=" + studentLastName + ", studentGender=" + studentGender + ", studentPassword="
				+ studentPassword + ", studentAddress=" + studentAddress + ", studentEmail=" + studentEmail
				+ ", studentCourse=" + studentCourse + ", reportCard=" + reportCard + "]";
	}
	
	

}
