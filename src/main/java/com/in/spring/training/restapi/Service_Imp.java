package com.in.spring.training.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public  class Service_Imp implements Emp_Service_Int {
	
	 @Autowired
	    private Employee_Repository employee_repo;

	    @Override
	    public List<Emp> getAllEmployees() {
	        return employee_repo.findAll();
	    }
	    
	    @Override
	    public void saveEmployee(Emp emp)
	    {
	    	this.employee_repo.save(emp);
	    }
	    
	    @Override
	    public Emp getEmployeeById(long id) {
	        java.util.Optional<Emp> optional = employee_repo.findById(id);
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
	        this.employee_repo.deleteById(id);
	    }
	    

}
