<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
 <%@taglib uri="http://www.springframework.org/tags/form"   prefix="form"%>
 
 <h1 style="color:red;text-align:center"> Registration Form Number -->3 </h1>
 
 <form:form  method="POST"  commandName="regCmd">
   <table>
   <tr><td>Expected    Desg :: </td> <td> <form:input path="expDesg"/> </td> </tr> 
    <tr><td> Expected hobies :: </td> <td>  <form:checkboxes items="${hobiesList }" path="hobies"/> </td></tr> 
      <tr> <td>Expected Age :: </td> <td><form:input path="expAge"/> </td></tr>
     </table> 
       <input type="submit"  value="previous"  name="_target1"> 
            <input type="submit"  value="finish"  name="_finish"> 
       <input type="submit"  value="cancel"  name="_cancel"> 
 </form:form>    
    
    
