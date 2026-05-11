package org.techhub.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.techhub.model.DeptModel;
import org.techhub.model.EmployeeModel;
import org.techhub.service.EmployeeService;
import org.techhub.service.EmployeeServiceImpl;


@WebServlet("/addemployee")
public class AddNewEmployeeController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		RequestDispatcher r=request.getRequestDispatcher("dashboard.html");
		r.include(request, response);
		
		EmployeeService empservice=new EmployeeServiceImpl();
		
		out.println("<form name='frm' action='' method='POST'>");
		out.println("<div class='container bg-dark p-5 m-2'>");
		
		out.println("<div class='form-group m-1'>");
		out.println("<input type='text' name='name' value='' class='form-control'/>");
		out.println("</div>");
		
		out.println("<div class='form-group m-1'>");
		out.println("<input type='text' name='email' value='' class='form-control'/>");
		out.println("</div>");
		
		out.println("<div class='form-group m-1'>");
		out.println("<input type='text' name='contact' value='' class='form-control'/>");
		out.println("</div>");
		
		out.println("<div class='form-group m-1'>");
		out.println("<input type='text' name='salary' value='' class='form-control'/>");
		out.println("</div>");
		
		List<DeptModel> deptlist=empservice.getDeptsForEmployee();
		out.println("<div class='form-group m-1'>");
		out.println("<select name= 'dept' class='form-control'>");
		out.println("<option>select department</option>");
		for(DeptModel model:deptlist) {
			out.println("<option value ='"+model.getId()+"'>"+model.getName()+"</option>");
		}
		out.println("</select>");
		out.println("</div>");
		
		out.println("<div class='form-group m-1'>");
		out.println("<input type='submit' name='s' value='add new employee' class='form-control'/>");
		out.println("</div>");
		
		out.println("</div>");
		out.println("</form>");
		
		String btn=request.getParameter("s");
		if(btn!=null) {
			String empName=request.getParameter("name");
			String email=request.getParameter("email");
			String contact=request.getParameter("contact");
			int sal=Integer.parseInt(request.getParameter("salary"));
			int deptid=Integer.parseInt(request.getParameter("dept").trim());
			
			out.println("<h1>"+empName+"</h1>");
			
			EmployeeModel model=new EmployeeModel(0,empName,email,contact,sal,deptid);
//			model.setId(deptid);
//			model.setName(empName);
//			model.setEmail(email);
//			model.setContact(contact);
//			model.setSalary(sal);
			
			boolean b=empservice.isAddEmployee(model);
			
			if(b) {
				out.println("<h1>new Employee is added</h1>");
			}else {
				out.println("<h1>Employee not added</h1>");
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
