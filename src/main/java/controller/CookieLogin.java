package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class CookieLogin
 */
@WebServlet("/LoginCookie")
public class CookieLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// to generate the response using the html and text
		response.setContentType("text/html");
		//getting the object of Printwriter
		PrintWriter out=response.getWriter();
		//reading inputs from HTML input element
		String userName=request.getParameter("un");
		String password=request.getParameter("pass");
		
		List<String> listOfUserName=new ArrayList();
		listOfUserName.add("ravi");
		listOfUserName.add("abc");
		listOfUserName.add("xyz");
		
		List<String> listOfPassword=new ArrayList();
		listOfPassword.add("ravi@123");
		listOfPassword.add("abc@123");
		listOfPassword.add("xyz@123");
		
		//creating object of Iterator
		Iterator<String> itr1=listOfUserName.iterator();
		Iterator<String> itr2=listOfPassword.iterator();
		
		int flag=0;
		while(itr1.hasNext() && itr2.hasNext())
		{
			String name=itr1.next();
			String pass=itr2.next();
			
			if(name.equalsIgnoreCase(userName) && pass.equals(password))
			{
				flag=1;
				break;
			}
			
		}
		
		if(flag==1)
		{
			out.println("<h1><font color='green'>Login Success</font></h1>");
			Cookie userCookie = new Cookie("UserCookie",userName);
			Cookie passCookie=new Cookie("PassCookie",password);
			userCookie.setMaxAge(24*60*60);
			passCookie.setMaxAge(24*60*60);
			
			response.addCookie(userCookie);
			response.addCookie(passCookie);
			RequestDispatcher rd=request.getRequestDispatcher("UserProfile.html");
			rd.include(request,response);
			
		
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
