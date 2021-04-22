package com.itstep.service;

import com.itstep.dao.jdbc.JdbcStudentDAO;
import com.itstep.dao.template.TemplateStudentDAO;
import com.itstep.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private JdbcStudentDAO jdbcStudentDAO;

    private TemplateStudentDAO templateStudentDAO;


    @Autowired
    public void setStudentDAO(TemplateStudentDAO templateStudentDAO) {
        this.templateStudentDAO = templateStudentDAO;
    }

    @Autowired
    public void setStudentDAO(JdbcStudentDAO jdbcStudentDAO) {
        this.jdbcStudentDAO = jdbcStudentDAO;
    }


    public void save(Student student) {
        //jdbcStudentDAO.saveStudent(student);
        templateStudentDAO.save(student);
    }

    public Student getById(Long id) {
        //return jdbcStudentDAO.getById(id);
        if (id == null) {
            return null;
        } else {
            return templateStudentDAO.getById(id);
        }
    }
}
