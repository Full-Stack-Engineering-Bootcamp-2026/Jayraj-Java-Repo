package com.app.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String description;
    private String status; 

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id") 
    private Employee employee;
}