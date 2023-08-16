<%@ page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<link rel="stylesheet"type="text/css" href="css/style.css">
<script language="javaScript" src="js/validation.js"></script>

<h1 style="color:green;text-align:center">Student Resistration Form</h1>

<frm:form modelAttribute="emp" onsubmit="return doValidation(this)">
<frm:input type="hidden" path="vFlag"/>
    <table border="0" bgcolor="cyan" align="center">
    <%--<p style="color:red;text-align:center">
   <frm:errors path="*"/>
   </p>--%>
   
   <tr>
   <td>Employee name::</td>
   <td><frm:input path="ename"/><frm:errors path="ename"/><span id="enameErr"></span> </td>
   </tr>
   <tr>
   <td>Desg::</td>
   <td><frm:input path="job"/><frm:errors path="job"/><span id="jobErr"></span></td>
   </tr>
   <tr>
   <td>Salary::</td>
   <td><frm:input path="sal"/><frm:errors path="sal"/><span id="salErr"></span>   </td>
   </tr>
  <tr>
   <td>Department No::</td>
   <td><frm:select path="deptNo">
       <frm:options items="${DeptInfo }"/>
       </frm:select>
    </td>
   </tr>
   <tr>
   <td><input type="submit" value="resister"></td>
   <td><input type="reset" value="cancel"></td>
   </tr>
   </table>
</frm:form>