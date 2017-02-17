package fr.humanbooster.fx.enquetes.dao.impl;

import fr.humanbooster.fx.enquetes.business.Question;
import fr.humanbooster.fx.enquetes.dao.QuestionDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class QuestionDaoImpl implements QuestionDao{
	private Session session;
    private Transaction transaction;
    
    @Override
    public Question create(Question question){
        session.save(question);
        return question;
    }

    
    @Override
    public Question update(Question question){
        session.saveOrUpdate(question);
        return question;
    }

    
    @Override
    public boolean delete (int idQuestion){
    	Question question = findById(idQuestion);
        if(question==null){
            return false;
        }
        session.delete(question);
        return true;
    }

    @Override
    public Question findById(int idQuestion) {       
        return session.byId(Question.class).load(idQuestion);
    }

    @Override

    public List<Question> findAll() {
        return session.createQuery("from Question").getResultList();
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
