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


public class Run_Change_Third_Party_Account extends HttpServlet {
	
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
		controllers.Control_Change_Third_Party_Account run_change_third_party_account = new controllers.Control_Change_Third_Party_Account();
		
		String id = request.getParameter("id");
		String url = request.getParameter("url");
		String token = request.getParameter("token");
		String memory_plan = request.getParameter("memory_plan");
		String memory = request.getParameter("memory");
		String date_received = request.getParameter("date_received");
		String time_received = request.getParameter("time_received");
		String add_website = request.getParameter("add_website");
		String change_url = request.getParameter("change_url");
		String change_token = request.getParameter("change_token");
		String delete_website = request.getParameter("delete_website");
		String downgrade_plan = request.getParameter("downgrade_plan");
		String upgrade_plan = request.getParameter("upgrade_plan");
		String admin_session = request.getParameter("admin_session");
		
		out.println("<!DOCTYPE html>");
		out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
		out.println("<head>");
		out.println("<title>Change third party account form</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<script type=\"text/javascript\" src=\"" + use_config.domain() + "/backstretch/js/jquery.min.js\"></script>");
		out.println("<script type=\"text/javascript\" src=\"" + use_config.domain() + "/backstretch/js/jquery.backstretch.js\"></script>");
		out.println(run_change_third_party_account.control_add_website(String.valueOf(url), String.valueOf(token), String.valueOf(date_received), String.valueOf(time_received), String.valueOf(add_website), String.valueOf(admin_session)));
		out.println(run_change_third_party_account.control_change_url(String.valueOf(id), String.valueOf(url), String.valueOf(change_url), String.valueOf(admin_session)));
		out.println(run_change_third_party_account.control_change_token(String.valueOf(id), String.valueOf(token), String.valueOf(change_token), String.valueOf(admin_session)));
		out.println(run_change_third_party_account.control_delete_website(String.valueOf(id), String.valueOf(delete_website), String.valueOf(admin_session)));
		out.println(run_change_third_party_account.control_downgrade_plan(String.valueOf(id), String.valueOf(memory_plan), String.valueOf(memory), String.valueOf(downgrade_plan), String.valueOf(admin_session)));
		out.println(run_change_third_party_account.control_upgrade_plan(String.valueOf(id), String.valueOf(memory_plan), String.valueOf(memory), String.valueOf(upgrade_plan), String.valueOf(admin_session)));
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
