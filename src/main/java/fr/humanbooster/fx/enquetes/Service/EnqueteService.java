package fr.humanbooster.fx.enquetes.Service;

import java.util.Date;
import java.util.List;

import fr.humanbooster.fx.enquetes.business.Enquete;
import fr.humanbooster.fx.enquetes.business.SiteInt;

public interface EnqueteService {

	public List<Enquete> recupereEnquetes();
	
	public List<Enquete> recupereEnquetes(String nom, Date dateDebut, Date dateFin);
	
	public boolean createEnquete (String nom, float prix, Date date, String accroche);
	
	public boolean createEnquete (String nom, float prix, Date date, List<SiteInt> sites);
	
	public boolean ajoutEnquete(Enquete enquete);
		
	public boolean ajoutEnqueteType (boolean telephonique, int idEnquete);
	
	public boolean modifierEnquete(int idEnquete, Enquete enquete);
	
	public boolean ajoutQuestionAEnquete(int idEnquete, int idQuestion);
	
	public boolean suprEnquete(int idEnquete);
	
}
