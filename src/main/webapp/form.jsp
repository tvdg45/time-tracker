<html>
   <head>
      <title>Reading Checkbox Data</title>
   </head>
   
   <body>
      <h1>Reading Checkbox Data</h1>
      <form action = "form.jsp" method = "POST" target = "_blank">
         <input type = "checkbox" name = "maths" checked = "checked" /> Maths
         <input type = "checkbox" name = "physics"  /> Physics
         <input type = "checkbox" name = "chemistry" checked = "checked" /> Chemistry
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
   
   </body>
</html>
