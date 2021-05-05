package com.itstep.service;

import com.itstep.model.Student;
import com.itstep.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepo studentRepo;



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
            return studentRepo.getStudentById(id);
        }

    }

    public List<Student> showAll(){
        return studentRepo.findAll();
    }


    public Student byPhone(String phone){
        return studentRepo.findByPhone(phone);
    }
}
