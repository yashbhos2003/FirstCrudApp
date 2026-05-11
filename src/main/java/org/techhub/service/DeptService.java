package org.techhub.service;

import java.util.List;
import java.util.Optional;

import org.techhub.model.DeptModel;

public interface DeptService {
	public boolean isAddNewDept(DeptModel model);
	public Optional<List<DeptModel>> getAllDepts();
	public boolean isDeleteDept(int id);
	public boolean isUpdateDept(DeptModel model);
}
