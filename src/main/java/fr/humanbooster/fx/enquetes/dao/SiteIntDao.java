package fr.humanbooster.fx.enquetes.dao;

import java.util.List;

import org.hibernate.Session;

import fr.humanbooster.fx.enquetes.business.SiteInt;

public interface SiteIntDao {
	public SiteInt create(SiteInt siteInt);
	public SiteInt update(SiteInt siteInt);
	public boolean delete (int idSiteInt);
	public SiteInt findById(int idSiteInt);
	public List<SiteInt> findAll();

	public Session openCurrentSession();

	public Session openCurrentSessionWithTransaction();

	public void closeCurrentSession();

	public void closeCurrentSessionwithTransaction();
}
