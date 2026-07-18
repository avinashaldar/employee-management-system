package com.aa.main.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
@Data                 
@NoArgsConstructor     
@AllArgsConstructor    
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    private String name;

    private String email;

    private String department;

    private String position;

    private Double salary;

    private LocalDate dateOfJoining;
}