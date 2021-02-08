package com.in.spring.training.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public  class ServiceImp implements EmpServiceInt {
	
	 @Autowired
	    private Employeerepository employeerepo;

	    @Override
	    public List<Emp> getAllEmployees() {
	        return employeerepo.findAll();
	    }
	    
	    @Override
	    public void saveEmployee(Emp emp)
	    {
	    	this.employeerepo.save(emp);
	    }
	    
	    @Override
	    public Emp getEmployeeById(long id) {
	        java.util.Optional<Emp> optional = employeerepo.findById(id);
	        Emp employee = null;
	        if (optional.isPresent()) {
	            employee = optional.get();
	        } else {
	            throw new RuntimeException(" Employee not found for id :: " + id);
	        }
	        return employee;
	    }
	    

	    @Override
	    public void deleteEmployeeById(long id) {
	        this.employeerepo.deleteById(id);
	    }
	    

}
