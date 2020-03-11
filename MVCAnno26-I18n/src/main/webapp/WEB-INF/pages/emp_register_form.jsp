<%@ page language="java" contentType="text/html; charset=UTF-8"
      isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
 <%@taglib uri="http://www.springframework.org/tags"  prefix="spring"  %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
 
 <head>
   <title><spring:message code="reg.title"/></title>
 </head>
  <h1 style="color:red;text-align:center"> <spring:message code="reg.heading"/> </h1>
  
 <form:form  modelAttribute="empCmd"  method="POST">
     <b><spring:message code="reg.id"/></b> <form:input path="eid"/>  <br>
     <b><spring:message code="reg.name"/></b> <form:input path="ename"/>  <br>
     <b><spring:message code="reg.addrs"/></b> <form:input path="addrs"/>  <br>
     <b><spring:message code="reg.salary"/></b> <form:input path="salary"/>  <br>
     <input type="submit"  value="<spring:message code="btn.cap"/>"/>
  </form:form>
   
    <br><br>
    <a href="?lang=fr_FR">French</a> &nbsp;&nbsp;&nbsp;&nbsp;
    <a href="?lang=hi_IN">Hindi</a> &nbsp;&nbsp;&nbsp;&nbsp;
    <a href="?lang=de_DE">German</a> &nbsp;&nbsp;&nbsp;&nbsp;
     <a href="?lang=en_US">English</a> &nbsp;&nbsp;&nbsp;&nbsp;

  <fmt:setLocale value="${response.locale}"/>

  <jsp:useBean id="dt" class="java.util.Date"/>
  <fmt:formatDate value="${dt}"  var="fdt"   type="both"/>
  Formatted System Date ::  ${fdt}.  <br>
  
  <fmt:formatNumber var="fPrice" value="200000000" type="currency"  />
  Formatted price ::  ${fPrice}.
  
  
  


    
    
