package com.afs.restfulapi;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public List<Employee> findAllEmployees(){
        return this.employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee findByID(@PathVariable Integer id){
        return this.employeeRepository.findById(id);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return this.employeeRepository.createEmployee(employee);
    }

}
