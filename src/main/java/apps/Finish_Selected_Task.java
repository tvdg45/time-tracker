//Author: Timothy van der Graaff
package apps;

import configuration.Config;
import controllers.Control_Finish_Selected_Task;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Finish_Selected_Task extends HttpServlet {
    
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
        
        //processRequest(request, response);

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
  
        response.addHeader("Access-Control-Allow-Origin", "https://tdscloud-dev-ed--c.visualforce.com");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
  
        PrintWriter out = response.getWriter();
  
        Connection use_open_connection;
  
        use_open_connection = Config.openConnection();
        
        String admin_session;
        
        //Attempt to find a logged in administrator.
        if (request.getParameter("admin_session") == null) {
      
            admin_session = "";
        } else {
      
            admin_session = request.getParameter("admin_session");
        }
  
        if (String.valueOf(request.getParameter("finish_task")).equals("Finish task")) {
            
            if (!(admin_session.equals(""))) {
                
                Control_Finish_Selected_Task.use_connection = use_open_connection;
                Control_Finish_Selected_Task.admin_session = admin_session;
                Control_Finish_Selected_Task.task_id = String.valueOf(request.getParameter("task_id"));
                Control_Finish_Selected_Task.time_stopped = String.valueOf(request.getParameter("time_stopped"));
                Control_Finish_Selected_Task.finish_task = String.valueOf(request.getParameter("finish_task"));
        
                out.println(Control_Finish_Selected_Task.control_finish_selected_task());
            } else {
                
                out.println("<script type=\"text/javascript\">");
                out.println("window.location = document.location.href.replace(\"#\", \"\");");
                out.println("</script>");
            }
        }
    }

    /**
    * Returns a short description of the servlet.
    *
    * @return a String containing servlet description
    */
    
    @Override
    public String getServletInfo() {

        return "Short description";
    } // </editor-fold>    
}
