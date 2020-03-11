<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles"   prefix="tiles"%>
<head>
   <title><tiles:insertAttribute  name="title"/> </title>
</head>

<table border="0" rows="3" cols="2"  width="100%" height="100%">
 <tr height="20%">
    <td colspan="2" bgcolor="pink"><tiles:insertAttribute name="header"/> </td>
 </tr>
 <tr  height="70%">
     <td  width="30%"  bgcolor="powderblue"><tiles:insertAttribute name="menu" />   </td>
     <td width="70%" bgcolor="yellow"><tiles:insertAttribute name="body"/> </td>
 </tr>
 <tr  height="10%" bgcolor="cyan">
     <td  colspan="2"> <tiles:insertAttribute name="footer"/> </td>
 </tr>
</table>
    
