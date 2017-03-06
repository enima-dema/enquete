package fr.humanbooster.fx.enquetes.service.impl;

import java.util.List;

import fr.humanbooster.fx.enquetes.business.SiteInt;
import fr.humanbooster.fx.enquetes.dao.SiteIntDao;
import fr.humanbooster.fx.enquetes.dao.impl.SiteIntDaoImpl;
import fr.humanbooster.fx.enquetes.service.SiteIntService;

public class SiteIntServiceImpl implements SiteIntService {

	SiteIntDao sid = new SiteIntDaoImpl();
	
	@Override
	public List<SiteInt> recupereSiteInt() {
		sid.openCurrentSession();
		List<SiteInt> siteInts = sid.findAll();
		sid.closeCurrentSession();
		return siteInts;
		
	}

	@Override
	public SiteInt recupereSiteInt(int id) {
		sid.openCurrentSession();
		SiteInt siteInt = sid.findById(id);
		sid.closeCurrentSession();
		return siteInt;
	}

}
