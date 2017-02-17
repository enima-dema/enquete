package fr.humanbooster.fx.enquetes.ServiceImpl;

import java.util.List;

import fr.humanbooster.fx.enquetes.Service.QuestionService;
import fr.humanbooster.fx.enquetes.business.Question;
import fr.humanbooster.fx.enquetes.dao.QuestionDao;
import fr.humanbooster.fx.enquetes.dao.impl.QuestionDaoImpl;

public class QuestionServiceImpl implements QuestionService {

	QuestionDao qd = new QuestionDaoImpl();
	
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

}
