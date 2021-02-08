package com.in.spring.training.restapi;

import java.util.List;

public interface EmpServiceInt {
	
	 List<Emp> getAllEmployees();
	 void saveEmployee(Emp emp);
	    Emp getEmployeeById(long id);
	    void deleteEmployeeById(long id);

}
