package fr.humanbooster.fx.enquetes.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import fr.humanbooster.fx.enquetes.business.Enquete;
import fr.humanbooster.fx.enquetes.dao.EnqueteDao;

public class EnqueteDaoImpl implements EnqueteDao{
	private Session session;
    private Transaction transaction;
    
    @Override
    public Enquete create(Enquete enquete){
        session.save(enquete);
        return enquete;
    }

    
    @Override
    public Enquete update(Enquete enquete){
        session.saveOrUpdate(enquete);
        return enquete;
    }

    
    @Override
    public boolean delete (int idEnquete){
    	Enquete enquete = findById(idEnquete);
        if(enquete==null){
            return false;
        }
        session.delete(enquete);
        return true;
    }

    @Override
    public Enquete findById(int idEnquete) {       
        return session.byId(Enquete.class).load(idEnquete);
    }

    @SuppressWarnings("unchecked")
	@Override

    public List<Enquete> findAll() {
        return session.createQuery("from Enquete").getResultList();
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
