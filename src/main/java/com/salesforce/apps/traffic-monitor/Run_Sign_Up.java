import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import java.util.Date;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Run_Sign_Up extends HttpServlet {
	
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.addHeader("Access-Control-Allow-Origin", "https://www.timothysdigitalsolutions.com");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
		
		PrintWriter out = response.getWriter();
		
		/*Control_Sign_Up run_sign_up = new Control_Sign_Up();
		
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirm_password = request.getParameter("confirm_password");
		String date_received = request.getParameter("date_received");
		String time_received = request.getParameter("time_received");
		String sign_up = request.getParameter("sign_up");
		
		out.println("<!DOCTYPE html>");
		out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
		out.println("<head>");
		out.println("<title>Sign up form</title>");
		out.println("</head>");
		out.println("<body>");
		out.println(run_sign_up.control_sign_up(String.valueOf(first_name), String.valueOf(last_name), String.valueOf(email), String.valueOf(username), String.valueOf(password), String.valueOf(confirm_password), String.valueOf(date_received), String.valueOf(time_received), String.valueOf(sign_up)));
		out.println("</body>");
		out.println("</html>");*/
		
        String from = "kodejava@gmail.com";
        String to = "kodejava@gmail.com";
        String subject = "Hello";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", "587");
        Session session = Session.getDefaultInstance(props);
		
        try {
            InternetAddress fromAddress = new InternetAddress(from);
            InternetAddress toAddress = new InternetAddress(to);

            Message message = new MimeMessage(session);
            message.setFrom(fromAddress);
            message.setRecipient(Message.RecipientType.TO, toAddress);
            message.setSubject(subject);

            String sb = "<head>" +
                "<style type=\"text/css\">" +
                "  .red { color: #f00; }" +
                "</style>" +
                "</head>" +
                "<h1 class=\"red\">" + message.getSubject() + "</h1>" +
                "<p>" +
                "Lorem ipsum dolor sit amet, <em>consectetur</em> adipisicing elit, " +
                "sed do eiusmod tempor incididunt ut labore et dolore magna <strong>" +
                "aliqua</strong>.</p>";
            message.setContent(sb, "text/html; charset=utf-8");
            message.saveChanges();

            // Send the message to the recipient. You also need to specify the username 
            // and password to authenticate to the mail server.
            Transport.send(message, "kodejava", "********");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
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
