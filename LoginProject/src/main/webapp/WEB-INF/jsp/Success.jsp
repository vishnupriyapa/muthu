<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">	
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script> 
<title>Insert title here</title>
</head>
<body>

<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Welcome ${r.firstName}${r.lastName}</a>
			<a class="navbar-brand" href="#">${rs.firstName}${rs.lastName}</a>
		</div>

		<ul class="nav navbar-nav navbar-right">
			<li><a class="nav-link" href="Index.jsp"> HOME</a></li>
			<li><a class="nav-link" href="login"> LOGOUT</a></li>
		</ul>
	</div>
	</nav> 
	<table>
	<tr>
	<td style="padding-left: 20px;"><div class="dropdown">
    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Account
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
     <%-- <c:if test="${rs.accountType==null }"> --%> 
     <c:if test="${r.accountType==null }">
      <li><a href="savings?id=${r.id}">Create savings account</a></li>
      </c:if>
      <li><a href="#">CSS</a></li>
      <li><a href="#">JavaScript</a></li>
    </ul>
  </div></td>
  <td style="padding-left: 20px;"><div class="dropdown">
    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Fund Transfer
    <span class="caret"></span></button>
    <c:if test="${r.accountType!=null }">
    <%--  <c:if test="${rs.accountType!=null}"> --%>
    <ul class="dropdown-menu">    
      <li><a href="benefit?id=${r.id}">Add Beneficiary</a></li>   
      <li><a href="#">fund transfer</a></li>    
    </ul>
     </c:if>
  </div></td>
	</tr>
	</table>
	<%-- <div class="dropdown">
    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Account
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
     <c:if test="${rs.accountType==null }"> 
      <li><a href="savings?id=${r.id}">Create savings account</a></li>
      </c:if>
      <li><a href="#">CSS</a></li>
      <li><a href="#">JavaScript</a></li>
    </ul>
  </div> --%>
 <c:if test="${r.accountType!=null }"> 
  <table class="table table-bordered">
  <tr>
  <th>accountNo</th>
  <th>accountType</th>
  <th>balance</th>
  <th>createdDate</th>
  </tr>
  <tr>
  <td>${r.accountNo}</td>
  <td>${r.accountType}</td>
  <td>${r.balance}</td>
  <td>${r.createdDate}</td> 
  </tr>
  </table>
</c:if>
</body>
</html>