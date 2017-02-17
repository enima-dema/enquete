package fr.humanbooster.fx.enquetes.ServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.humanbooster.fx.enquetes.Service.EnqueteService;
import fr.humanbooster.fx.enquetes.business.Enquete;
import fr.humanbooster.fx.enquetes.business.EnqueteInt;
import fr.humanbooster.fx.enquetes.business.EnqueteTel;
import fr.humanbooster.fx.enquetes.business.Question;
import fr.humanbooster.fx.enquetes.business.SiteInt;
import fr.humanbooster.fx.enquetes.dao.EnqueteDao;
import fr.humanbooster.fx.enquetes.dao.QuestionDao;
import fr.humanbooster.fx.enquetes.dao.impl.EnqueteDaoImpl;
import fr.humanbooster.fx.enquetes.dao.impl.QuestionDaoImpl;

public class EnqueteServiceImpl implements EnqueteService {

	private EnqueteDao ed = new EnqueteDaoImpl();
	private QuestionDao qd = new QuestionDaoImpl();
	
	@Override
	public List<Enquete> recupereEnquetes() {
		List<Enquete> enquetes = new ArrayList<>();
		
		ed.openCurrentSession();
		enquetes = ed.findAll();
		ed.closeCurrentSession();
		
		return enquetes;
	}

	@Override
	public List<Enquete> recupereEnquetes(String nom, Date dateDebut, Date dateFin) {
		System.out.println("non fonctionnel pour le moment");
		return recupereEnquetes();
	}

	@Override
	public boolean ajoutEnquete(Enquete enquete) {
		Enquete enqueteResponse;
		
		ed.openCurrentSession();
		enqueteResponse = ed.create(enquete);
		if (enqueteResponse != null)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean createEnquete(String nom, float prix, Date date, String accroche) {
		EnqueteTel enquete = new EnqueteTel();
		enquete.setNom(nom);
		enquete.setPrix(prix);
		enquete.setDate(date);
		enquete.setAccroche(accroche);
		
		if (!ajoutEnquete(enquete))
		{
			System.out.println("erreur enregistrement enquete from EnqueteServiceImpl.createEnquete()");
			return false;
		}
		
		return true;
	}

	@Override
	public boolean createEnquete(String nom, float prix, Date date, List<SiteInt> sites) {
		EnqueteInt enquete = new EnqueteInt();
		enquete.setNom(nom);
		enquete.setPrix(prix);
		enquete.setDate(date);
		enquete.setSites(sites);
		
		if (!ajoutEnquete(enquete))
		{
			System.out.println("erreur enregistrement enquete from EnqueteServiceImpl.createEnquete()");
			return false;
		}
		
		return true;
	}
	
	@Override
	public boolean ajoutEnqueteType(boolean telephonique, int idEnquete) {
		
		Enquete newEnquete;
		Enquete enquete = ed.findById(idEnquete);
		
		if (telephonique)
		{
			newEnquete = new EnqueteTel();

		}
		else
		{
			newEnquete = new EnqueteInt();
		}
		newEnquete.setNom(enquete.getNom());
		newEnquete.setPrix(enquete.getPrix());
		newEnquete.setDate(enquete.getDate());
		newEnquete.setQuestions(enquete.getQuestions());
		newEnquete.setCriteres(enquete.getCriteres());
		
		ed.openCurrentSession();
		Enquete enqueteFromDao = ed.create(newEnquete);
		ed.closeCurrentSession();
		
		if (enqueteFromDao != null)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean modifierEnquete(int idEnquete, Enquete enquete) {
		
		if (enquete.getId() == 0)
		{
			enquete.setId(idEnquete);
		}
		
		ed.openCurrentSession();
		Enquete newEnquete = ed.update(enquete);
		ed.closeCurrentSession();
		
		if (newEnquete != null)
		{
			return true;
		}
		return true;
	}

	@Override
	public boolean ajoutQuestionAEnquete(int idEnquete, int idQuestion) {
		
		Enquete enquete = ed.findById(idEnquete);
		
		List<Question> listQuestion = enquete.getQuestions();
		listQuestion.add(qd.findById(idQuestion));
		enquete.setQuestions(listQuestion);
		
		ed.openCurrentSession();
		Enquete enqueteFromDao = ed.update(enquete);
		ed.closeCurrentSession();
		
		if (enqueteFromDao != null)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean suprEnquete(int idEnquete) {
		
		ed.openCurrentSession();
		Boolean result = ed.delete(idEnquete);
		ed.closeCurrentSession();
		
		return result;
	}
}
