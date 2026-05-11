package org.techhub.service;

import java.util.List;
import java.util.Optional;

import org.techhub.model.DeptModel;
import org.techhub.model.EmployeeModel;
import org.techhub.repository.*;

public class EmployeeServiceImpl implements EmployeeService{
	EmployeeRepository emprepo=new EmployeeRepositoryImpl();
	@Override
	public boolean isAddEmployee(EmployeeModel model) {
		
		return emprepo.isAddNewEmployee(model);
	}

	@Override
	public Optional<List<DeptModel>> getAllDeptList(DeptService deptService) {
		Optional<List<DeptModel>> o=deptService.getAllDepts();
		return o;
	}

	@Override
	public List<DeptModel> getDeptsForEmployee() {
        DeptService deptservice=new DeptServiceImpl();
        Optional<List<DeptModel>> o=this.getAllDeptList(deptservice);
		return o.get();
	}

	@Override
	public List<Object[]> getEmployeeWithDept() {

		return emprepo.getEmployeeswithDept();
	}

}
