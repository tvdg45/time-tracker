<%@ page import="controllers.Control" %>
<html>
   <head>
      <title>Reading Checkbox Data</title>
   </head>
   
   <body>
      <h1>Reading Checkbox Data</h1>
      <form action = "https://java-test-9.herokuapp.com/form.jsp" method = "POST">
         <input type = "checkbox" name = "maths" checked = "checked" /> Maths
         <input type = "checkbox" name = "physics"  /> Physics
         <input type = "checkbox" name = "chemistry" checked = "checked" /> Chemistry
         <input type = "text" name = "text" />
         <input type = "submit" value = "Select Subject" />
      </form>      
      <ul>
         <li><p><b>Maths Flag:</b>
            <%= request.getParameter("maths")%>
         </p></li>
         <li><p><b>Physics Flag:</b>
            <%= request.getParameter("physics")%>
         </p></li>
         <li><p><b>Chemistry Flag:</b>
            <%= request.getParameter("chemistry")%>
         </p></li>
      </ul>
      <div>
         <%
            Control new_control = new Control();
            
            String text = "";
            
            text = request.getParameter("text");
            
            if (text == "null") {
               
               out.println("<h1>hello</h1>");
            } else {
               
               out.println(text);
            }
            
            out.println(new_control.get_data());
         %>
      </div>
   </body>
</html>
