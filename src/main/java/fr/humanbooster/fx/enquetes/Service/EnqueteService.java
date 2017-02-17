package fr.humanbooster.fx.enquetes.Service;

import java.util.Date;
import java.util.List;

import fr.humanbooster.fx.enquetes.business.Enquete;
import fr.humanbooster.fx.enquetes.business.Question;

public interface EnqueteService {

	public List<Enquete> recupereEnquetes();
	
	public List<Enquete> recupereEnquetes(String nom, Date dateDebut, Date deateFin);
	
	public boolean ajoutEnquete(Enquete enquete);
	
	public Enquete createEnquete(String nom, float prix, Date date);
	
	public boolean ajoutEnqueteType (boolean telephonique, Enquete enquete);
	
	public boolean modifierEnquete(int idEnquete, Enquete enquete);
	
	public boolean ajoutQuestionAEnquete(int idEnquete, Question question);
	
	public boolean suprEnquete(int idEnquete);
	
}
