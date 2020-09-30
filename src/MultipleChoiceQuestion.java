package iVoteSimulator;

public class MultipleChoiceQuestion implements Question{

	String question;
	String answer;

	public String question(){
		return question;
	}
	
	public String answer(){
		return answer;
	}

	public void setQuestion(String question){
		this.question = question;
	}
	
	public void setAnswer(String answer){
		this.answer = answer;
	}

	public boolean questionType(){
		return true;
	}
}
