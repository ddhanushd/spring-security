package com.exam;

import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ExamManagement {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int roleChoice;

		do {
			System.out.println("-----------------Please Select Your Role-----------");
			System.out.println("1. Admin");
			System.out.println("2. Student");
			System.out.println("0. Exit");
			System.out.println("------------------------------------------------------------");
			System.out.println("Enter Your choice:");
			roleChoice = scanner.nextInt();

			switch (roleChoice) {
			case 1:
				adminLogin();
				break;
			case 2:
				studentLogin();
				break;
			case 0:
				System.out.println("Exiting the system...");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}
		} while (roleChoice != 0);
	}

	private static void adminLogin() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter Admin Username:");
		String adminUsername = scanner.nextLine();

		System.out.println("Enter Admin Password:");
		String adminPassword = scanner.nextLine();

		if (validateAdminCredentials(adminUsername, adminPassword)) {
			System.out.println("Admin login successful!");
			adminOptions();
		} else {
			System.out.println("Invalid admin credentials. Please try again.");
		}
	}

	private static boolean validateAdminCredentials(String username, String password) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			Admin admin = (Admin) session.createQuery("FROM Admin WHERE username = :username AND password = :password")
					.setParameter("username", username).setParameter("password", password).uniqueResult();
			transaction.commit();
			return admin != null;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return false;
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	private static void adminOptions() {
		Scanner scanner = new Scanner(System.in);
		int choice;

		do {
			System.out.println("----------------Admin Operation------------");
			System.out.println("1. Create Exam");
			System.out.println("2. Delete Exam");
			System.out.println("3. Update Exam");
			System.out.println("4. Get all Exams");
			System.out.println("5. Get Exam by ID");
			System.out.println("6. Add Student");
			System.out.println("7. Delete Student");
			System.out.println("8. Update Student");
			System.out.println("9. Get All Students List");
			System.out.println("10. Get Student by Roll Number");
			System.out.println("11. Get Consolidated Students Report Card");
			System.out.println("12. Get Single Student Report Card by ID");
			System.out.println("13. Add Question in Exam");
			System.out.println("14. Update Question in Exam");
			System.out.println("15. Delete Question from Exam");
			System.out.println("16. Display all Questions from Exam");
			System.out.println("0. Exit");
			System.out.println("---------------------------------------------------");
			System.out.println("Enter Your choice:");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				createExam();
				break;
			case 2:
				deleteExam();
				break;
			case 3:
				updateExam();
				break;
			case 4:
				getAllExams();
				break;
			case 5:
				getExamById();
				break;
			case 6:
				addStudent();
				break;
			case 7:
				deleteStudent();
				break;
			case 8:
				updateStudent();
				break;
			case 9:
				getAllStudents();
				break;
			case 10:
				getStudentByRollNumber();
				break;
			case 11:
				getConsolidatedReportCard();
				break;
			case 12:
				getSingleReportCard();
				break;
			case 13:
				addQuestionToExam();
				break;
			case 14:
				updateQuestionInExam();
				break;
			case 15:
				deleteQuestionFromExam();
				break;
			case 16:
				displayAllQuestions();
				break;
			case 0:
				System.out.println("Exiting Admin Operation...");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}
		} while (choice != 0);
	}

	static AdminMethodsImplementation a = new AdminMethodsImplementation();

	private static void createExam() {
		a.createExam();
	}

	private static void deleteExam() {

		a.deleteExam();
	}

	private static void updateExam() {
		a.updateExam();

	}

	private static void getAllExams() {
		a.getAllExams();
	}

	private static void getExamById() {
		a.getExamById();
	}

	private static void addStudent() {
		a.addStudent();
	}

	private static void deleteStudent() {
		a.deleteStudent();
	}

	private static void updateStudent() {
		a.updateStudent();
	}

	private static void getAllStudents() {
		a.getAllStudents();
	}

	private static void getStudentByRollNumber() {
		a.getStudentByRollNumber();
	}

	private static void getConsolidatedReportCard() {
		a.getConsolidatedReportCard();
	}

	private static void getSingleReportCard() {
		a.getSingleReportCard();
	}

	private static void addQuestionToExam() {
		a.addQuestionToExam();
	}

	private static void updateQuestionInExam() {
		a.updateQuestionInExam();
	}

	private static void deleteQuestionFromExam() {
		a.deleteQuestionFromExam();
	}

	private static void displayAllQuestions() {
		a.displayAllQuestions();
	}

	private static void studentLogin() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("----------------Student----------------");
		System.out.println("Please enter your registered email:");
		String studentEmail = scanner.nextLine();

		System.out.println("Please enter password provided by admin:");
		String studentPassword = scanner.nextLine();

		if (validateStudentCredentials(studentEmail, studentPassword)) {
			System.out.println("Student login successful!");
			studentOptions();
		} else {
			System.out.println("Invalid student credentials. Please try again.");
		}
	}

	private static boolean validateStudentCredentials(String email, String password) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try {
			String hql = "FROM Student WHERE studentEmail = :email AND studentPassword = :password";
			List<Student> students = session.createQuery(hql, Student.class).setParameter("email", email)
					.setParameter("password", password).getResultList();
			return !students.isEmpty();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			transaction.commit();
			session.close();
			sessionFactory.close();
		}
	}

	private static void studentOptions() {
		Scanner scanner = new Scanner(System.in);
		int choice;

		do {
			System.out.println("----------------Student Dashboard------------");
			System.out.println("1. Go For Test");
			System.out.println("2. See Your Report Card");
			System.out.println("0. Exit");
			System.out.println("----------------------------------------------");
			System.out.println("Enter Your choice:");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				startTest();
				break;
			case 2:
				viewReportCard();
				break;
			case 0:
				System.out.println("Exiting Student Dashboard...");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}
		} while (choice != 0);
	}

	static StudentMethodsImplementation s = new StudentMethodsImplementation();

	private static void startTest() {
		s.startTest();
	}

	private static void viewReportCard() {
		s.viewReportCard();
	}

}
