package com.itstep.dao.template;

import com.itstep.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class TemplateStudentDAO {

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

    public Student getById(Long id){
      return jdbcTemplate.queryForObject(SELECT, new BeanPropertyRowMapper<>(Student.class), id);

    }
}
