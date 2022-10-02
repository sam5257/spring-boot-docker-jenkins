package com.chat.many.controller;

import com.chat.many.entity.Course;
import com.chat.many.entity.Student;
import com.chat.many.repository.CourseRepository;
import com.chat.many.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/student/course")
public class StudentCourseController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;



    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Student saveStudentWithCourse(@RequestBody Student student)
    {

        return studentRepository.save(student);

    }
    
     @GetMapping("/welcome")
    public String welcome()
    {
        return "Welcome Sameer";
    }


    @GetMapping
    public List<Student> findAllStudents()
    {
        return studentRepository.findAll();
    }

@GetMapping("/{studentId}")
    public Student findStudent(@PathVariable Long id)
    {
        return studentRepository.findById(id).orElse(null);
    }


    @GetMapping("/find/{name}")
    public List<Student> findStudentsContainingByName(@PathVariable String name)
    {
        return studentRepository.findByNameContaining(name);
    }

    @GetMapping("/search/{price}")
    public List<Course> findCourseLessThanPrice(double price)
    {
        return courseRepository.findByFeeLessThan(price);
    }
}
