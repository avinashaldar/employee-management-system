package com.aa.main.controller;

import com.aa.main.entity.Employee;
import com.aa.main.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

 private final EmployeeService employeeService;

 @PostMapping
 public ResponseEntity<Employee> create(@RequestBody Employee employee) {
     Employee saved = employeeService.create(employee);
     return ResponseEntity.status(HttpStatus.CREATED).body(saved);
 }

 @GetMapping
 public ResponseEntity<Page<Employee>> getAll(
         @RequestParam(defaultValue = "0") int page,
         @RequestParam(defaultValue = "5") int size,
         @RequestParam(defaultValue = "id") String sortBy,
         @RequestParam(defaultValue = "asc") String direction) {

     Page<Employee> employees = employeeService.getAll(page, size, sortBy, direction);
     return ResponseEntity.ok(employees);
 }

 @GetMapping("/{id}")
 public ResponseEntity<Employee> getById(@PathVariable Long id) {
     return ResponseEntity.ok(employeeService.getById(id));
 }

 @PutMapping("/{id}")
 public ResponseEntity<Employee> update(@PathVariable Long id, @RequestBody Employee employee) {
     return ResponseEntity.ok(employeeService.update(id, employee));
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> delete(@PathVariable Long id) {
     employeeService.delete(id);
     return ResponseEntity.noContent().build();
 }
}
