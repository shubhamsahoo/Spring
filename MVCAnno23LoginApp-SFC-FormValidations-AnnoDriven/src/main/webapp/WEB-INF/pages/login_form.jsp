<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
 <%@taglib uri="http://www.springframework.org/tags/form"   prefix="form"%>    

    
    <h1 style="color:red;text-align:center"> Login Page</h1>
    
    <form:form  method="POST"  modelAttribute="userCmd">
       <p style="color:red">
            <form:errors path="*"/>
       </p>
        Login Username:: <form:input path="username"/> <br>
        Login Password :: <form:password path="password"/> <br>
        Person age :: <form:input path="age"/>  <br>
        Country :: <form:select path="country">
                                  <form:options items="${countriesList}"/>
                             </form:select>  <br>
          Hobies :: <form:checkboxes items="${hobiesList}" path="hobies"/> <br>      
          DOB :: <form:input path="dob"/>  (dd-MM-yyyy)<br>             
        <input type="submit"  value="Login"> <br>
    </form:form> <br>
    
      <b>${resultMsg} </b>   <br><br>
      command data ::  ${cmdData }
    
    