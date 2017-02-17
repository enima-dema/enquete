package fr.humanbooster.fx.enquetes.ServiceImpl;

import java.util.List;

import fr.humanbooster.fx.enquetes.Service.QuestionService;
import fr.humanbooster.fx.enquetes.business.Enquete;
import fr.humanbooster.fx.enquetes.business.Question;
import fr.humanbooster.fx.enquetes.dao.EnqueteDao;
import fr.humanbooster.fx.enquetes.dao.QuestionDao;
import fr.humanbooster.fx.enquetes.dao.impl.EnqueteDaoImpl;
import fr.humanbooster.fx.enquetes.dao.impl.QuestionDaoImpl;

public class QuestionServiceImpl implements QuestionService {

	QuestionDao qd = new QuestionDaoImpl();
	EnqueteDao ed = new EnqueteDaoImpl();
	
	@Override
	public List<Question> recupereQuestions() {
		qd.openCurrentSession();
		List<Question> questions = qd.findAll();
		qd.closeCurrentSession();
		return questions;
	}

	@Override
	public boolean modifierQuestion(int idQuestion, Question question) {
		qd.openCurrentSession();
		Question questionFromDao = qd.update(question);
		qd.closeCurrentSession();
		
		if (questionFromDao != null)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean suprQuestion(int idQuestion) {
		qd.openCurrentSession();
		boolean result = qd.delete(idQuestion);
		qd.closeCurrentSession();
		return result;
	}

	@Override
	public boolean creerQuestion(String nom, int idEnquete) {
		Enquete enquete = ed.findById(idEnquete);
		Question question = new Question();
		question.setNom(nom);
		question.setEnquete(enquete);
		
		return creerQuestion(question);
	}

	@Override
	public boolean creerQuestion(String nom) {
		Question question = new Question();
		question.setNom(nom);
		
		return creerQuestion(question);
	}

	@Override
	public boolean creerQuestion(Question question) {
		qd.openCurrentSession();
		Question questionFromDao = qd.create(question);
		qd.closeCurrentSession();
		if (questionFromDao != null)
		{
			return true;
		}
		return false;
	}

}
