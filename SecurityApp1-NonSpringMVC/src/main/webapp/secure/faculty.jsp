<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>

    <h1 style="color:red;text-align:center">Faculty Page</h1>
    Logged In User::<b><%=request.getUserPrincipal().getName() %></b> <br>
    
    <a href="../index.jsp">home</a>  <br> <br><br>
    <a href="student.jsp"> Student page</a> <br><br>
    <a href="../logout">Logout</a>
    
    