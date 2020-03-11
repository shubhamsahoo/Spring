<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<form:form  method="POST"  modelAttribute="userCmd">
    username :: <form:input path="username"/> <br>
    password :: <form:input path="password"/> <br>
    <input type="submit"  value="Login">
</form:form>     <br><br>

<c:if test="${!empty resultMsg}">
   ${resultMsg}
</c:if>


    
    
    
