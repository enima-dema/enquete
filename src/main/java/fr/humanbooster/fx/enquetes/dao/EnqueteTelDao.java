package fr.humanbooster.fx.enquetes.dao;

import java.util.List;

import org.hibernate.Session;

import fr.humanbooster.fx.enquetes.business.EnqueteTel;

public interface EnqueteTelDao {
	public EnqueteTel create(EnqueteTel enqueteTel);
	public EnqueteTel update(EnqueteTel enqueteTel);
	public boolean delete (int idEnqueteTel);
	public EnqueteTel findById(int idEnqueteTel);
	public List<EnqueteTel> findAll();

	public Session openCurrentSession();

	public Session openCurrentSessionWithTransaction();

	public void closeCurrentSession();

	public void closeCurrentSessionwithTransaction();
}
