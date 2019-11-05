//Author: Timothy van der Graaff
package apps;

import configuration.Config;
import controllers.Control_Search_Tasks;
import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Time_Tracker_Interface extends HttpServlet {
    
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
        
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
        
        PrintWriter out = response.getWriter();
        
        Connection use_open_connection;
  
        use_open_connection = configuration.Config.openConnection();
        
        String admin_session;
        String output;
        
        //Attempt to find a logged in administrator.
        if (request.getParameter("admin_session") == null) {
      
            admin_session = "";
        } else {
      
            admin_session = request.getParameter("admin_session");
        }
        
        Control_Search_Tasks.task_owner = admin_session;
        Control_Search_Tasks.use_connection = use_open_connection;
        
        output = Control_Search_Tasks.request_tasks();
        
        out.println("<script type=\"text/javascript\" src=\"https://www.timothysdigitalsolutions.com/backstretch/js/jquery-3.2.1.js\"></script>");
        out.println("<script type=\"text/javascript\" src=\"https://www.timothysdigitalsolutions.com/backstretch/js/jquery.min.js\"></script>");
        out.println("<script type=\"text/javascript\" src=\"https://www.timothysdigitalsolutions.com/backstretch/js/jquery.backstretch.js\"></script>");
        out.println("<div style=\"text-align: left; width: 99%; background-color: #FBDFCC; margin-left: 0.5%; margin-right: 0.5%; margin-top: auto; margin-bottom: auto; font-family: Arial, Helvetica, sans-serif;\">");
        out.println("<div style=\"text-align: left; width: 100%\">");
        out.println("<label>If page does not load, click <a href=\"https://tdscloud-dev-ed.lightning.force.com/lightning/page/home\">here</a> to refresh.</label><br /><br />");
        out.println("</div>");
        out.println("");
        
        if (!(admin_session.equals(""))) {
            
            out.println("<script type=\"text/javascript\">");
            out.println("$(document).ready(function() {");
            out.println("");
            out.println("$(\"#task_list\").fadeIn();");
            out.println("});");
            out.println("");
            out.println("function new_task() {");
            out.println("");
            out.println("$(\"#task_list\").fadeOut();");
            out.println("$(\"#create_task_prompt\").fadeIn();");
            out.println("}");
            out.println("");
            out.println("function view_tasks() {");
            out.println("");
            out.println("$(\"#create_task_prompt\").fadeOut();");
            out.println("$(\"#task_list\").fadeIn();");
            out.println("}");
            out.println("");
            out.println("function get_raw_minute() {");
            out.println("");
            out.println("var today_date = new Date();");
            out.println("var raw_minute = parseInt((today_date.getTime() / 1000) / 60);");
            out.println("");
            out.println("return raw_minute;");
            out.println("}");
            out.println("");
            out.println("function add_task() {");
            out.println("");
            out.println("var xhttp = new XMLHttpRequest();");
            out.println("");
            out.println("xhttp.onreadystatechange = function() {");
            out.println("");
            out.println("if (this.readyState == 4 && this.status == 200) {");
            out.println("");
            out.println("$(\"#create_task\").html(this.responseText);");
            out.println("}");
            out.println("};");
            out.println("");
            out.println("xhttp.open(\"POST\", \"" + Config.third_party_domain() + "/create-task\");");
            out.println("xhttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");");
            out.println("");
            out.println("xhttp.send(\"task_name=\" + $(\"#task_name\").val() + \"&task_description=\" + $(\"#task_description\").val() + \"&time_started=\" + get_raw_minute() + \"&admin_session=" + admin_session + "&create_task=Create task\");");
            out.println("}");
            out.println("</script>");
            out.println("<div id=\"create_task_prompt\" style=\"display: none;\">");
            out.println("<div style=\"text-align: left; width: 100%\">");
            out.println("<input type=\"button\" name=\"view_tasks\" id=\"view_tasks\" onclick=\"view_tasks()\" value=\"View tasks\" />");
            out.println("</div>");
            out.println("<div style=\"text-align: left; width: 100%\"><br />");
            out.println("<label>Task name:</label>");
            out.println("</div>");
            out.println("<div style=\"text-align: left; width: 100%\">");
            out.println("<input type=\"text\" id=\"task_name\" style=\"width: 98%\" />");
            out.println("</div>");
            out.println("<div style=\"text-align: left; width: 100%\"><br />");
            out.println("<label>Task description:</label>");
            out.println("</div>");
            out.println("<div style=\"text-align: left; width: 100%\">");
            out.println("<textarea id=\"task_description\" style=\"width: 98%; height: 100px\"></textarea>");
            out.println("</div>");
            out.println("<div style=\"text-align: left; width: 100%\"><br />");
            out.println("<input type=\"button\" name=\"add_task\" id=\"add_task\" onclick=\"add_task()\" value=\"Add task\" />");
            out.println("</div>");
            out.println("<div style=\"text-align: left; width: 100%\"><br />");
            out.println("<div id=\"create_task\"></div>");
            out.println("</div>");
            out.println("</div>");
            out.println("<div id=\"task_list\" style=\"display: none;\">");
            out.println("<div style=\"text-align: left; width: 100%\">");
            out.println("<input type=\"button\" name=\"new_task\" id=\"new_task\" onclick=\"new_task()\" value=\"New task\" />");
            out.println("</div>");
            
            if (output.equals("no tasks")) {
                
                out.println("<div style='text-align: left; padding-top: 20px; padding-bottom: 20px; word-wrap: break-word'>");
                out.println("<label>You have no unsaved tasks.</label>");
                out.println("</div>");
            } else {
            
                out.println("<div style='text-align: left; padding-top: 20px; padding-bottom: 20px; word-wrap: break-word'>");
                out.println("<div id='task_content'></div>");
                out.println("</div>");
                out.println("<script type=\"text/javascript\">");
                out.println("");
                out.println("var task_content = \"\";");
                out.println("");
                out.println("var each_task;");
                out.println("");
                out.println("var all_tasks;");
                out.println("");
                out.println("var number_of_selected_tasks = 0;");
                out.println("");
                out.println("var all_selected_tasks = \"\";");
                out.println("");
                out.println("var my_tasks = " + output + ";");
                out.println("");
                out.println("each_task = my_tasks;");
                out.println("");
                out.println("if (each_task.length > 0) {");
                out.println("");
                out.println("task_content += \"<div style='text-align: left; width: 100%'>\";");
                out.println("task_content += \"<br /><input type='button' name='delete_selected' id='delete_selected' onclick='erase_selected()' value='Delete selected' />\";");
                out.println("task_content += \"</div>\";");
                out.println("}");
                out.println("");
                out.println("if (each_task.length > 0) {");
                out.println("");
                out.println("task_content += \"<div style='text-align: left; width: 100%'>\";");
                out.println("task_content += \"<div id='finish_task'></div>\";");
                out.println("task_content += \"</div>\";");
                out.println("task_content += \"<div style='text-align: left; width: 100%'>\";");
                out.println("task_content += \"<div id='delete_tasks'></div>\";");
                out.println("task_content += \"</div>\";");
                out.println("}");
                out.println("");
                out.println("for (var i = 0; i < each_task.length; i++) {");
                out.println("");
                out.println("if (each_task[i][\"user_id\"] == \"" + admin_session + "\") {");
                out.println("");
                out.println("task_content += \"<div style='text-align: left; padding-top: 10px; padding-bottom: 10px; word-wrap: break-word'>\";");
                out.println("task_content += \"<div style='text-align: left; width: 100%'>\";");
                out.println("task_content += \"<input type='checkbox' name='select_task' class='select_task' value='\" + each_task[i][\"row_id\"] + \"' />\";");
                out.println("task_content += \"<label><b>Name:</b> \" + each_task[i][\"task_name\"] + \"</label>\";");
                out.println("task_content += \"</div>\";");
                out.println("task_content += \"<div style='text-align: left; width: 100%'>\";");
                out.println("task_content += \"<label><b>Description:</b> \" + each_task[i][\"description\"] + \"</label>\";");
                out.println("task_content += \"</div>\";");
                out.println("task_content += \"<div style='text-align: left; width: 100%'>\";");
                out.println("task_content += \"<label><b>Task started: </b> \" + each_task[i][\"date_received\"] + \" at \" + each_task[i][\"time_received\"] + \"</label>\";");
                out.println("task_content += \"</div>\";");
                out.println("");
                out.println("if (each_task[i][\"time_stopped\"] == \"\" || each_task[i][\"time_stopped\"].replace(/\\s/g, \"\").length == 0) {");
                out.println("");
                out.println("task_content += \"<div style='text-align: left; width: 100%'>\";");
                out.println("task_content += \"<input type='button' class='finish_task' value='Finish task' onclick='finish_task(\" + each_task[i]['row_id'] + \")' />\";");
                out.println("task_content += \"</div>\";");
                out.println("} else {");
                out.println("");
                out.println("if (each_task[i][\"total_time\"] == 1) {");
                out.println("");
                out.println("task_content += \"<div style='text-align: left; width: 100%'>\";");
                out.println("task_content += \"<label><b>Total time: </b> \" + each_task[i][\"total_time\"] + \" minute</label>\";");
                out.println("task_content += \"</div>\";");
                out.println("} else {");
                out.println("");
                out.println("task_content += \"<div style='text-align: left; width: 100%'>\";");
                out.println("task_content += \"<label><b>Total time: </b> \" + each_task[i][\"total_time\"] + \" minutes</label>\";");
                out.println("task_content += \"</div>\";");
                out.println("}");
                out.println("}");
                out.println("");
                out.println("task_content += \"</div>\";");
                out.println("}");
                out.println("}");
                out.println("");
                out.println("document.getElementById(\"task_content\").innerHTML = task_content;");
                out.println("");
                out.println("function finish_task(task_id) {");
                out.println("");
                out.println("var xhttp = new XMLHttpRequest();");
                out.println("");
                out.println("xhttp.onreadystatechange = function() {");
                out.println("");
                out.println("if (this.readyState == 4 && this.status == 200) {");
                out.println("");
                out.println("$(\"#finish_task\").html(this.responseText);");
                out.println("}");
                out.println("};");
                out.println("");
                out.println("xhttp.open(\"POST\", \"" + Config.third_party_domain() + "/finish-selected-task\");");
                out.println("xhttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");");
                out.println("");
                out.println("xhttp.send(\"task_id=\" + task_id + \"&time_stopped=\" + get_raw_minute() + \"&admin_session=" + admin_session + "&finish_task=Finish task\");");
                out.println("}");
                out.println("");
                out.println("function erase_selected() {");
                out.println("");
                out.println("all_tasks = document.getElementsByName('select_task').length;");
                out.println("");
                out.println("for (var i = 0; i < all_tasks; i++) {");
                out.println("");
                out.println("if (document.getElementsByName('select_task')[i].checked) {");
                out.println("");
                out.println("all_selected_tasks += document.getElementsByName('select_task')[i].value + \",\";");
                out.println("number_of_selected_tasks++;");
                out.println("}");
                out.println("}");
                out.println("");
                out.println("all_selected_tasks += \"{}\";");
                out.println("");
                out.println("if (number_of_selected_tasks > 0) {");
                out.println("");
                out.println("all_selected_tasks = all_selected_tasks.replace(/,{}/g, \"\");");
                out.println("} else {");
                out.println("");
                out.println("all_selected_tasks = all_selected_tasks.replace(/{}/g, \"\");");
                out.println("}");
                out.println("");
                out.println("var xhttp = new XMLHttpRequest();");
                out.println("");
                out.println("xhttp.onreadystatechange = function() {");
                out.println("");
                out.println("if (this.readyState == 4 && this.status == 200) {");
                out.println("");
                out.println("$(\"#delete_tasks\").html(this.responseText);");
                out.println("}");
                out.println("};");
                out.println("");
                out.println("xhttp.open(\"POST\", \"" + Config.third_party_domain() + "/delete-tasks\");");
                out.println("xhttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");");
                out.println("xhttp.send(\"selected_tasks=\" + all_selected_tasks + \"&admin_session=" + admin_session + "&delete_tasks=Delete tasks\");");
                out.println("");
                out.println("number_of_selected_tasks = 0;");
                out.println("all_selected_tasks = \"\";");
                out.println("}");
                out.println("</script>");
            }
            
            out.println("</div>");
        }
        
        out.println("</div>");
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