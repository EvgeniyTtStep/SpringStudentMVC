package com.itstep.controller;

import com.itstep.model.Student;
import com.itstep.model.Teacher;
import com.itstep.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/student", method = RequestMethod.GET)
public class StudentController {
    List<Student> students = new ArrayList<>();
//{
//   students.add(new Student("Tom", "8800222"));
//        students.add(new Student("Jeck", "8800333"));
//    }

    private StudentService studentService;

    @Autowired
    public void setService(StudentService service) {
        this.studentService = service;
    }

    @GetMapping({"", "/id={id}"})
    public String showStudent(@PathVariable(name = "id", required = false)@Nullable Long id,
                                          Model model, Map<String, Object> studentMap) {
        Student student = new Student("Ivan", "1234");
        Student student1 = studentService.getById(id);
        model.addAttribute("student", student);
        studentMap.put("studentMap", student);
        studentMap.put("studentById",student1);
        model.addAttribute("studentByPhone", studentService.byPhone("2423"));
        System.out.println(student1);
        //studentMap.put("students", students);
        return "student";
    }

    @GetMapping(value = "/new_get")
    public String newStudent() {
        return "new_student";
    }

//    @PostMapping("student/new")
//    public String newPostStudent(@RequestParam("name") String name,
//                                 @RequestParam("phone") String phone) {
//        students.add(new Student(name, phone));
//        return "redirect:/student";//вызов другого контроллера
//    }

    @PostMapping(value = "/new_post")
    public String newPostStudent(@ModelAttribute Student student) {
        //students.add(student);
        studentService.save(student);
        return "redirect:/student";//вызов другого контроллера
    }
}
