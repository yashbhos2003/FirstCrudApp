package org.techhub.service;

import java.util.List;
import java.util.Optional;

import org.techhub.model.DeptModel;
import org.techhub.model.EmployeeModel;

public interface EmployeeService {
	public boolean isAddEmployee(EmployeeModel model);
	public Optional<List<DeptModel>> getAllDeptList(DeptService deprService);
	public List<DeptModel> getDeptsForEmployee();
	public List<Object[]> getEmployeeWithDept();
}
