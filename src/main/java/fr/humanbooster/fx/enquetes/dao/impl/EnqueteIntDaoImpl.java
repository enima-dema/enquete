package fr.humanbooster.fx.enquetes.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import fr.humanbooster.fx.enquetes.business.EnqueteInt;
import fr.humanbooster.fx.enquetes.dao.EnqueteIntDao;

public class EnqueteIntDaoImpl implements EnqueteIntDao{
	private Session session;
    private Transaction transaction;
    
    @Override
    public EnqueteInt create(EnqueteInt enqueteInt){
        session.save(enqueteInt);
        return enqueteInt;
    }

    
    @Override
    public EnqueteInt update(EnqueteInt enqueteInt){
        session.saveOrUpdate(enqueteInt);
        return enqueteInt;
    }

    
    @Override
    public boolean delete (int idEnqueteInt){
    	EnqueteInt enqueteInt = findById(idEnqueteInt);
        if(enqueteInt==null){
            return false;
        }
        session.delete(enqueteInt);
        return true;
    }

    @Override
    public EnqueteInt findById(int idEnqueteInt) {       
        return session.byId(EnqueteInt.class).load(idEnqueteInt);
    }

    @Override

    public List<EnqueteInt> findAll() {
        return session.createQuery("from EnqueteInt").getResultList();
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
