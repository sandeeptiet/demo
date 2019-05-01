package com.example.demo;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@SpringBootApplication
@RestController
public class DemoApplication {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@GetMapping(path="/hello")
	public String sayHello() {
		logger.info("hello world logging");
		return "Hello";
	}
	
	@Autowired
    EmployeeService serv;
 
    /**
     * Method to save employees in the db.
     * @param emp
     * @return
     */
    @PostMapping(value= "/create")
    public String create(@RequestBody List<Employee> emp) {
        logger.debug("Saving employees.");
        serv.createEmployee(emp);
        return "Employee records created.";
    }
 
    /**
     * Method to fetch all employees from the db.
     * @return
     */
    @GetMapping(value= "/getall")
    public Collection<Employee> getAll() {
        logger.debug("Getting all employees.");
        return serv.getAllEmployees();
    }
 
    /**
     * Method to fetch employee by id.
     * @param id
     * @return
     */
    @GetMapping(value= "/getbyid/{employee-id}")
    public Optional<Employee> getById(@PathVariable(value= "employee-id") int id) {
        logger.debug("Getting employee with employee-id= {}.", id);
        return serv.findEmployeeById(id);
    }
 
    /**
     * Method to update employee by id.
     * @param id
     * @param e
     * @return
     */
    @PutMapping(value= "/update/{employee-id}")
    public String update(@PathVariable(value= "employee-id") int id, @RequestBody Employee e) {
        logger.debug("Updating employee with employee-id= {}.", id);
        e.setId(id);
        serv.updateEmployee(e);
        return "Employee record for employee-id= " + id + " updated.";
    }
 
    /**
     * Method to delete employee by id.
     * @param id
     * @return
     */
    @DeleteMapping(value= "/delete/{employee-id}")
    public String delete(@PathVariable(value= "employee-id") int id) {
        logger.debug("Deleting employee with employee-id= {}.", id);
        serv.deleteEmployeeById(id);
        return "Employee record for employee-id= " + id + " deleted.";
    }
 
    /**
     * Method to delete all employees from the db.
     * @return
     */
    @DeleteMapping(value= "/deleteall")
    public String deleteAll() {
        logger.debug("Deleting all employees.");
        serv.deleteAllEmployees();
        return "All employee records deleted.";
    }

}
