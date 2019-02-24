//Author: Timothy van der Graaff
package apps.traffic_monitor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Run_Request_Personal_Information extends HttpServlet {

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
  controllers.Request_Personal_Information run_request_personal_information = new controllers.Request_Personal_Information();

  String admin_session = request.getParameter("admin_session");

  out.println("<!DOCTYPE html>");
  out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
  out.println("<head>");
  out.println("<title>Request personal information query</title>");
  out.println("</head>");
  out.println("<body>");
  out.println("<script type=\"text/javascript\" src=\"" + use_config.domain() + "/backstretch/js/jquery.min.js\"></script>");
  out.println("<script type=\"text/javascript\" src=\"" + use_config.domain() + "/backstretch/js/jquery.backstretch.js\"></script>");
  out.println(run_request_personal_information.admin_request_personal_information(String.valueOf(admin_session)));
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
 } // </editor-fold>
}
