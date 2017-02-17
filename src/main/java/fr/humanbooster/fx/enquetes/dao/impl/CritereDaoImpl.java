package fr.humanbooster.fx.enquetes.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import fr.humanbooster.fx.enquetes.business.Critere;
import fr.humanbooster.fx.enquetes.dao.CritereDao;

public class CritereDaoImpl implements CritereDao{
	private Session session;
    private Transaction transaction;
    
    @Override
    public Critere create(Critere critere){
        session.save(critere);
        return critere;
    }

    
    @Override
    public Critere update(Critere critere){
        session.saveOrUpdate(critere);
        return critere;
    }

    
    @Override
    public boolean delete (int idCritere){
    	Critere critere = findById(idCritere);
        if(critere==null){
            return false;
        }
        session.delete(critere);
        return true;
    }

    @Override
    public Critere findById(int idCritere) {       
        return session.byId(Critere.class).load(idCritere);
    }

    @Override

    public List<Critere> findAll() {
        return session.createQuery("from Critere").getResultList();
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
