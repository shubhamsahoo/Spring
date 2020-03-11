<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>

<h1 style="color:red;text-align:center">Select file to download </h1>

<c:choose>
   <c:when test="${!empty  filesList }">
      <table  border="1">
           <c:forEach var="fname"  items="${filesList}">
                 <tr>
                   <td>${fname }  </td>
                   <td> <a href="download.htm?fileName=${fname}">Download</a>  </td>
                   </tr>
           </c:forEach>
      </table>
   </c:when>
   <c:otherwise>
         <b> <i> No files are found </i></b>
   </c:otherwise>
</c:choose>
    
