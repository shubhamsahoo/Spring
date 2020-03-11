<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
 <%@taglib uri="http://www.springframework.org/tags/form"   prefix="form"%>
 
 <h1 style="color:red;text-align:center"> Registration Form Number -->2 </h1>
 
 <form:form  method="POST"  commandName="regCmd">
   <table>
   <tr><td>     Qualification :: </td> <td> <form:input path="qlfy"/> </td> </tr> 
    <tr><td>  Desg :: </td> <td>  <form:input path="desg"/> </td></tr> 
      <tr> <td>Salary :: </td> <td><form:input path="salary"/> </td></tr>
     </table> 
       <input type="submit"  value="previous"  name="_target0"> 
            <input type="submit"  value="next"  name="_target2"> 
       <input type="submit"  value="cancel"  name="_cancel"> 
 </form:form>    
    
    
