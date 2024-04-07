package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckBalanceServlet
 */
@WebServlet("/checkbal")
public class CheckBalanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckBalanceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//fetching all cookies from request object or request header
		Cookie[] cookies=request.getCookies();
		
		//Iterating each cookies
		for(Cookie ck:cookies) {
			
			String name=ck.getName();
			String value=ck.getValue();
			if(name.equals("UserCookie")) 
			{
				out.println("Hello"+" "+value);
				out.println("using your user name we will fecthing your account balance");
				break;
			}
		
		}
		out.println("<h1><font color='blue'>If you  want to continiue then visit customer profile</font></h1>");
		out.println("<a href='UserProfile.html'>Click here ...to go Menu</a><br>");
		out.println("<a href='logout'>click here to logout...</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
