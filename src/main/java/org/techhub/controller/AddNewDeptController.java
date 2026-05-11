package org.techhub.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import org.techhub.model.DeptModel;
import org.techhub.service.DeptService;
import org.techhub.service.DeptServiceImpl;

@WebServlet("/adddept")
public class AddNewDeptController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			
			RequestDispatcher r=request.getRequestDispatcher("dashboard.html");
			r.include(request, response);
			
			out.println("<form name='frm' action='' method='POST'>");
			out.println("<div class='container mt-5 bg-dark p-5'>");
			out.println("<div class='form-group'>");
			out.println("<div><input type='text' name='name' value='' class='form-control mt-2'/>");
			out.println("</div>");
			
			out.println("<div class='form-group'>");
			out.println("<div><input type='submit' name='s' value='Add New Dept' class='form-control mt-2'/>");
			out.println("</div>");
			out.println("</div>");
			out.println("</form>");
			
			String btnValue=request.getParameter("s");
			
			out.println("<h1 class ='text-white'>"+btnValue+"</h1>");
			if(!Optional.ofNullable(btnValue).isEmpty()){
				String deptname=request.getParameter("name");
				DeptModel model= new DeptModel();
				model.setName(deptname);
				DeptService deptservice=new DeptServiceImpl();
				boolean result=deptservice.isAddNewDept(model);
				if(result) {
					out.println("<h1 class='text-white'>new Dept Added</h1>");
				}else {
					out.println("<h1 class='text-white'> Dept not Added</h1>");
				}
			}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
