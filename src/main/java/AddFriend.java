import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import java.util.logging.Level; 
import java.util.logging.Logger; 
import java.util.logging.*; 

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AddFriend extends HttpServlet {
	
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	response.addHeader("Access-Control-Allow-Origin", "https://www.timothysdigitalsolutions.com");
        response.setContentType("text/html;charset=UTF-8");
	
	PrintWriter out = response.getWriter();
		
	basic_data_handling.Request_Data declare_request_data = new basic_data_handling.Request_Data();
		
	out.println("<html>");
   	out.println("<body>");
      	out.println("<form action = \"https://java-test-9.herokuapp.com/addfriend\" method = \"POST\">");
        out.println("First Name: <input type = \"text\" name = \"first_name\">");
        out.println("<br />");
        out.println("Last Name: <input type = \"text\" name = \"last_name\" />");
        out.println("<input type = \"submit\" value = \"Submit\" />");
      	out.println("</form><br />");
	out.println(request.getParameter("first_name") + "\n\n<br />\n\n" + request.getParameter("last_name"));
	
	out.println(declare_request_data.get_data());
	
	out.println("<br />");
		
try {
Class.forName("com.mysql.jdbc.Driver");
Connection conn=DriverManager.getConnection("jdbc:mysql://82.163.176.10:3306/timothys_digital_solutions_third_party_apps", "timothys_tim", "ranger12");  
//here sonoo is database name, root is username and password

    // create the preparedstatement and add the criteria
    PreparedStatement ps = conn.prepareStatement("SELECT row_id FROM third_party_account_info_per_traffic_monitor_app WHERE row_id = ? ORDER BY row_id DESC");
	
	ps.setInt(1, 1);
    // process the results
    ResultSet rs = ps.executeQuery();
    /*while ( rs.next() )
    {
      out.println(rs.getInt(1) + "<br />");
    }*/
    rs.last();
	
out.println(rs.getRow() + "<br />");
} catch (Exception e) {
	
            LOGGER.log(Level.INFO, "" + e + "");
        }
		
	
		
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
