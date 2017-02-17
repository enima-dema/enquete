package fr.humanbooster.fx.enquetes.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import fr.humanbooster.fx.enquetes.business.EnqueteTel;
import fr.humanbooster.fx.enquetes.dao.EnqueteTelDao;

public class EnqueteTelDaoImpl implements EnqueteTelDao{
	private Session session;
    private Transaction transaction;
    
    @Override
    public EnqueteTel create(EnqueteTel enqueteTel){
        session.save(enqueteTel);
        return enqueteTel;
    }

    
    @Override
    public EnqueteTel update(EnqueteTel enqueteTel){
        session.saveOrUpdate(enqueteTel);
        return enqueteTel;
    }

    
    @Override
    public boolean delete (int idEnqueteTel){
    	EnqueteTel enqueteTel = findById(idEnqueteTel);
        if(enqueteTel==null){
            return false;
        }
        session.delete(enqueteTel);
        return true;
    }

    @Override
    public EnqueteTel findById(int idEnqueteTel) {       
        return session.byId(EnqueteTel.class).load(idEnqueteTel);
    }

    @Override

    public List<EnqueteTel> findAll() {
        return session.createQuery("from EnqueteTel").getResultList();
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
