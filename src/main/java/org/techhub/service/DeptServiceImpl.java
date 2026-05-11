package org.techhub.service;

import java.util.List;
import java.util.Optional;

import org.techhub.model.DeptModel;
import org.techhub.repository.*;

public class DeptServiceImpl implements DeptService {
	DeptRepository deptrepo=new DeptRepositoryImpl();
	@Override
	public boolean isAddNewDept(DeptModel model) {
		
		return  deptrepo.isAddDept(model);
	}
	@Override
	public Optional<List<DeptModel>> getAllDepts() {
		return deptrepo.gatAllDepts();
	}
	@Override
	public boolean isDeleteDept(int id) {

		return deptrepo.isDeleteDept(id);
	}
	@Override
	public boolean isUpdateDept(DeptModel model) {

		return deptrepo.isUpdateDept(model);
	}

}
