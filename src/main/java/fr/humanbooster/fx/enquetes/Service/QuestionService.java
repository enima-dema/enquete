package fr.humanbooster.fx.enquetes.Service;

import java.util.List;

import fr.humanbooster.fx.enquetes.business.Question;

public interface QuestionService {

	public List<Question> recupereQuestions();
	
	public boolean modifierQuestion(int idQuestion, Question question);
	
	public boolean suprQuestion (int idQuestion);
	
}
