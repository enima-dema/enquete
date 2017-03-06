package fr.humanbooster.fx.enquetes.service;

import java.util.Date;
import java.util.List;

import fr.humanbooster.fx.enquetes.business.Enquete;
import fr.humanbooster.fx.enquetes.business.Question;
import fr.humanbooster.fx.enquetes.business.SiteInt;

public interface EnqueteService {

	public List<Enquete> recupereEnquetes();
	
	public List<Enquete> recupereEnquetes(String nom, Date dateDebut, Date dateFin);
	
	public boolean createEnquete (String nom, float prix, Date date, String accroche);
	
	public boolean createEnquete (String nom, float prix, Date date, List<SiteInt> sites);
	
	public boolean ajoutEnquete(Enquete enquete);
		
	public boolean ajoutEnqueteType (boolean telephonique, Enquete enquete);
	
	public boolean modifierEnquete(int idEnquete, Enquete enquete);
	
	public boolean ajoutQuestionAEnquete(int idEnquete, Question question);
	
	public boolean suprEnquete(int idEnquete);
	
}
