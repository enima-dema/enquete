package fr.humanbooster.fx.enquetes.service;

import java.util.List;

import fr.humanbooster.fx.enquetes.business.SiteInt;

public interface SiteIntService {

	public List<SiteInt> recupereSiteInt();
	
	public SiteInt recupereSiteInt (int id);
}
