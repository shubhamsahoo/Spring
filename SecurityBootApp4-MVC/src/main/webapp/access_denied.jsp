<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <h1 style="color:red;text-align:center"> Authrorization failed for the user  <%=request.getUserPrincipal().getName() %> </h1>

<a href="home.htm">home</a>    

<br>
<a href="logout">logout</a>
      
