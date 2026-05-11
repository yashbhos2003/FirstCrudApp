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
import java.util.Optional;

import org.techhub.model.DeptModel;
import org.techhub.service.DeptService;
import org.techhub.service.DeptServiceImpl;


@WebServlet("/view")
public class ViewDeptController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		RequestDispatcher r=request.getRequestDispatcher("dashboard.html");
		r.include(request, response);
		out.println("<br>");
		out.println("<div class='container'>");
		out.println("<table class='table table-striped'>");
		
		out.println("<tr>");
		out.println("<th>SRNO</th>");
		out.println("<th>DEPTNAME</th>");
		out.println("<th><a href=''>DELETE</a></th>");
		out.println("<th><a href=''>UPDATE</a></th>");
		out.println("</tr>");
		
		DeptService deptservice=new DeptServiceImpl();
		Optional<List<DeptModel>> o=deptservice.getAllDepts();
     
		if(o.isPresent()) {
			List<DeptModel> list=o.get();
			int count=0;
			boolean flag=false;
			for(DeptModel model:list) {
				++count;
				flag=true;
				out.println("<tr>");
				out.println("<td>"+count+"</td>");
				out.println("<td>"+model.getName()+"</td>");
				out.println("<td><a href='deldept?did="+model.getId()+"'>DELETE</a></td>");
				out.println("<td><a href='update?did="+model.getId()+"&dname="+model.getName()+"'>UPDATE</a></td>");
				out.println("</tr>");
			}
			if(!flag) {
				out.println("<tr><td colspan='3'>No data found in dept</td></tr>");
			}
		}
		out.println("</table>");
		out.println("</div>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
