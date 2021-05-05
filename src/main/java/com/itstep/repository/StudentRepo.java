package com.itstep.repository;

import com.itstep.model.Student;
import com.itstep.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    public Student findByPhone(String phone);
    public List<Student> findAllByTeachers(Teacher teacher);
    public  Student getStudentById(Long id);
}
