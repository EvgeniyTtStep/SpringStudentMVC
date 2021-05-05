package com.itstep.dao.jdbc;

import com.itstep.model.Student;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.UUID;



public class JdbcStudentDAO {
    private static Connection connection;
    private static PreparedStatement preparedStatement;

    static {
        String url = "jdbc:mysql://localhost:3306/pa812";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, "root", "root");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    public void saveStudent(Student student) throws SQLException {
        preparedStatement =
                connection.prepareStatement("INSERT INTO `student`(name,phone) values (?,?)");
        preparedStatement.setString(1, student.getName());
        preparedStatement.setString(2, student.getPhone());
        preparedStatement.executeUpdate();
    }

    public Student getById(Long id) {
        Student student = new Student();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM `student` WHERE id_student = ?");
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                student.setName(resultSet.getString(1));
                student.setPhone(resultSet.getString(2));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return student;
    }
}
