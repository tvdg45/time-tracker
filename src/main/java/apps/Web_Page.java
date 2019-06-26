//Author: Timothy van der Graaff
package apps;

import controllers.Request_CSS_Responsive_Design_Screens;
import controllers.Request_Footer_Content;
import controllers.Request_Website_Name;
import controllers.Request_Web_Page;
import controllers.Request_Website_Icon;
import controllers.Request_Website_Logo;
import controllers.Request_Website_Links;
import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Web_Page extends HttpServlet {

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

  response.addHeader("Access-Control-Allow-Origin", "https://www.timothysdigitalsolutions.com");
  response.setHeader("Access-Control-Allow-Credentials", "true");
  response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
  response.setHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");

  PrintWriter out = response.getWriter();
  
  Connection use_open_connection;
  
  use_open_connection = configuration.Config.openConnection();
  
  String url = String.valueOf(request.getParameter("url"));
  String page = String.valueOf(request.getParameter("page"));
  String page_preview = String.valueOf(request.getParameter("page_preview"));
  String show_website = String.valueOf(request.getParameter("show_website"));
  
  Request_CSS_Responsive_Design_Screens.show_website = String.valueOf(show_website);
  
  Request_Web_Page.show_website = String.valueOf(show_website);
  
  Request_Web_Page.url = String.valueOf(url);
  Request_Web_Page.page = String.valueOf(page);
  Request_Web_Page.page_preview = String.valueOf(page_preview);
  Request_Web_Page.show_website = String.valueOf(show_website);
  Request_Web_Page.use_connection = use_open_connection;
  
  Request_Website_Links.url = String.valueOf(url);
  Request_Website_Links.page = String.valueOf(page);
  Request_Website_Links.show_website = String.valueOf(show_website);
  
  Request_Website_Links.use_connection = use_open_connection;
  Request_CSS_Responsive_Design_Screens.use_connection = use_open_connection;
  Request_Website_Icon.use_connection = use_open_connection;
  Request_Website_Logo.use_connection = use_open_connection;
  Request_Website_Name.use_connection = use_open_connection;
  
  Request_Footer_Content.show_website = String.valueOf(show_website);
  
  //Search for web page
  Request_Web_Page.search_web_page();
  
  //Search for website links
  Request_Website_Links.search_website_link();
  
  //Search for footers
  Request_Footer_Content.use_connection = use_open_connection;
  Request_Footer_Content.search_footer_content_section();
  
  //Find website name
  Request_Web_Page.website_name = Request_Website_Name.request_website_name();
  
  out.println(Request_Website_Icon.request_website_icon());
  out.println(Request_CSS_Responsive_Design_Screens.request_css_responsive_design_screens());
  out.println(Request_Web_Page.request_page_description());
  out.println(Request_Web_Page.request_page_keywords());
  out.println(Request_Web_Page.request_title());
  out.println("<script>document.body.style.backgroundColor = \"#FBDFCC\";</script>\n");
  out.println("<style type=\"text/css\">");
  out.println("p, label, ul, ol, .pre_header { font-family: normal normal normal 'Open Sans', sans-serif; font-size: 12pt; color: #000000; cursor: text; }");
  out.println(".footer p, .footer label, .footer ul, .footer ol { font-family: normal normal normal 'Open Sans', sans-serif; font-size: 12pt; color: #C88D81; cursor: text; }");
  out.println("a { text-decoration: none; color: #C88D81; }");
  out.println("a:hover { text-decoration: none; color: #C88D81; }");
  out.println("a:visited { text-decoration: none; color: #C88D81; }");
  out.println(".all_notifications a, #responsive_page_content a { text-decoration: none; color: #FBDFCC; }");
  out.println(".all_notifications a:hover, #responsive_page_content a:hover { text-decoration: none; color: #FBDFCC; }");
  out.println(".all_notifications a:visited, #responsive_page_content a:visited { text-decoration: none; color: #FBDFCC; }");
  out.println(".show_vertical_menu { display: none; }");
  out.println("#show_vertical_menu { display: none; text-align: right; color: #C88D81; width: 100%; }");
  out.println("#hide_vertical_menu { display: none; text-align: right; color: #C88D81; width: 100%; }");
  out.println("#click_show_vertical_menu:hover { cursor: pointer; text-align: right; color: #C88D81; width: 100%; }");
  out.println("#click_hide_vertical_menu:hover { cursor: pointer; text-align: right; color: #C88D81; width: 100%; }");
  out.println(".menu_label a { font-family: normal normal normal 'Open Sans', sans-serif; font-size: 12pt; }");
  out.println(".menu_label a:hover { font-family: normal normal normal 'Open Sans', sans-serif; font-size: 12pt; color: #FBDFCC; }");
  out.println(".focused_menu_label a { font-family: normal normal normal 'Open Sans', sans-serif; font-size: 12pt; color: #FBDFCC; }");
  out.println(".focused_menu_label a:hover { font-family: normal normal normal 'Open Sans', sans-serif; font-size: 12pt; color: #FBDFCC; }");
  out.println(".pre_header a, .content a { text-decoration: none; font-family: normal normal normal 'Open Sans', sans-serif; color: #5A403B; }");
  out.println(".pre_header a:hover, .content a:hover { text-decoration: underline; }");
  out.println(".content a:visited { text-decoration: none; font-family: normal normal normal 'Open Sans', sans-serif; color: #5A403B; }");
  out.println(".foot_label { color: #C88D81; }");
  out.println(".footer a, .foot_label a { color: #FBDFCC; }");
  out.println(".footer a:hover, .foot_label a:hover { text-decoration: underline; }");
  out.println("");
  out.println(".signature_section {");
  out.println("");
  out.println("background-color: #5A403B;");
  out.println("background-image: -webkit-repeating-linear-gradient(135deg, rgba(0,0,0,.3), rgba(0,0,0,.3) 1px, transparent 2px, transparent 2px, rgba(0,0,0,.3) 3px);");
  out.println("background-image: -moz-repeating-linear-gradient(135deg, rgba(0,0,0,.3), rgba(0,0,0,.3) 1px, transparent 2px, transparent 2px, rgba(0,0,0,.3) 3px);");
  out.println("background-image: -o-repeating-linear-gradient(135deg, rgba(0,0,0,.3), rgba(0,0,0,.3) 1px, transparent 2px, transparent 2px, rgba(0,0,0,.3) 3px);");
  out.println("background-image: repeating-linear-gradient(135deg, rgba(0,0,0,.3), rgba(0,0,0,.3) 1px, transparent 2px, transparent 2px, rgba(0,0,0,.3) 3px);");
  out.println("-webkit-background-size: 4px 4px;");
  out.println("-moz-background-size: 4px 4px;");
  out.println("background-size: 4px 4px;");
  out.println("}");
  out.println("");
  out.println("input { font-family: arial, sans-serif; font-size: 12pt; background-color: #5A403B; color: #FBDFCC; border: 2px solid; padding: 2px; border-color: #5A403B; }");
  out.println("input[type=text], input[type=password], textarea, select { font-family: arial, sans-serif; font-size: 12pt; background-color: white; color: #5A403B; border: 2px solid; padding: 2px; border-color: #5A403B; }");
  out.println("input[type=text]:focus, input[type=password]:focus, select:focus, textarea:focus { background-color: white; border-color: #5A403B; color: #5A403B; border: 2px solid; padding: 2px; cursor: pointer; }");
  out.println("input[type=submit]:hover, input[type=button]:hover, input[type=submit]:focus, input[type=button]:focus { background-color: transparent; border-color: #5A403B; color: #5A403B; border: 2px solid; padding: 2px; cursor: pointer; }");
  out.println(".header { vertical-align: top; text-align: left; }");
  out.println("");
  out.println(".header, body {");
  out.println("");
  out.println("background-image: -webkit-repeating-radial-gradient(center center, rgba(0,0,0,.2), rgba(0,0,0,.2) 1px, transparent 1px, transparent 100%);");
  out.println("background-image: -moz-repeating-radial-gradient(center center, rgba(0,0,0,.2), rgba(0,0,0,.2) 1px, transparent 1px, transparent 100%);");
  out.println("background-image: -ms-repeating-radial-gradient(center center, rgba(0,0,0,.2), rgba(0,0,0,.2) 1px, transparent 1px, transparent 100%);");
  out.println("background-image: repeating-radial-gradient(center center, rgba(0,0,0,.2), rgba(0,0,0,.2) 1px, transparent 1px, transparent 100%);");
  out.println("-webkit-background-size: 3px 3px;");
  out.println("-moz-background-size: 3px 3px;");
  out.println("background-size: 3px 3px;");
  out.println("}");
  out.println("");
  out.println(".footer {");
  out.println("");
  out.println("background-color: #5a3428;");
  out.println("background-image: -webkit-repeating-linear-gradient(135deg, rgba(0,0,0,.3), rgba(0,0,0,.3) 1px, transparent 2px, transparent 2px, rgba(0,0,0,.3) 3px);");
  out.println("background-image: -moz-repeating-linear-gradient(135deg, rgba(0,0,0,.3), rgba(0,0,0,.3) 1px, transparent 2px, transparent 2px, rgba(0,0,0,.3) 3px);");
  out.println("background-image: -o-repeating-linear-gradient(135deg, rgba(0,0,0,.3), rgba(0,0,0,.3) 1px, transparent 2px, transparent 2px, rgba(0,0,0,.3) 3px);");
  out.println("background-image: repeating-linear-gradient(135deg, rgba(0,0,0,.3), rgba(0,0,0,.3) 1px, transparent 2px, transparent 2px, rgba(0,0,0,.3) 3px);");
  out.println("-webkit-background-size: 4px 4px;");
  out.println("-moz-background-size: 4px 4px;");
  out.println("background-size: 4px 4px;");
  out.println("}");
  out.println("");
  out.println("#logo_traditional_and_links_traditional_format, #logo_traditional_and_links_responsive_format { text-transform: uppercase; font-weight: bold; }");
  out.println("");
  out.println("textarea, input { margin-top: 6px; margin-bottom: 6px; font-size: 14pt; }");
  out.println("");
  out.println(".footer .foot_label { text-align: left; height: 100%; width: auto; word-wrap: break-word; }");
  out.println("</style>");
  
  out.println("<div class=\"pre_header\" style=\"background-color: #FBDFCC; vertical-align: top; text-align: left\">");
  out.println("</div>");
  out.println("<div class=\"header\" style=\"background-color: #5A403B; vertical-align: top; text-align: left\">");
  out.println("<div id=\"logo_traditional_and_links_traditional_format\">");
  out.println("<div style=\"display: table; text-align: left; width: 80%; padding-top: 15px; padding-bottom: 15px; margin-left: 10%; margin-right: 10%\">");
  out.println("<div style=\"display: table-row; text-align: left; width: 100%;\">");
  out.println("<div style=\"display: table-cell; text-align: left; width: 30%;\">");
  out.println(Request_Website_Logo.request_website_logo());
  out.println("</div>");
  out.println("<div style=\"display: table-cell; text-align: right; width: 70%; vertical-align: middle; word-wrap: break-word\">");
  out.println("<div style='text-align: right; vertical-align: top; width: 100%'><p>");
  out.println(Request_Website_Links.request_website_links_horizontal_format());
  out.println("</p></div>");
  out.println("</div>");
  out.println("</div>");
  out.println("</div>");
  out.println("</div>");
  out.println("<div id=\"logo_traditional_and_links_responsive_format\">");
  out.println("<div style=\"display: table; text-align: left; width: 98%; padding-top: 15px; padding-bottom: 15px; margin-left: 1%; margin-right: 1%\">");
  out.println("<div style=\"display: table-row; text-align: left; width: 100%;\">");
  out.println("<div style=\"display: table-cell; text-align: left; vertical-align: center; width: 50%;\">");
  out.println(Request_Website_Logo.request_website_logo());
  out.println("</div>");
  out.println("<div style=\"display: table-cell; text-align: right; width: 50%; vertical-align: middle\">");
  out.println("<div id=\"show_vertical_menu\">");
  out.println("<p><b><a id=\"click_show_vertical_menu\" onclick=\"onclick_show_vertical_menu()\">");
  out.println("<div style=\"display: table; width: 100%; text-align: right\">");
  out.println("<div style=\"display: table-row; text-align: right\">");
  out.println("<div style=\"display: table-cell; text-align: right\">___</div></div></div>");
  out.println("<div style=\"display: table; width: 100%; text-align: right; margin-top: -10px\">");
  out.println("<div style=\"display: table-row; text-align: right\">");
  out.println("<div style=\"display: table-cell; text-align: right\">___</div></div></div>");
  out.println("<div style=\"display: table; width: 100%; text-align: right; margin-top: -10px\">");
  out.println("<div style=\"display: table-row; text-align: right\">");
  out.println("<div style=\"display: table-cell; text-align: right\">___</div></div></div></a></b></p>");
  out.println("</div>");
  out.println("<div id=\"hide_vertical_menu\">");
  out.println("<p><b><a id=\"click_hide_vertical_menu\" onclick=\"onclick_hide_vertical_menu()\">");
  out.println("<div style=\"display: table; width: 100%; text-align: right\">");
  out.println("<div style=\"display: table-row; text-align: right\">");
  out.println("<div style=\"display: table-cell; text-align: right\">___</div></div></div>");
  out.println("<div style=\"display: table; width: 100%; text-align: right; margin-top: -10px\">");
  out.println("<div style=\"display: table-row; text-align: right\">");
  out.println("<div style=\"display: table-cell; text-align: right\">___</div></div></div>");
  out.println("<div style=\"display: table; width: 100%; text-align: right; margin-top: -10px\">");
  out.println("<div style=\"display: table-row; text-align: right\">");
  out.println("<div style=\"display: table-cell; text-align: right\">___</div></div></div></a></b></p>");
  out.println("</div>");
  out.println("</div>");
  out.println("</div>");
  out.println("</div>");
  out.println("<div style=\"display: table; text-align: left; width: 98%; margin-left: 1%; margin-right: 1%\">");
  out.println("<div style=\"display: table-row; text-align: left; width: 100%;\">");
  out.println("<div style=\"display: table-cell; text-align: left; width: 100%; word-wrap: break-word\">");
  out.println("<script type=\"text/javascript\">");
  out.println("$(document).ready(function() {");
  out.println("");
  out.println("$(\"#show_vertical_menu\").fadeIn();");
  out.println("});");
  out.println("");
  out.println("function onclick_show_vertical_menu() {");
  out.println("");
  out.println("$(\".show_vertical_menu\").slideDown(1200);");
  out.println("$(\"#hide_vertical_menu\").slideDown(1200);");
  out.println("$(\"#show_vertical_menu\").slideUp(1200);");
  out.println("}");
  out.println("");
  out.println("function onclick_hide_vertical_menu() {");
  out.println("");
  out.println("$(\".show_vertical_menu\").slideUp(1200);");
  out.println("$(\"#show_vertical_menu\").slideDown(1200);");
  out.println("$(\"#hide_vertical_menu\").slideUp(1200);");
  out.println("}");
  out.println("</script>");
  out.println(Request_Website_Links.request_website_links_vertical_format());
  out.println("</div>");
  out.println("</div>");
  out.println("</div>");
  out.println("</div>");
  out.println("</div>");
  out.println("<div class=\"content\" style=\"vertical-align: top; text-align: left\">m");
  out.println(Request_Web_Page.request_content());
  out.println("</div>");
  out.println("<div class=\"footer\" style=\"text-align: left; word-wrap: break-word\">");
  out.println(Request_Footer_Content.request_footer_content());
  out.println("<div class=\"signature_section\">");
  out.println("<div id=\"footer_traditional_format\">");
  out.println("<div style=\"text-align: left; width: 80%; margin-left: 10%; margin-right: 10%; padding-top: 15px; padding-bottom: 10px;\">");
  out.println("<span class=\"foot_label\">Powered by <b><a href=\"http://www.timothysdigitalsolutions.com/\">Timothy's Digital Solutions</a> Framework</b></span>");
  out.println("</div>");
  out.println("</div>");
  out.println("<div id=\"footer_responsive_format\">");
  out.println("<div style=\"text-align: center; width: 98%; margin-left: 1%; margin-right: 1%; padding-top: 15px; padding-bottom: 20px;\">");
  out.println("<span class=\"foot_label\">Powered by <b><a href=\"http://www.timothysdigitalsolutions.com/\">Timothy's Digital Solutions</a> Framework</b></span>");
  out.println("</div>");
  out.println("</div>");
  out.println("</div>");
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
