package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieCreater
 */
@WebServlet("/cookie1")
public class CookieCreater extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieCreater() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		String userName=request.getParameter("t1");
		
		//crating cookie by setting name of the cookie as "un"
		//the value of the cookie is userName (which reading from Html)
		
		Cookie ck=new Cookie("un",userName);
		//setting the age of the cookie
		
		//teh cookie age is 24 hours
		ck.setMaxAge(24*60*60);
		//binding cookie with response Header of the http protocol
		//void addCookie (Cookie object)
		response.addCookie(ck);
		request.setAttribute("requestKey", userName);
		ServletContext context=getServletContext();
		context.setAttribute("contextKey", userName);
		
		PrintWriter writer=response.getWriter();
		writer.println("cookie created successfully");
		
		RequestDispatcher rd= request.getRequestDispatcher("Input.html");
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
