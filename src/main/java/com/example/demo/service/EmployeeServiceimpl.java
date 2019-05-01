package com.example.demo.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.mongo.dao.EmployeeDao;

@Service
public class EmployeeServiceimpl implements EmployeeService {

	// The dao repository will use the Mongodb-Repository to perform the database operations.
	@Autowired
	EmployeeDao dao;

	/* (non-Javadoc)
	 * @see com.assignment.springboot.mongo.service.Employeeservice#createEmployee(java.util.List)
	 */
	@Override
	public void createEmployee(List<Employee> emp) {
		dao.saveAll(emp);
	}

	/* (non-Javadoc)
	 * @see com.assignment.springboot.mongo.service.Employeeservice#getAllEmployees()
	 */
	@Override
	public Collection<Employee> getAllEmployees() {
		return dao.findAll();
	}

	/* (non-Javadoc)
	 * @see com.assignment.springboot.mongo.service.Employeeservice#findEmployeeById(int)
	 */
	@Override
	public Optional<Employee> findEmployeeById(int id) {
		return dao.findById(id);
	}

	/* (non-Javadoc)
	 * @see com.assignment.springboot.mongo.service.Employeeservice#deleteEmployeeById(int)
	 */
	@Override
	public void deleteEmployeeById(int id) {
		dao.deleteById(id);
	}

	/* (non-Javadoc)
	 * @see com.assignment.springboot.mongo.service.Employeeservice#updateEmployee(int)
	 */
	@Override
	public void updateEmployee(Employee emp) {
		dao.save(emp);
	}

	/* (non-Javadoc)
	 * @see com.assignment.springboot.mongo.service.Employeeservice#deleteAllEmployees()
	 */
	@Override
	public void deleteAllEmployees() {
		dao.deleteAll();
	}
}