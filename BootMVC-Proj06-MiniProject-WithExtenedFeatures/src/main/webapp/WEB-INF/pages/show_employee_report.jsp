<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"/>

<div class="container">
<c:choose>
  <c:when test="${!empty emp_details.getContent()}">
  <table border="1" class="table">
  <tr class="table-danger">
  <th>EmpNo</th>
  <th>EmpName</th>
  <th>Job</th>
  <th>Salary</th>
  <th>Operations</th>
  </tr>
  
    <c:forEach var="emp" items="${emp_details.getContent()}" >
     <tr class="table-success">
      <td>${emp.eno}</td>
      <td>${emp.ename}</td>
      <td>${emp.job}</td>
      <td>${emp.sal}</td>
      <td>${emp.deptNo}</td>
      <td><a href="emp_edit?no=${emp.eno}"><img src="images/edit.png"width="30px"height="30px"></a>
      <a href="emp_delete?no=${emp.eno}" onclick="return confirm('do you want to delete employee')"><img src="images/delete.png"width="30px"height="30px"></a>
      </td>
    </tr>
    </c:forEach>
  </table>
  
  <p style="text-align:center">
  <c:if test="${emp_details.hasPrevious()}">
    <a href="emp_report?page=${emp_details.getPageable().getPageNumber()-1}">previous</a> &nbsp;&nbsp;
  </c:if>
  <c:if test="${!emp_details.isFirst()}">
    <a href="emp_report?page=0">first</a>&nbsp;&nbsp;
  </c:if>
  <c:forEach var="i" begin="1" end="${emp_details.getTotalPages()}" step="1">
     <a href="emp_report?page=${i-1}">${i}</a> &nbsp;&nbsp;
  </c:forEach>
  <c:if test="${!emp_details.isLast()}">
    <a href="emp_report?page=${emp_details.getPageable().getPageNumber()-1}">last</a> &nbsp;&nbsp;
  </c:if>
  <c:if test="${emp_details.hasNext()}">
    <a href="emp_report?page=${emp_details.getPageable().getPageNumber()+1}">next</a>
  </c:if>
  </p>
  </c:when>
  <c:otherwise>
  <h1 style="color:red;text-align:center">Employee not found</h1>
  </c:otherwise>
</c:choose> 
<center>
<a href="emp_add"><img src="images/add.png"width="40px"height="60px">Add Employee</a>
<a href="./"><img src="images/home.png"width="40px"height="60px">Home</a>
</center>
<h1 style="color:green;text-align:center">${Result_msg} </h1>
</div>
   
