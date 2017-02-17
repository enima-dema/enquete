package fr.humanbooster.fx.enquetes.Service;

import java.util.List;

import fr.humanbooster.fx.enquetes.business.Departement;

public interface DepartementService {

	public List<Departement> recupereDepartement();
	
	public Departement recupereDepartement(int id);
	
}
