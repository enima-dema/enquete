package fr.humanbooster.fx.enquetes.ServiceImpl;

import java.util.List;

import fr.humanbooster.fx.enquetes.Service.CritereService;
import fr.humanbooster.fx.enquetes.business.Critere;
import fr.humanbooster.fx.enquetes.business.Departement;
import fr.humanbooster.fx.enquetes.business.Enquete;
import fr.humanbooster.fx.enquetes.business.Fait;
import fr.humanbooster.fx.enquetes.dao.CritereDao;
import fr.humanbooster.fx.enquetes.dao.DepartementDao;
import fr.humanbooster.fx.enquetes.dao.EnqueteDao;
import fr.humanbooster.fx.enquetes.dao.FaitDao;
import fr.humanbooster.fx.enquetes.dao.impl.CritereDaoImpl;
import fr.humanbooster.fx.enquetes.dao.impl.DepartementDaoImpl;
import fr.humanbooster.fx.enquetes.dao.impl.EnqueteDaoImpl;
import fr.humanbooster.fx.enquetes.dao.impl.FaitDaoImpl;

public class CritereServiceImpl implements CritereService {

	CritereDao cd = new CritereDaoImpl();
	DepartementDao dd = new DepartementDaoImpl();
	FaitDao fd = new FaitDaoImpl();
	EnqueteDao ed = new EnqueteDaoImpl();
	
	@Override
	public List<Critere> recupereCritere() {
		cd.openCurrentSession();
		List<Critere> criteres = cd.findAll();
		cd.closeCurrentSession();
		return criteres;
	}

	@Override
	public Critere recupereCritere(int id) {
		cd.openCurrentSession();
		Critere critere = cd.findById(id);
		cd.closeCurrentSession();
		return critere;
	}

	@Override
	public Critere creerCritere(int quotat, int idDepartement, int idFait, int idEnquete) {
		Departement departement = dd.findById(idDepartement);
		Fait fait = fd.findById(idFait);
		Enquete enquete = ed.findById(idEnquete);
		
		Critere critere = new Critere();
		critere.setQuotat(quotat);
		critere.setDepartement(departement);
		critere.setFait(fait);
		critere.setEnquete(enquete);
		
		cd.openCurrentSession();
		cd.create(critere);
		cd.closeCurrentSession();
		return critere;
	}

}
