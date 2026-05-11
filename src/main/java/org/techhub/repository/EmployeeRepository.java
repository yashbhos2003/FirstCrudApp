package org.techhub.repository;

import java.util.List;

import org.techhub.model.EmployeeModel;

public interface EmployeeRepository {
	public boolean isAddNewEmployee(EmployeeModel model);
	public List<Object[]> getEmployeeswithDept();
}
