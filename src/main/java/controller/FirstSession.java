package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;


/**
 * Servlet implementation class FirstSession
 */
@WebServlet("/session1")
public class FirstSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		//getting the object of session
		
		HttpSession session=request.getSession();
			out.println("<h2><font color='blue'>"+" "+session.getId()+"</font></h2><br>");
			out.println("<h3><font color ='red'>"+new Date(session.getCreationTime())+"</font></h3>");
			session.setAttribute("key1","Wipro Limited");
			Map<String,Long> map=new HashMap();
			map.put("Rai",4443433L);
			map.put("ABC",3224343L);
			
			
			session.setAttribute("key2", map);
			RequestDispatcher rd=request.getRequestDispatcher("SessionLink.html");
			rd.include(request, response);
			
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}