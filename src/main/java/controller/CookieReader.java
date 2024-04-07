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
 * Servlet implementation class CookieReader
 */
@WebServlet("/fetchCookie")
public class CookieReader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieReader() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		//calling or invoking getCookies() method HttpRe
		Cookie[] cks=request.getCookies();
		response.setContentType("text/html");
		for(Cookie ck:cks) {
			if(ck.getName().equalsIgnoreCase("un")) {

				out.println("Cookie name: "+" "+ck.getName()+"<br>");
				out.println("Cookie name: "+" "+ck.getValue()+"<br>");
				
			}
		}
		
		
		//I want fetch data which I have 
		
		String user=(String) request.getAttribute("requestKey");
		out.println("request data is "+" "+user);
		String contextUser=(String)getServletContext().getAttribute("contextKey");
		out.println("global data is"+" "+contextUser);
		
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
