package com.aa.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aa.main.entity.Employee; 
// JpaRepository already gives us save(), findById(), findAll(Pageable), deleteById(), etc.
// We don't need to write any SQL ourselves.
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

