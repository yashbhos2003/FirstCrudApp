package org.techhub.repository;

import org.techhub.model.DeptModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class DeptRepositoryImpl extends DBConfig implements DeptRepository{
	List<DeptModel> deptList;
	@Override
	public boolean isAddDept(DeptModel model) {
		try {
			stmt=conn.prepareStatement("insert into dept values('0',?)");
			stmt.setString(1, model.getName());
			int value=stmt.executeUpdate();
			return value>0?true:false;
		}catch(Exception ex) {
			System.out.println("Error is"+ex);
			return false;
		}
		
	}

	@Override
	public Optional<List<DeptModel>> gatAllDepts() {
		try {
			deptList=new ArrayList<DeptModel>();
			stmt=conn.prepareStatement("select*from dept");
			rs=stmt.executeQuery();
			
			while(rs.next()) {
				DeptModel model=new DeptModel();
				model.setId(rs.getInt(1));
				model.setName(rs.getString(2));
				deptList.add(model);
			}
			return Optional.ofNullable(deptList);
			
		}catch(Exception ex) {
			System.out.println("exception is"+ex);
		}
		return null;
	}

	@Override
	public boolean isDeleteDept(int deptid) {
		try {
			stmt=conn.prepareStatement("Delete from dept where deptid=?");
			stmt.setInt(1, deptid);
			return stmt.executeUpdate()>0?true:false;
		}catch(Exception ex) {
			return false;
		}
	}

	@Override
	public boolean isUpdateDept(DeptModel model) {
		try {
			
			stmt=conn.prepareStatement("update dept set deptname=? where deptid=?");
			stmt.setString(1, model.getName());
			stmt.setInt(2, model.getId());
			
		     return stmt.executeUpdate()>0?true:false;

		}catch(Exception ex) {
			return false;
		}
	}

}
