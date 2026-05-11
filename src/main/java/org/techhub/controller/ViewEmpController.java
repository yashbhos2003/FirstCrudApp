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

import org.techhub.service.*;

@WebServlet("/viewemployee")
public class ViewEmpController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		RequestDispatcher r=request.getRequestDispatcher("dashboard.html");
		r.include(request, response);
		
		EmployeeService empservice=new EmployeeServiceImpl();
		out.println("<div class='container p-5 m-5'>");
		
		out.println("<table class='table table-striped'>");
		out.println("<tr><th>SRNO</th><th>NAME</th><th>EMAIL</th><th>CONTACT</th><th>SALARY</th><th>DEPARTMENT</th><th>DELETE</th><th>UPDATE</th></tr>");
		List<Object[]> list=empservice.getEmployeeWithDept();
		int count=0;
		for(Object obj[]:list) {
			++count;
			out.println("<tr><td>"+count+"</td><td>"+obj[0]+"</td><td>"+obj[1]+"</td><td>"+obj[2]+"</td><td>"+obj[3]+"</td><td>"+obj[4]+"</td><td>DELETE</td><td>UPDATE</td></tr>");

		}
		out.println("</table>");
		
		out.println("</div>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
