package fr.humanbooster.fx.enquetes.service.impl;

import java.util.List;

import fr.humanbooster.fx.enquetes.business.Fait;
import fr.humanbooster.fx.enquetes.dao.FaitDao;
import fr.humanbooster.fx.enquetes.dao.impl.FaitDaoImpl;
import fr.humanbooster.fx.enquetes.service.FaitService;

public class FaitServiceImpl implements FaitService {

	FaitDao fd = new FaitDaoImpl();
	
	@Override
	public List<Fait> recupereFait() {
		fd.openCurrentSession();
		List<Fait> faits = fd.findAll();
		fd.closeCurrentSession();
		return faits;
	}

	@Override
	public Fait recupereFait(int id) {
		fd.openCurrentSession();
		Fait fait = fd.findById(id);
		fd.closeCurrentSession();
		return fait;
	}

}
