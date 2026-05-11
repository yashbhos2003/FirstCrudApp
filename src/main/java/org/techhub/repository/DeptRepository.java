package org.techhub.repository;

import java.util.List;
import java.util.Optional;

import org.techhub.model.DeptModel;

public interface DeptRepository {
		public boolean isAddDept(DeptModel model);
		public Optional<List<DeptModel>> gatAllDepts();
		public boolean isDeleteDept(int deptid);
		public boolean isUpdateDept(DeptModel model);
}
