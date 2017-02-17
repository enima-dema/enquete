package fr.humanbooster.fx.enquetes.dao;

import java.util.List;

import org.hibernate.Session;

import fr.humanbooster.fx.enquetes.business.Departement;

public interface DepartementDao {
	public Departement create(Departement departement);
	public Departement update(Departement departement);
	public boolean delete (int idDepartement);
	public Departement findById(int idDepartement);
	public List<Departement> findAll();

	public Session openCurrentSession();

	public Session openCurrentSessionWithTransaction();

	public void closeCurrentSession();

	public void closeCurrentSessionwithTransaction();
}
