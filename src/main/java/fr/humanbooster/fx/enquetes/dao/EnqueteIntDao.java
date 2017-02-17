package fr.humanbooster.fx.enquetes.dao;

import java.util.List;

import org.hibernate.Session;

import fr.humanbooster.fx.enquetes.business.EnqueteInt;

public interface EnqueteIntDao {
	public EnqueteInt create(EnqueteInt enqueteInt);
	public EnqueteInt update(EnqueteInt enqueteInt);
	public boolean delete (int idEnqueteInt);
	public EnqueteInt findById(int idEnqueteInt);
	public List<EnqueteInt> findAll();

	public Session openCurrentSession();

	public Session openCurrentSessionWithTransaction();

	public void closeCurrentSession();

	public void closeCurrentSessionwithTransaction();
}
