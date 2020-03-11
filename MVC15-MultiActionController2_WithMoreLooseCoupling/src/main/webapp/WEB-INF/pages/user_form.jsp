<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>    
  <h1 style="color:blue;text-align:center"> MultipleActionController Example </h1>
<form name="frm"    action="perform.htm"   method="POST">
      userId ::  <input type="text"  name="userId"> <br>
      userName ::<input type="text"  name="userName"> <br>
      Addrs ::<input type="text"  name="addrs"> <br>
      Email ::<input type="text"  name="email"> <br>
       <input  type="button" value="register"  onclick="isRegister()">
       <input  type="button" value="modify"  onClick="isModify()">
       <input  type="button" value="remove"  onclick="isRemove()">
       <input  type="button" value="display"  onclick="isDisplay()">
</form> 
 <br><br><bR>
 
  <script>
       function isRegister(){
    	   frm.action="put.htm";
    	   frm.submit();
       }
       function isModify(){
    	   frm.action="change.htm";
    	   frm.submit();
       }
       function isRemove(){
    	   frm.action="erase.htm";
    	   frm.submit();
       }
       function isDisplay(){
    	   frm.action="show.htm";
    	   frm.submit();
       }


  </script>
 
 <c:if test="${!empty operation }">
  <b>${operation } </b>  is performed. <br>
  </c:if>
  <c:if test="${!empty cmdData }">
  command obj data is  ::  ${cmdData } <br>
  </c:if>
  

