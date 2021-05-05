package com.itstep.model;

import javax.persistence.*;

@Entity
@Table
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    Student student;

    public Work() {
    }

    public Work(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
