package iVoteSimulator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SimulationDriver {

	public static void main(String[] args) {
        
		Question quest;
    		Random rand = new Random();
    		Scanner scan = new Scanner(System.in);
    		Student student[] = createStudent();
        
        	System.out.println("---iVote Simulator---\n");
        	System.out.print("Enter a question type...\n1) Multiple Choice Question\n2) Single Choice Question\nInput: ");
        
        	int input = scan.nextInt();
        
        	//Depending on the User's input we will print Multiple choice or Single choice result
        	if (input == 1) {
        		quest = new MultipleChoiceQuestion();
        		String answers[] = {"A", "B", "C", "D"};
            
        		//Create Question
        		quest.setQuestion("Which of these cities are located in Japan?");
        		int index = rand.nextInt(4);
            
        		//Answer to the question
        		quest.setAnswer(answers[2]); 

        		//Assign an answer to each student
        		for (Student num : student) 
        		{ 
        			index = rand.nextInt(4);
	        		num.setAnswer(answers[index]);
        		}        
        	}
        	else {
        		quest = new SingleChoiceQuestion();
        	
        		//Create Question
        		quest.setQuestion("The capital of Japan is Tokyo");
        	
        		//Answer to the question
        		quest.setAnswer("True"); 

        		int index = 0;
            
        		//Assign an answer to each student
        		for (Student num : student) { 
        			index = rand.nextInt(3);
               		
        			if (index % 2 == 0)
        				num.setAnswer("True");
        			else
        				num.setAnswer("False");
        		}
        	}
        
        	scan.close();
       
        	VotingService service = new VotingService(student, quest);
	}

	private static Student[] createStudent(){
    	
    		Random rand = new Random();
    	
    		//Creating a random number of students between 20 to 0
        	int totalStudents = rand.nextInt(40-20) + 20; 
        
        	//Create a list to store all the students' unique ID
        	List<String> studentID= new ArrayList<>(); 
        
        	Student student[] = new Student[totalStudents];
        
        	//Creating all the students with the given amount above
        	for (int i = 0; i < totalStudents; i++) { 	
        		student[i] = new Student();
        	}

        	//Create a unique ID for each student while going through all the list 
        	for (Student num : student) { 
        		num.setID(Integer.toString(rand.nextInt(999-100) + 100));
        		studentID.add(num.getStudentID());
        	}

        	return student;
	}
}