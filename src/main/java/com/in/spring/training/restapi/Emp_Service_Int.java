package com.in.spring.training.restapi;

import java.util.List;

public interface Emp_Service_Int {
	
	 List<Emp> getAllEmployees();
	 void saveEmployee(Emp emp);
	    Emp getEmployeeById(long id);
	    void deleteEmployeeById(long id);

}
