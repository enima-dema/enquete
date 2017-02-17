package fr.humanbooster.fx.enquetes.dao;

import java.util.List;

import org.hibernate.Session;

import fr.humanbooster.fx.enquetes.business.Fait;

public interface FaitDao {
	public Fait create(Fait fait);
	public Fait update(Fait fait);
	public boolean delete (int idFait);
	public Fait findById(int idFait);
	public List<Fait> findAll();

	public Session openCurrentSession();

	public Session openCurrentSessionWithTransaction();

	public void closeCurrentSession();

	public void closeCurrentSessionwithTransaction();
}
