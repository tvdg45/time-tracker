import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AddFriend extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
	
	PrintWriter out = response.getWriter();
		
	basic_data_handling.Request_Data declare_request_data = new basic_data_handling.Request_Data();
		
	out.println("<html>\n");
   	out.println("<body>\n");
      	out.println("<form action = \"https://java-test-9.herokuapp.com/addfriend\" method = \"POST\">\n");
        out.println("First Name: <input type = \"text\" name = \"first_name\">\n");
        out.println("<br />\n");
        out.println("Last Name: <input type = \"text\" name = \"last_name\" />\n");
        out.println("<input type = \"submit\" value = \"Submit\" />\n");
      	out.println("</form><br />\n");
	out.println(request.getParameter("first_name") + "\n\n<br />\n\n" + request.getParameter("last_name"));
      	out.println("</body>\n");
	out.println("</html>\n");
		
	out.println(declare_request_data.get_data());
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
