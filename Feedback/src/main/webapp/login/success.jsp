<%@ page import="at.techtitans.hackathon.entities.Employee" %><%--
  Created by IntelliJ IDEA.
  User: laurin
  Date: 28.06.24
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Success
<%
    session = request.getSession();
    Employee loggedInEmployee = (Employee) session.getAttribute("loggedInUser");

    out.println(loggedInEmployee.getId());
%>
</body>
</html>
