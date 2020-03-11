<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>


 <h1 style="color:red;text-align:center"> All  ${operation }  </h1>
 
 <c:choose>
   <c:when test="${!empty resultList }">
       <c:forEach  var="res"  items="${resultList}" >
              ${res} <br>
       </c:forEach>
   </c:when>
 </c:choose>    
    
   
    
    
