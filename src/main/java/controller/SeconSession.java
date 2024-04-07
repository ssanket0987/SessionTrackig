package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Servlet implementation class SeconSession
 */
@WebServlet("/session2")
public class SeconSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SeconSession() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		HttpSession oldSession = request.getSession(false);
		String companyName = (String) oldSession.getAttribute("key1");
		out.println("<h1>welcome to " + " " + companyName + "</h1>");
		Map<String, Long> sessionMap = (Map<String, Long>) oldSession.getAttribute("key2");
		out.println("<table border='2'>");
		out.println("<thead>");
		out.println("<th>Name</th>");
		out.println("<th>Phone</th>");
		out.println("</thead>");

		for (Entry<String, Long> e : sessionMap.entrySet())

		{
			out.println("<tr>");
			out.println("<td>" + e.getKey() + "</td>");
			out.println("<td>" + e.getValue() + "</td>");
			out.println("</tr>");

		}

		out.println("</table>");
		out.println("<h5><font color='blue'>" + new Date(oldSession.getLastAccessedTime()) + "</font></h5>");
		out.println("<a href='sessionLogout'>Logout fromherer...</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
