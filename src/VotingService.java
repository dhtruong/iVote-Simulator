package iVoteSimulator;

public class VotingService {

	private Student[] student;
	private Question quest;
	private int answer1, answer2, answer3, answer4;
	private int choice1, choice2;

	public VotingService(Student[] student, Question question){
		this.student = student;
		this.quest = question;

		//Checking for the question type (multiple choice or single choice)	
		if (question.questionType())
			checkMultipleChoice();
		else
			checkSingleChoice();
	}

	public void checkMultipleChoice(){

		System.out.println("\nQuestion: " + quest.question() + "\n");
		
		//Comparing the student's answer to the correct answer and getting the count of each answer choice
		for (Student num : student) {
			if (num.getAnswer().compareTo("A") == 0)
				answer1++;
			else if (num.getAnswer().compareTo("B") == 0)
				answer2++;
			else if (num.getAnswer().compareTo("C") == 0)
				answer3++;
			else
				answer4++;
		}

		printResult();
	}

	public void checkSingleChoice(){

		System.out.println("\nQuestion: " + quest.question() + "\n");
		
		//Comparing the student's answer to the correct answer and getting the count of each answer choice
		for (Student num : student) { 
			if (num.getAnswer().compareTo("True") == 0)
				choice1++;
			else
				choice2++;
		}

		printResult();
	}
	
	//Printing the answer and the student submission result
	public void printResult (){ 

		if (quest.questionType()){
			System.out.println("Printing Multiple Choice Results...");
			System.out.println("A: Osaka - " + answer1);
			System.out.println("B: Los Angeles - " + answer2);
			System.out.println("C: Tokyo - " + answer3);
			System.out.println("D: Kyoto- " + answer4);
		}
		else {
			System.out.println("Printing Single Choice Results...");
			System.out.println("1. True - " + choice1);
			System.out.println("2. False - " + choice2);
		}
	}
}