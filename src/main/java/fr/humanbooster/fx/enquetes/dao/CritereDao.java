package fr.humanbooster.fx.enquetes.dao;

import java.util.List;

import org.hibernate.Session;

import fr.humanbooster.fx.enquetes.business.Critere;


public interface CritereDao {

	public Critere create(Critere critere);
	public Critere update(Critere critere);
	public boolean delete (int idCritere);
	public Critere findById(int idCritere);
	public List<Critere> findAll();

	public Session openCurrentSession();

	public Session openCurrentSessionWithTransaction();

	public void closeCurrentSession();

	public void closeCurrentSessionwithTransaction();
}
