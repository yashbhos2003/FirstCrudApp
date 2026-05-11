package org.techhub.repository;

import java.util.ArrayList;
import java.util.List;

import org.techhub.model.EmployeeModel;
import org.techhub.service.*;;

public class EmployeeRepositoryImpl extends DBConfig implements EmployeeRepository{
	private List<Object[]> list;
	@Override
	public boolean isAddNewEmployee(EmployeeModel model) {
		try {
			stmt=conn.prepareStatement("insert into employee values('0',?,?,?,?,?)");
			stmt.setString(1, model.getName());
			stmt.setString(2, model.getEmail());
			stmt.setString(3,model.getContact());
			stmt.setInt(4,model.getSalary());
			stmt.setInt(5, model.getDeptid());
			return stmt.executeUpdate()>0?true:false;
			
		}catch(Exception ex) {		
			return false;
		}
	}

	@Override
	public List<Object[]> getEmployeeswithDept() {
		try {
			list=new ArrayList<Object[]>();
			stmt=conn.prepareStatement("select e.name,e.email,e.contact,e.salary,d.deptname from employee e inner join dept d on e.deptid=d.deptid");
			rs=stmt.executeQuery();
			while(rs.next()) {
				Object obj[]=new Object[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5)};
				list.add(obj);
			}
			return list;
		}catch(Exception ex) {
			return null;
		}
	}
}
