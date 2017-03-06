package fr.humanbooster.fx.enquetes.service.impl;

import java.util.List;

import fr.humanbooster.fx.enquetes.business.Departement;
import fr.humanbooster.fx.enquetes.dao.DepartementDao;
import fr.humanbooster.fx.enquetes.dao.impl.DepartementDaoImpl;
import fr.humanbooster.fx.enquetes.service.DepartementService;

public class DepartementImpl implements DepartementService {

	DepartementDao dd = new DepartementDaoImpl();
	
	@Override
	public List<Departement> recupereDepartement() {
		dd.openCurrentSession();
		List<Departement> departements = dd.findAll();
		dd.closeCurrentSession();
		return departements;
	}

	@Override
	public Departement recupereDepartement(int id) {
		dd.openCurrentSession();
		Departement departement = dd.findById(id);
		dd.closeCurrentSession();
		return departement;
	}

}
