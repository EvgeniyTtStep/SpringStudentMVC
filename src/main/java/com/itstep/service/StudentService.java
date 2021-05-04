package com.itstep.service;

import com.itstep.dao.StudentDAO;
import com.itstep.model.Student;
import com.itstep.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepo studentRepo;

    private StudentDAO hibernateStudentDAO;

    @Autowired
    public void setStudentDAO(StudentDAO hibernateStudentDAO) {
        this.hibernateStudentDAO = hibernateStudentDAO;
    }

    @Autowired
    public void setStudentRepo(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    //    private JdbcStudentDAO jdbcStudentDAO;
//
//    private TemplateStudentDAO templateStudentDAO;
//
//    private HibernateStudentDAO hibernateStudentDAO;
//
//
//    @Autowired
//    public void setStudentDAO(TemplateStudentDAO templateStudentDAO) {
//        this.templateStudentDAO = templateStudentDAO;
//    }
//
//    @Autowired
//    public void setStudentDAO(JdbcStudentDAO jdbcStudentDAO) {
//        this.jdbcStudentDAO = jdbcStudentDAO;
//    }
//
//
//    @Autowired
//    public void setHibernateStudentDAO(HibernateStudentDAO hibernateStudentDAO) {
//        this.hibernateStudentDAO = hibernateStudentDAO;
//    }



    public Student save(Student student) {
        return studentRepo.saveAndFlush(student);
        //jdbcStudentDAO.saveStudent(student);
        //templateStudentDAO.save(student);
//        if(hibernateStudentDAO != null) {
//            //hibernateStudentDAO.save(student);
//
//        }
    }

    public Student getById(Long id) {
        //return jdbcStudentDAO.getById(id);
        if (id == null) {
            return null;
        } else {
            return hibernateStudentDAO.getById(id);
        }

    }


    public Student byPhone(String phone){
        return studentRepo.findByPhone(phone);
    }
}
