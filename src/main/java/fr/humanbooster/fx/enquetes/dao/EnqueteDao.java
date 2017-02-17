package fr.humanbooster.fx.enquetes.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import fr.humanbooster.fx.enquetes.business.Enquete;

public interface EnqueteDao {
	public Enquete create(Enquete enquete);
	public Enquete update(Enquete enquete);
	public boolean delete (int idEnquete);
	public Enquete findById(int idEnquete);
	public List<Enquete> findAll();
	public List<Enquete> findByName(String name);
	public List<Enquete> findByDate(Date datedebut,Date dateFin);
	public Session openCurrentSession();

	public Session openCurrentSessionWithTransaction();

	public void closeCurrentSession();

	public void closeCurrentSessionwithTransaction();
}
