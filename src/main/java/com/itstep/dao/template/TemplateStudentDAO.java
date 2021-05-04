package com.itstep.dao.template;

import com.itstep.dao.StudentDAO;
import com.itstep.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class TemplateStudentDAO implements StudentDAO {

    private static final String INSERT = "INSERT INTO `student` values (?,?)";
    private static final String SELECT = "SELECT * from `student` where id_student= ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Student student){
        jdbcTemplate.update(INSERT, student.getName(), student.getPhone());
    }

    @Override
    public void update(Student student) {

    }

    public Student getById(Long id){
      return jdbcTemplate.queryForObject(SELECT, new BeanPropertyRowMapper<>(Student.class), id);

    }

    @Override
    public void remove(Long aLong) {

    }
}
