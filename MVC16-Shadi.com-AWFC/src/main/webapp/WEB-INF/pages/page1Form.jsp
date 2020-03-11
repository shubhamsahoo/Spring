<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
 <%@taglib uri="http://www.springframework.org/tags/form"   prefix="form"%>
 
 <h1 style="color:red;text-align:center"> Registration Form Number -->1 </h1>
 <form:form  method="POST"  commandName="regCmd">
   <table>
   <tr><td>      Name :: </td> <td> <form:input path="name"/> </td> </tr> <br>
    <tr><td>  Address :: </td> <td>  <form:input path="addrs"/> </td></tr> <br>
      <tr> <td>Gender :: </td> <td><form:radiobuttons path="gender"  items="${gendersList}"/> </td> </tr> <br>
   <tr><td>   Date of Birth :: </td> <td> <form:input path="dob"  /> (dd-MM-yyyy)  </td> </tr> <br>
   <tr><td>    <input type="submit"  value="next"  name="_target1"> </td>
       <td><input type="submit"  value="cancel"  name="_cancel"> </td> </tr>
      </table>
 </form:form>    
    
    
