package com.afs.restfulapi;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class EmployeeRepository {
    private final List<Employee> employees  =new ArrayList<>();


    public EmployeeRepository() {
        employees.add(new Employee(1,"Vincent",18,"male",1000000));

    }

    public List<Employee> findAll(){
        return employees;
    }

    public Employee findById(Integer id){
        return this.employees.stream()
                .filter(item -> id.equals(item.getId()))
                .findFirst()
                .orElseThrow(EmployeeNotFoundException::new)
                ;
                //orElseThrow(()->new EmployeeNotFoundException())

    }

    public Employee createEmployee(Employee employee) {
        int id = this.employees.stream()
                .mapToInt(Employee::getId)
                .max()
                .orElse(0) + 1;
        employee.setId(id);
        this.employees.add(employee);
        return employee;
    }
}
