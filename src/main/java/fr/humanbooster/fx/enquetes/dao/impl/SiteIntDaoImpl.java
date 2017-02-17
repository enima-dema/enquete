package fr.humanbooster.fx.enquetes.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import fr.humanbooster.fx.enquetes.business.SiteInt;
import fr.humanbooster.fx.enquetes.dao.SiteIntDao;

public class SiteIntDaoImpl implements SiteIntDao {
	private Session session;
    private Transaction transaction;
    
    @Override
    public SiteInt create(SiteInt siteInt){
        session.save(siteInt);
        return siteInt;
    }

    
    @Override
    public SiteInt update(SiteInt siteInt){
        session.saveOrUpdate(siteInt);
        return siteInt;
    }

    
    @Override
    public boolean delete (int idSiteInt){
    	SiteInt siteInt = findById(idSiteInt);
        if(siteInt==null){
            return false;
        }
        session.delete(siteInt);
        return true;
    }

    @Override
    public SiteInt findById(int idSiteInt) {       
        return session.byId(SiteInt.class).load(idSiteInt);
    }

    @Override

    public List<SiteInt> findAll() {
        return session.createQuery("from SiteInt").getResultList();
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
