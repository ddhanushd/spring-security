package com.exam;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentMethodsImplementation implements StudentMethods {

	 public void startTest() {
	        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	        Session session = sessionFactory.openSession();

	        try {
	            Scanner scanner = new Scanner(System.in);

	            System.out.print("Enter your roll number: ");
	            int studentRollNumber = scanner.nextInt();
	            scanner.nextLine();

	            // Fetch the student entity
	            Student student = session.get(Student.class, studentRollNumber);
	            if (student == null) {
	                System.out.println("Student not found!");
	                return;
	            }

	            List<Question> questions = session.createQuery("FROM Question", Question.class).list();

	            int totalQuestions = questions.size();
	            int correctAnswers = 0;

	            for (Question question : questions) {
	                System.out.println("Question: " + question.getQuestion());
	                System.out.println("Option 1: " + question.getOption1());
	                System.out.println("Option 2: " + question.getOption2());
	                System.out.println("Option 3: " + question.getOption3());

	                String userAnswer = "";
	                boolean validAnswer = false;

	                while (!validAnswer) {
	                    System.out.print("Your Answer (Enter the option number): ");
	                    userAnswer = scanner.nextLine();

	                    if (userAnswer.equals("1") || userAnswer.equals("2") || userAnswer.equals("3")) {
	                        validAnswer = true;
	                    } else {
	                        System.out.println("Invalid answer. Please enter a valid option number.");
	                    }
	                }

	                if (userAnswer.equals(question.getCorrectAnswer())) {
	                    correctAnswers++;
	                }
	            }

	            int score = (correctAnswers * 100) / totalQuestions;

	            ReportCard reportCard = new ReportCard();
	            reportCard.setStudent(student); // Set the associated student
	            reportCard.setScore(score);
	            reportCard.setDateOfExam(new Date());

	            Transaction transaction = session.beginTransaction();
	            session.save(reportCard);
	            transaction.commit();

	            System.out.println("Test completed!");
	            System.out.println("Score: " + score);
	            System.out.println("Scorecard saved successfully!");
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            session.close();
	            sessionFactory.close();
	        }
	    }
	 public void viewReportCard() {
	        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	        Session session = sessionFactory.openSession();

	        try {
	            Scanner scanner = new Scanner(System.in);

	            System.out.print("Enter your roll number: ");
	            int studentRollNumber = scanner.nextInt();

	            List<Student> students = session
	                    .createQuery("FROM Student WHERE studentRollNumber = :rollNumber", Student.class)
	                    .setParameter("rollNumber", studentRollNumber).list();

	            if (students.isEmpty()) {
	                System.out.println("No student found for roll number: " + studentRollNumber);
	            } else {
	                Student student = students.get(0);
	                ReportCard reportCard = student.getReportCard();
	                if (reportCard != null) {
	                    System.out.println("Report Card ID: " + reportCard.getReportCardId());
	                    System.out.println("Student Roll Number: " + student.getStudentRollNumber());
	                    System.out.println("Score: " + reportCard.getScore());
	                    System.out.println("Date of Exam: " + reportCard.getDateOfExam());
	                    System.out.println("--------------------------------------");
	                } else {
	                    System.out.println("No report card found for roll number: " + studentRollNumber);
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            session.close();
	            sessionFactory.close();
	        }
	    }

	
}
