package org.techhub.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeModel {
	private int id;
	private String name;
	private String email;
	private String contact;
	private int salary;
	private int deptid;	
}
