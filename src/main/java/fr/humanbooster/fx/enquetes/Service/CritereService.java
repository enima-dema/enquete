package fr.humanbooster.fx.enquetes.Service;

import java.util.List;

import fr.humanbooster.fx.enquetes.business.Critere;

public interface CritereService {

	public List<Critere> recupereCritere();
	
	public Critere recupereCritere (int id);
	
	public Critere creerCritere (int quotat, int idDepartement, int idFait, int idEnquete);
}
