//Author: Timothy van der Graaff
package apps.traffic_monitor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Run_Change_Personal_Information extends HttpServlet {

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
  controllers.Control_Change_Personal_Information run_change_personal_information = new controllers.Control_Change_Personal_Information();

  String first_name = request.getParameter("first_name");
  String last_name = request.getParameter("last_name");
  String email = request.getParameter("email");
  String username = request.getParameter("username");
  String current_password = request.getParameter("current_password");
  String new_password = request.getParameter("new_password");
  String confirm_new_password = request.getParameter("confirm_new_password");
  String save_basic_information = request.getParameter("save_basic_information");
  String save_email = request.getParameter("save_email");
  String save_username = request.getParameter("save_username");
  String save_password = request.getParameter("save_password");
  String cancel_changes = request.getParameter("cancel_changes");
  String admin_session = request.getParameter("admin_session");

  out.println("<!DOCTYPE html>");
  out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
  out.println("<head>");
  out.println("<title>Change personal information form</title>");
  out.println("</head>");
  out.println("<body>");
  out.println("<script type=\"text/javascript\" src=\"" + use_config.domain() + "/backstretch/js/jquery.min.js\"></script>");
  out.println("<script type=\"text/javascript\" src=\"" + use_config.domain() + "/backstretch/js/jquery.backstretch.js\"></script>");
  out.println(run_change_personal_information.control_basic_information_changer(String.valueOf(first_name), String.valueOf(last_name), String.valueOf(save_basic_information), String.valueOf(cancel_changes), String.valueOf(admin_session)));
  out.println(run_change_personal_information.control_email_changer(String.valueOf(email), String.valueOf(save_email), String.valueOf(cancel_changes), String.valueOf(admin_session)));
  out.println(run_change_personal_information.control_username_changer(String.valueOf(username), String.valueOf(save_username), String.valueOf(cancel_changes), String.valueOf(admin_session)));
  out.println(run_change_personal_information.control_password_changer(String.valueOf(current_password), String.valueOf(new_password), String.valueOf(confirm_new_password), String.valueOf(save_password), String.valueOf(cancel_changes), String.valueOf(admin_session)));
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
