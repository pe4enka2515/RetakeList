package com.example.retake.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "list_retakes")
public class Retake {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "teacher")
    private String teacher;
    @Column(name = "time_retake")
    private String time_retake;
    @Column(name = "room")
    private String room;
    @Column(name = "text_comment")
    private String text_comment;
    @Column(name = "departament")
    private String departament;
}
