package org.techhub.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.techhub.service.DeptService;
import org.techhub.service.DeptServiceImpl;


@WebServlet("/deldept")
public class DelServ extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int depid=Integer.parseInt(request.getParameter("did"));
		DeptService deptser=new DeptServiceImpl();
		boolean result=deptser.isDeleteDept(depid);
		
		if(result) {
			response.sendRedirect("view");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
