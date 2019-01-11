//Author: Timothy van der Graaff
package apps.traffic_monitor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Run_Fetch_Lost_Personal_Information extends HttpServlet {
	
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //processRequest(request, response);
	    
		response.addHeader("Access-Control-Allow-Origin", "https://www.timothysdigitalsolutions.com");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
	    
		PrintWriter out = response.getWriter();
		
		configuration.Config use_config = new configuration.Config();
		controllers.Control_Fetch_Lost_Personal_Information run_fetch_lost_personal_information = new controllers.Control_Fetch_Lost_Personal_Information();
		
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String fetch_username = request.getParameter("fetch_username");
		String fetch_password = request.getParameter("fetch_password");
		
		out.println("<!DOCTYPE html>");
		out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
		out.println("<head>");
		out.println("<title>Fetch lost personal information form</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<script type=\"text/javascript\" src=\"" + use_config.domain() + "/backstretch/js/jquery.min.js\"></script>");
		out.println("<script type=\"text/javascript\" src=\"" + use_config.domain() + "/backstretch/js/jquery.backstretch.js\"></script>");
		out.println(run_fetch_lost_personal_information.control_fetch_username(String.valueOf(email), String.valueOf(fetch_username)));
		out.println(run_fetch_lost_personal_information.control_fetch_password(String.valueOf(username), String.valueOf(fetch_password)));
		out.println("</body>");
		out.println("</html>");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        
		return "Short description";
    }// </editor-fold>
}
