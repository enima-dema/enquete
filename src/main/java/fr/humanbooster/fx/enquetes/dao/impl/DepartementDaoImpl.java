package fr.humanbooster.fx.enquetes.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import fr.humanbooster.fx.enquetes.business.Departement;
import fr.humanbooster.fx.enquetes.dao.DepartementDao;

public class DepartementDaoImpl implements DepartementDao{
	private Session session;
    private Transaction transaction;
    
    @Override
    public Departement create(Departement departement){
        session.save(departement);
        return departement;
    }

    
    @Override
    public Departement update(Departement departement){
        session.saveOrUpdate(departement);
        return departement;
    }

    
    @Override
    public boolean delete (int idDepartement){
    	Departement departement = findById(idDepartement);
        if(departement==null){
            return false;
        }
        session.delete(departement);
        return true;
    }

    @Override
    public Departement findById(int idDepartement) {       
        return session.byId(Departement.class).load(idDepartement);
    }

    @Override

    public List<Departement> findAll() {
        return session.createQuery("from Departement").getResultList();
    }

    @Override
    public Session openCurrentSession() {
        session = getSessionFactory().openSession();
        return session;
    }

    @Override
    public Session openCurrentSessionWithTransaction() {
        session = getSessionFactory().openSession();
        transaction = session.beginTransaction();
        return session;
    }

    @Override
    public void closeCurrentSession() {
        session.close();
    }

    @Override
    public void closeCurrentSessionwithTransaction() {
        transaction.commit();
        session.close();
    }

    private SessionFactory getSessionFactory() {
        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("/hibernate.cfg.xml")
                .build();
        Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        return sessionFactory;
    }
}
