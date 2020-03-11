<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>    
  <h1 style="color:blue;text-align:center"> MultipleActionController Example </h1>
<form     action="perform.htm"   method="POST">
      userId ::  <input type="text"  name="userId"> <br>
      userName ::<input type="text"  name="userName"> <br>
      Addrs ::<input type="text"  name="addrs"> <br>
      Email ::<input type="text"  name="email"> <br>
       <input name="s1" type="submit" value="add">
       <input name="s1" type="submit" value="update">
       <input name="s1" type="submit" value="delete">
       <input name="s1" type="submit" value="view">
</form> 
 <br><br><bR>
 
 <c:if test="${!empty operation }">
  <b>${operation } </b>  is performed. <br>
  </c:if>
  <c:if test="${!empty cmdData }">
  command obj data is  ::  ${cmdData } <br>
  </c:if>
  

