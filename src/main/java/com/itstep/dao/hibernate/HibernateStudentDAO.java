package com.itstep.dao.hibernate;

import com.itstep.dao.StudentDAO;
import com.itstep.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;


public class HibernateStudentDAO implements StudentDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session openSession() {
        return sessionFactory.openSession();
    }

    @Override
    public void save(Student student){
        Session session = openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Student student){
        Session session = openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(student);
        transaction.commit();
        session.close();
    }

    @Override
    public Student getById(Long id){
        Query<Student> query =
                openSession().createQuery("FROM Student where id = :id_student", Student.class);
        query.setParameter("id_student", id);
       return query.getSingleResult();
    }

    @Override
    public void remove(Long id) {
        Session session = openSession();
        Transaction transaction = session.beginTransaction();
        Student byId = getById(id);
        session.remove(byId);
        transaction.commit();
        session.close();
    }

}
