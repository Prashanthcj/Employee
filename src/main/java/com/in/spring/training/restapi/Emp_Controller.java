package com.in.spring.training.restapi;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class Emp_Controller {
	
	@Autowired
	private Employee_Repository employee_repo;

	
	 @Autowired
	    private Emp_Service_Int employeeService;

	    // display list of employees
	    @GetMapping("/")
	    public String viewHomePage(Model model) {
	        model.addAttribute("listEmployees", employeeService.getAllEmployees());
	        return "index";
	    }
//		@GetMapping("/")
//		public String home(){
//			return"index";
//			
//		}
	    
	    
	    @GetMapping("/addemp")
	    public String getAddEmp() {
	        return "addemp";
	    }
	    
	    @GetMapping("/showFormForUpdate/{id}")
	    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

	        // get employee from the service
	        Emp emp = employeeService.getEmployeeById(id);

	        // set employee as a model attribute to pre-populate the form
	        model.addAttribute("employee", emp);
	        return "update_employee";
	    }
	
	    
	    @PostMapping("/saveEmployee")
	    public String saveEmployee(@ModelAttribute("employee") Emp emp) {
	        // save employee to database
	        employeeService.saveEmployee(emp);
	        return "redirect:/";
	    }

	    
	    
//	    @GetMapping()
//	    public String getAllEmployees(Model model)
//	    {
//	    	model.addAttribute("employee_repo",employee_repo.values());
//	    	return"allemp";
//	    }
	    
//	    @GetMapping("/emp/{id}")
//	    public Optional<Emp> getEmpBYId(@PathVariable Long id) {
//	    	return employee_repo.findById(id);
//	    }
//	    
//	    @GetMapping("/allemp")
//	    public List<Emp> getAllEmp()
//	    {
//	    	return employee_repo.findAll();
//	    }
//	    
//	    @PutMapping("/edit/{id}")
//	    public Optional<Emp> updateEmp(Employee employee,@PathVariable Long id)
//	    {
//	    	Emp em = null;
//	    	Optional<Emp> e = employee_repo.findById(id);
//	    	if(e.isPresent())
//	    	{
//	    		em = e.get();
//	    		em.setAge(employee.getAge());
//	    		em.setForename(employee.getForename());
//	    		em.setSurname(employee.getSurname());
//	    		em.setPostcode(employee.getPostcode());
//	    		employee_repo.save(em);
//	    		
//	    	}
//	    	else {
//	    		return Optional.ofNullable(new Emp());
//	    	}
//	    	return Optional.ofNullable(em);
//	    }
	    
	    @PostMapping("/addemp")
	    public String submitEmp(Employee employee)
	    {
	    	Emp emp =null;
	    	if(null != employee)
	    	{
	    		emp = new Emp(employee.getEmp_id(),employee.getAge(),employee.getForename(),employee.getSurname(),employee.getPostcode());
	    	}
	    	employee_repo.save(emp);
	    	return"emp-added";
	    }
	    
	    @GetMapping("/deleteEmployee/{id}")
	    public String deleteEmployee(@PathVariable(value = "id") long id) {

	        // call delete employee method 
	        this.employeeService.deleteEmployeeById(id);
	        return "redirect:/";
	    }
	 
	    
	    
	

}
