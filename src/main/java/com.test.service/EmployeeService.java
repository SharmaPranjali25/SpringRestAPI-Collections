package com.test.service;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.test.dao.EmployeeDao;
import com.test.model.Employees;
import com.test.model.Employee;


@Repository
@Service
public class EmployeeService implements EmployeeDao{
	
	private static Employees empData= new Employees();
	static {
		empData.getEmpList().add(new Employee(1,"Rohit", "ICC"));
		empData.getEmpList().add(new Employee(2,"Rahul", "BCCI"));
		empData.getEmpList().add(new Employee(3,"Virat", "IPL"));
		empData.getEmpList().add(new Employee(4,"Rohit", "IPL"));
		empData.getEmpList().add(new Employee(5,"Rohit", "BCC"));
		empData.getEmpList().add(new Employee(6,"Rohit", "ICC"));
	}
	
	@Override
		public Employee createEmployee(Employee emp)
		
		{
			empData.getEmpList().add(emp);
			return emp;
		}
	
	@Override
	public List<Employee> readAllEmployees()
	{
		return empData.getEmpList();
	}
	
	@Override
	public String updateEmployee(Employee emp) {
		
		for(int i=0;i< empData.getEmpList().size(); i++) {
			Employee e= empData.getEmpList().get(i);
			if(e.getId().equals(emp.getId())) {
				empData.getEmpList().set(i, emp);
			}
			
		}
		
		
		
		return "this given id is not avialable";
	}

	@Override
	public String deleteEmployee(Integer id) {
		
		for(int i=0; i<empData.getEmpList().size();i++) {
			Employee emp= empData.getEmpList().get(i);
			if(emp.getId().equals(id)) {
				empData.getEmpList().remove(i);
			}
		}
		
		
		return "given id is not avialable";
	}

	
	

}
