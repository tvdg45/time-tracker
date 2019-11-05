//Author: Timothy van der Graaff
package apps;

import configuration.Config;
import controllers.Control_Create_Task;

import java.time.LocalDate;
import java.time.LocalTime;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Create_Task extends HttpServlet {
    
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
        
        DateTimeFormatter time_format = DateTimeFormatter.ofPattern("hh:mm a 'EST'");
          
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now(ZoneId.of("America/New_York"));
  
        //Attempt to find a logged in administrator.
        if (request.getParameter("admin_session") == null) {
      
            admin_session = "";
        } else {
      
            admin_session = request.getParameter("admin_session");
        }
  
        if (String.valueOf(request.getParameter("create_task")).equals("Create task")) {
            
            if (!(admin_session.equals(""))) {
                
                Control_Create_Task.use_connection = use_open_connection;
                Control_Create_Task.admin_session = admin_session;
                Control_Create_Task.task_name = String.valueOf(request.getParameter("task_name"));
                Control_Create_Task.task_description = String.valueOf(request.getParameter("task_description"));
                Control_Create_Task.time_started = String.valueOf(request.getParameter("time_started"));
                Control_Create_Task.date_received = String.valueOf(localDate);
                Control_Create_Task.time_received = String.valueOf(time_format.format(localTime));
                Control_Create_Task.create_task = String.valueOf(request.getParameter("create_task"));
        
                out.println(Control_Create_Task.control_create_task());
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
