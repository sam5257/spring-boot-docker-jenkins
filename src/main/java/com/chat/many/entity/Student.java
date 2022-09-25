package com.chat.many.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "STUDENT_TBL")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private  int age;
    private String dept;



    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "STUDENT_COURSE_TABLE",
    joinColumns = {
            @JoinColumn(name = "student_id",referencedColumnName = "id")
    },
            inverseJoinColumns = {
            @JoinColumn(name="course_id",referencedColumnName = "id")
            }
    )

    private Set<Course> courses;

}
