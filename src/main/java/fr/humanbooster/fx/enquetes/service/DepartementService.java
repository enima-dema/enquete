package fr.humanbooster.fx.enquetes.service;

import fr.humanbooster.fx.enquetes.business.Departement;

import java.util.List;

public interface DepartementService {

	public List<Departement> recupereDepartement();
	
	public Departement recupereDepartement(int id);
	
}
