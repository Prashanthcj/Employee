package com.in.spring.training.restapi;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class Empcontroller {
	
	@Autowired
	private Employeerepository employeerepo;

	
	 @Autowired
	    private EmpServiceInt employeeService;

	    // display list of employees
	    @GetMapping("/")
	    public String viewHomePage(Model model) {
	        model.addAttribute("listEmployees", employeeService.getAllEmployees());
	        return "index";
	    }

	    
	    
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
	    public String saveEmployee(@ModelAttribute("employee") @PathVariable Emp emp) {
	        // save employee to database
	        employeeService.saveEmployee(emp);
	        return "redirect:/";
	    }

	    

	    
	    @PostMapping("/addemp")
	    public String submitEmp(Employee employee)
	    {
	    	Emp emp =null;
	    	if(null != employee)
	    	{
	    		emp = new Emp(employee.getEmpid(),employee.getAge(),employee.getForename(),employee.getSurname(),employee.getPostcode());
	    	}
	    	
	    	
	    	employeerepo.save(emp);
	    	return"emp-added";
	    }
	    
	    @GetMapping("/deleteEmployee/{id}")
	    public String deleteEmployee(@PathVariable(value = "id") long id) {

	        // call delete employee method 
	        this.employeeService.deleteEmployeeById(id);
	        return "redirect:/";
	    }
	 
	    
	    
	

}
