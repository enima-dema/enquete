package fr.humanbooster.fx.enquetes.ServiceImpl;

import java.util.List;

import fr.humanbooster.fx.enquetes.Service.FaitService;
import fr.humanbooster.fx.enquetes.business.Fait;
import fr.humanbooster.fx.enquetes.dao.FaitDao;
import fr.humanbooster.fx.enquetes.dao.impl.FaitDaoImpl;

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
