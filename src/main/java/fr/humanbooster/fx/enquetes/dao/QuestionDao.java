package fr.humanbooster.fx.enquetes.dao;

import java.util.List;

import org.hibernate.Session;

import fr.humanbooster.fx.enquetes.business.Question;

public interface QuestionDao {
	public Question create(Question question);
	public Question update(Question question);
	public boolean delete (int idQuestion);
	public Question findById(int idQuestion);
	public List<Question> findAll();

	public Session openCurrentSession();

	public Session openCurrentSessionWithTransaction();

	public void closeCurrentSession();

	public void closeCurrentSessionwithTransaction();
}
