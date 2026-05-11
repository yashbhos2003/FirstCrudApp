package org.techhub.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.techhub.model.DeptModel;
import org.techhub.service.DeptService;
import org.techhub.service.DeptServiceImpl;

@WebServlet("/update")
public class UpdateSerController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		RequestDispatcher r=request.getRequestDispatcher("dashboard.html");
		r.include(request, response);
		
		int deptid=Integer.parseInt(request.getParameter("did"));
		String deptname=request.getParameter("dname");
		out.println("<form name='frm' action='' method='POST'>");
		out.println("<div class='container m-5 bg-dark p-5'>");
		
		out.println("<div class='form-group p-2'>");
		out.println("<input type='hidden' name='id' value='"+deptid+"' class='form-control'/>");
		out.println("</div>");
		
		out.println("<div class='form-group p-2'>");
		out.println("<input type='text' name='name' value='"+deptname+"' class='form-control'/>");
		out.println("</div>");
		
		out.println("<div class='form-group p-2'>");
		out.println("<input type='submit' name='s' value='update Dept' class='form-control'/>");
		out.println("</div>");
		
		out.println("</div>");
		out.println("</form>");
		
		String button=request.getParameter("s");
		if(button!=null) {
			int did=Integer.parseInt(request.getParameter("id"));
			String dname=request.getParameter("name");
			
			DeptModel model=new DeptModel();
			model.setId(did);
			model.setName(dname);
			
			DeptService service=new DeptServiceImpl();
			boolean result=service.isUpdateDept(model);
			
			if(result) {
				response.sendRedirect("view");
			}else {
				out.println("<h1>some problem occure</h1>");
			}
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
