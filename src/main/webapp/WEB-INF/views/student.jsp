<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Evgeniy
  Date: 21.04.2021
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student</title>
</head>
<body>
Student
<h3>Name = ${student.name}</h3>
<h3>Phone = ${student.phone}</h3>
Map student
<h3>Name = ${studentMap.name}</h3>
<h3>Phone = ${studentMap.phone}</h3>

DB student

<c:if test="${studentById != null}">
    <h3>Name = ${studentById.name}</h3>
    <h3>Phone = ${studentById.phone}</h3>
    <h3>
        <c:forEach var="teacher" items="${studentById.teachers}">
            Teacher =
            <tr>
                <td>Name = <c:out value="${teacher.name}"/></td>
            </tr>
            <tr>
                <td>Phone = <c:out value="${teacher.email}"/></td>
            </tr>
            <br>
        </c:forEach>
    </h3>
    <h3>BY PHONE = ${studentByPhone.name}</h3>
</c:if>
<c:if test="${studentById == null}">
    <div>Null</div>
</c:if>

Student collection

<%--<c:if test="${students.size() == 0}">--%>
<%--    <div> No students yet</div>--%>
<%--</c:if>--%>
<%--<c:if test="${students.size() != 0}">--%>
<%--    <table>--%>
<%--        <c:forEach var="s" items="${students}">--%>
<%--            <tr>--%>
<%--                <td>Name = <c:out value="${s.name}"/></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>Phone = <c:out value="${s.phone}"/></td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>
<%--</c:if>--%>

<a href="/student/new_get">New student</a>
</body>
</html>
