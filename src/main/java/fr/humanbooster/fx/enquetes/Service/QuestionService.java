package fr.humanbooster.fx.enquetes.Service;

import java.util.List;

import fr.humanbooster.fx.enquetes.business.Enquete;
import fr.humanbooster.fx.enquetes.business.Question;

public interface QuestionService {

	public List<Question> recupereQuestions();
	
	public boolean modifierQuestion(int idQuestion, Question question);
	
	public boolean suprQuestion (int idQuestion);
	
	public boolean creerQuestion (String nom, Enquete enquete);
	
	public boolean creerQuestion (String nom);
	
	public boolean creerQuestion (Question question);
}
