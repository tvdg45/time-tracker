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


public class Run_Sign_Up extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		
		PrintWriter out = response.getWriter();
		
		Control_Sign_Up run_sign_up = new Control_Sign_Up();
		
		String first_name = "";
		String last_name = "";
		String email = "";
		String username = "";
		String password = "";
		String confirm_password = "";
		String date_received = "";
		String time_received = "";
		String sign_up = "";
		
		first_name = request.getParameter("first_name");
		last_name = request.getParameter("last_name");
		email = request.getParameter("email");
		username = request.getParameter("username");
		password = request.getParameter("password");
		confirm_password = request.getParameter("confirm_password");
		date_received = request.getParameter("date_received");
		time_received = request.getParameter("time_received");
		sign_up = request.getParameter("sign_up");
		
		out.println("<!DOCTYPE html>");
		out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
		out.println("<head>");
		out.println("<title>Sign up form</title>");
		out.println("</head>");
		out.println("<body>");
		//out.println("<form method=\"get\" action=\"https://user-account-management-1.herokuapp.com/sign-up\">");
		out.println("<input type=\"text\" name=\"first_name\" /><br />");
		out.println("<input type=\"text\" name=\"last_name\" /><br />");
		out.println("<input type=\"text\" name=\"email\" /><br />");
		out.println("<input type=\"text\" name=\"username\" /><br />");
		out.println("<input type=\"text\" name=\"password\" /><br />");
		out.println("<input type=\"text\" name=\"confirm_password\" /><br />");
		out.println("<input type=\"text\" name=\"date_received\" /><br />");
		out.println("<input type=\"text\" name=\"time_received\" /><br />");
		//out.println("<input type=\"submit\" name=\"sign_up\" value=\"Sign up\" /><br />");
		//out.println("</form>");
		out.println(run_sign_up.control_sign_up(first_name, last_name, email, username, password, confirm_password, date_received, time_received, String.valueOf(sign_up)));
		out.println("</body>");
		out.println("</html>");
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
        processRequest(request, response);
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
