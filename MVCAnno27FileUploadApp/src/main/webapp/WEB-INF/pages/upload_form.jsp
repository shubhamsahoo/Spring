<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<h1 style="Color:red;text-align:center"> Spring MVC --File Uploading </h1>

<form:form   method="POST"  enctype="multipart/form-data">
     Select file1 :: <input type="file"  name="file1"> <br>
     Select file2 :: <input type="file"  name="file2"> <br>
      <input type="submit"  value="upload">
</form:form>     
    
    
    
    
    
    
    
