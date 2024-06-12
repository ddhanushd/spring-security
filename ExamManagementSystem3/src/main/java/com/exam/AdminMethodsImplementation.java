package com.exam;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AdminMethodsImplementation implements AdminMethods {

	@Override
	public void createExam() {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try {
			Scanner scanner = new Scanner(System.in);

			System.out.println("Enter the exam name:");
			String examName = scanner.nextLine();

			System.out.println("Enter the created by:");
			String createdBy = scanner.nextLine();

			System.out.println("Enter the subject:");
			String subject = scanner.nextLine();

			System.out.println("Enter the description:");
			String description = scanner.nextLine();

			Exam exam = new Exam();
			exam.setExamName(examName);
			exam.setCreatedBy(createdBy);
			exam.setSubject(subject);
			exam.setDescription(description);

			session.save(exam);
			transaction.commit();
			System.out.println("Exam created successfully.");

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	@Override
	public void deleteExam() {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try {
			Scanner scanner = new Scanner(System.in);

			System.out.println("Enter the examID to delete:");
			int examID = scanner.nextInt();

			Exam exam = session.get(Exam.class, examID);

			if (exam != null) {
				session.delete(exam);

				transaction.commit();
				System.out.println("Exam with examID " + examID + " deleted successfully.");
			} else {
				System.out.println("Exam with examID " + examID + " not found.");
			}
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	@Override
	public void updateExam() {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try {
			Scanner scanner = new Scanner(System.in);

			System.out.println("Enter the examID to update:");
			int examID = scanner.nextInt();
			scanner.nextLine();

			Exam exam = session.get(Exam.class, examID);

			if (exam != null) {
				System.out.println("Enter the new exam name:");
				String newExamName = scanner.nextLine();

				System.out.println("Enter the new created by:");
				String newCreatedBy = scanner.nextLine();

				System.out.println("Enter the new subject:");
				String newSubject = scanner.nextLine();

				System.out.println("Enter the new description:");
				String newDescription = scanner.nextLine();

				exam.setExamName(newExamName);
				exam.setCreatedBy(newCreatedBy);
				exam.setSubject(newSubject);
				exam.setDescription(newDescription);

				session.update(exam);

				transaction.commit();
				System.out.println("Exam with examID " + examID + " updated successfully.");
			} else {
				System.out.println("Exam with examID " + examID + " not found.");
			}
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}

	}

	@Override
	public void getAllExams() {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try {
			List<Exam> exams = session.createQuery("FROM Exam").list();

			if (!exams.isEmpty()) {
				System.out.println("All Exams:");
				for (Exam exam : exams) {
					System.out.println("Exam ID: " + exam.getExamId());
					System.out.println("Exam Name: " + exam.getExamName());
					System.out.println("Created By: " + exam.getCreatedBy());
					System.out.println("Subject: " + exam.getSubject());
					System.out.println("Description: " + exam.getDescription());
					System.out.println("---------------------------");
				}
			} else {
				System.out.println("No exams found.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	@Override
	public void getExamById() {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try {
			Scanner scanner = new Scanner(System.in);

			System.out.println("Enter the examID:");
			int examID = scanner.nextInt();

			Exam exam = session.get(Exam.class, examID);

			if (exam != null) {
				System.out.println("Exam ID: " + exam.getExamId());
				System.out.println("Exam Name: " + exam.getExamName());
				System.out.println("Created By: " + exam.getCreatedBy());
				System.out.println("Subject: " + exam.getSubject());
				System.out.println("Description: " + exam.getDescription());
			} else {
				System.out.println("Exam with examID " + examID + " not found.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	@Override
	public void addStudent() {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try {
			Scanner scanner = new Scanner(System.in);

			System.out.println("Enter student roll number:");
			int rollNumber = scanner.nextInt();
			scanner.nextLine();

			System.out.println("Enter student first name:");
			String firstName = scanner.nextLine();

			System.out.println("Enter student last name:");
			String lastName = scanner.nextLine();

			System.out.println("Enter student gender:");
			String gender = scanner.nextLine();

			System.out.println("Enter student password:");
			String password = scanner.nextLine();

			System.out.println("Enter student address:");
			String address = scanner.nextLine();

			System.out.println("Enter student email:");
			String email = scanner.nextLine();

			System.out.println("Enter student course:");
			String course = scanner.nextLine();

			Student student = new Student();
			student.setStudentRollNumber(rollNumber);
			student.setStudentFirstName(firstName);
			student.setStudentLastName(lastName);
			student.setStudentGender(gender);
			student.setStudentPassword(password);
			student.setStudentAddress(address);
			student.setStudentEmail(email);
			student.setStudentCourse(course);

			session.save(student);

			transaction.commit();
			System.out.println("Student details added successfully.");
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	@Override
	public void deleteStudent() {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try {
			Scanner scanner = new Scanner(System.in);

			System.out.println("Enter the student's roll number to delete:");
			int rollNumber = scanner.nextInt();

			Student student = session.get(Student.class, rollNumber);

			if (student != null) {
				session.delete(student);

				transaction.commit();
				System.out.println("Student with roll number " + rollNumber + " deleted successfully.");
			} else {
				System.out.println("Student with roll number " + rollNumber + " not found.");
			}
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	@Override
	public void updateStudent() {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try {
			Scanner scanner = new Scanner(System.in);

			System.out.println("Enter the roll number of the student to update:");
			int rollNumber = scanner.nextInt();

			Student student = session.get(Student.class, rollNumber);

			if (student != null) {
				scanner.nextLine();

				System.out.println("Enter updated first name:");
				String updatedFirstName = scanner.nextLine();

				System.out.println("Enter updated last name:");
				String updatedLastName = scanner.nextLine();

				System.out.println("Enter updated gender:");
				String updatedGender = scanner.nextLine();

				System.out.println("Enter updated password:");
				String updatedPassword = scanner.nextLine();

				System.out.println("Enter updated address:");
				String updatedAddress = scanner.nextLine();

				System.out.println("Enter updated email:");
				String updatedEmail = scanner.nextLine();

				System.out.println("Enter updated course:");
				String updatedCourse = scanner.nextLine();

				student.setStudentFirstName(updatedFirstName);
				student.setStudentLastName(updatedLastName);
				student.setStudentGender(updatedGender);
				student.setStudentPassword(updatedPassword);
				student.setStudentAddress(updatedAddress);
				student.setStudentEmail(updatedEmail);
				student.setStudentCourse(updatedCourse);

				session.update(student);

				transaction.commit();
				System.out.println("Student with roll number " + rollNumber + " updated successfully.");
			} else {
				System.out.println("Student with roll number " + rollNumber + " not found.");
			}
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	@Override
	public void getAllStudents() {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try {
			List<Student> students = session.createQuery("FROM Student", Student.class).list();

			if (!students.isEmpty()) {
				System.out.println("All Students:");

				for (Student student : students) {
					System.out.println("Roll Number: " + student.getStudentRollNumber());
					System.out.println("First Name: " + student.getStudentFirstName());
					System.out.println("Last Name: " + student.getStudentLastName());
					System.out.println("Gender: " + student.getStudentGender());
					System.out.println("Password: " + student.getStudentPassword());
					System.out.println("Address: " + student.getStudentAddress());
					System.out.println("Email: " + student.getStudentEmail());
					System.out.println("Course: " + student.getStudentCourse());
					System.out.println("------------------------------------");
				}
			} else {
				System.out.println("No students found.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	@Override
	public void getStudentByRollNumber() {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try {
			Scanner scanner = new Scanner(System.in);

			System.out.println("Enter the roll number of the student to retrieve:");
			int rollNumber = scanner.nextInt();

			Student student = session.get(Student.class, rollNumber);

			if (student != null) {
				System.out.println("Student Details:");
				System.out.println("Roll Number: " + student.getStudentRollNumber());
				System.out.println("First Name: " + student.getStudentFirstName());
				System.out.println("Last Name: " + student.getStudentLastName());
				System.out.println("Gender: " + student.getStudentGender());
				System.out.println("Password: " + student.getStudentPassword());
				System.out.println("Address: " + student.getStudentAddress());
				System.out.println("Email: " + student.getStudentEmail());
				System.out.println("Course: " + student.getStudentCourse());
			} else {
				System.out.println("Student with roll number " + rollNumber + " not found.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	public void getConsolidatedReportCard() {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        // Transaction not needed for read-only operations
        // Transaction transaction = session.beginTransaction();

        try {
            List<ReportCard> reportCards = session.createQuery("FROM ReportCard", ReportCard.class).list();

            if (!reportCards.isEmpty()) {
                System.out.println("Consolidated Scores of All Students:");

                for (ReportCard reportCard : reportCards) {
                    Student student = reportCard.getStudent();
                    if (student != null) {
                        String studentName = student.getStudentFirstName() + " " + student.getStudentLastName();

                        System.out.println("Roll Number: " + student.getStudentRollNumber());
                        System.out.println("Name: " + studentName);
                        System.out.println("Score: " + reportCard.getScore());
                        System.out.println("Date of Exam: " + reportCard.getDateOfExam());
                        System.out.println("------------------------------------");
                    }
                }
            } else {
                System.out.println("No report cards found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

	 public void getSingleReportCard() {

	        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

	        Session session = sessionFactory.openSession();

	        try {
	            Scanner scanner = new Scanner(System.in);

	            System.out.print("Enter the roll number of the student to retrieve the report card: ");
	            int studentRollNumber = scanner.nextInt();

	            List<Student> students = session
	                    .createQuery("FROM Student WHERE studentRollNumber = :rollNumber", Student.class)
	                    .setParameter("rollNumber", studentRollNumber).list();

	            if (students.isEmpty()) {
	                System.out.println("No student found for roll number: " + studentRollNumber);
	            } else {
	                for (Student student : students) {
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
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            session.close();
	            sessionFactory.close();
	        }
	    }

	 @Override
	 public void addQuestionToExam() {

	     SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

	     Session session = sessionFactory.openSession();
	     Transaction transaction = session.beginTransaction();

	     try {
	         Scanner scanner = new Scanner(System.in);

	         System.out.println("Enter the exam ID for the question:");
	         int examID = scanner.nextInt();
	         scanner.nextLine();

	         // Fetch the exam from the database
	         Exam exam = session.get(Exam.class, examID);

	         if (exam != null) {
	             System.out.println("Enter the question:");
	             String questionText = scanner.nextLine();

	             System.out.println("Enter option 1:");
	             String option1 = scanner.nextLine();

	             System.out.println("Enter option 2:");
	             String option2 = scanner.nextLine();

	             System.out.println("Enter option 3:");
	             String option3 = scanner.nextLine();

	             System.out.println("Enter the correct answer:");
	             String correctAnswer = scanner.nextLine();

	             // Create a new Question object and set its properties
	             Question newQuestion = new Question();
	             newQuestion.setQuestion(questionText);
	             newQuestion.setOption1(option1);
	             newQuestion.setOption2(option2);
	             newQuestion.setOption3(option3);
	             newQuestion.setCorrectAnswer(correctAnswer);

	             // Set the exam for the question
	             newQuestion.setExam(exam);

	             // Add the question to the exam's list of questions
	             exam.getQuestions().add(newQuestion);

	             // Save the question and commit the transaction
	             session.save(newQuestion);
	             transaction.commit();

	             System.out.println("Question added successfully!");
	         } else {
	             System.out.println("Exam with ID " + examID + " not found!");
	         }
	     } catch (Exception e) {
	         e.printStackTrace();
	         transaction.rollback();
	     } finally {
	         session.close();
	         sessionFactory.close();
	     }
	 }


	@Override
	public void updateQuestionInExam() {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try {
			Scanner scanner = new Scanner(System.in);

			System.out.println("Enter the questionID of the question to be updated:");
			int questionID = scanner.nextInt();
			scanner.nextLine();

			Question question = session.get(Question.class, questionID);

			if (question != null) {
				System.out.println("Enter the updated question:");
				String updatedQuestion = scanner.nextLine();

				System.out.println("Enter the updated option 1:");
				String updatedOption1 = scanner.nextLine();

				System.out.println("Enter the updated option 2:");
				String updatedOption2 = scanner.nextLine();

				System.out.println("Enter the updated option 3:");
				String updatedOption3 = scanner.nextLine();

				System.out.println("Enter the updated correct answer:");
				String updatedCorrectAnswer = scanner.nextLine();

				question.setQuestion(updatedQuestion);
				question.setOption1(updatedOption1);
				question.setOption2(updatedOption2);
				question.setOption3(updatedOption3);
				question.setCorrectAnswer(updatedCorrectAnswer);

				session.update(question);
				transaction.commit();

				System.out.println("Question updated successfully!");
			} else {
				System.out.println("Question not found for questionID: " + questionID);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	@Override
	public void deleteQuestionFromExam() {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the questionID of the question to be deleted:");
			int questionID = scanner.nextInt();

			Question question = session.get(Question.class, questionID);

			if (question != null) {
				session.delete(question);
				transaction.commit();

				System.out.println("Question deleted successfully!");
			} else {
				System.out.println("Question not found for questionID: " + questionID);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	@Override
	public void displayAllQuestions() {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try {
			List<Question> questions = session.createQuery("FROM Question", Question.class).list();

			for (Question question : questions) {
				System.out.println("Question ID: " + question.getQuestionId());
				System.out.println("Exam ID: " + question.getExam().getExamId());
				System.out.println("Question: " + question.getQuestion());
				System.out.println("Option 1: " + question.getOption1());
				System.out.println("Option 2: " + question.getOption2());
				System.out.println("Option 3: " + question.getOption3());
				System.out.println("Correct Answer: " + question.getCorrectAnswer());
				System.out.println("---------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
