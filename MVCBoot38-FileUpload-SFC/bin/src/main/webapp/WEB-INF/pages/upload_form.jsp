<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>    
    
    
    <h1 style="color:red;text-align:center">  File Upload </h1>
    
    <form:form  method="POST"  enctype="multiPart/form-Data"  modelAttribute="uplCmd">
       Select   File1 ::  <input type="file"  name="file1"> <br>
       Select   File2 ::  <input type="file"  name="file2"> <br>
       <input type="submit"   value="upload files">
    </form:form>
