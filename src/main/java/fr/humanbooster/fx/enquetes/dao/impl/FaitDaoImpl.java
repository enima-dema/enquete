package fr.humanbooster.fx.enquetes.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import fr.humanbooster.fx.enquetes.business.Fait;
import fr.humanbooster.fx.enquetes.dao.FaitDao;

public class FaitDaoImpl implements FaitDao{
	private Session session;
    private Transaction transaction;
    
    @Override
    public Fait create(Fait fait){
        session.save(fait);
        return fait;
    }

    
    @Override
    public Fait update(Fait fait){
        session.saveOrUpdate(fait);
        return fait;
    }

    
    @Override
    public boolean delete (int idFait){
    	Fait fait = findById(idFait);
        if(fait==null){
            return false;
        }
        session.delete(fait);
        return true;
    }

    @Override
    public Fait findById(int idFait) {       
        return session.byId(Fait.class).load(idFait);
    }

    @Override

    public List<Fait> findAll() {
        return session.createQuery("from Fait").getResultList();
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
