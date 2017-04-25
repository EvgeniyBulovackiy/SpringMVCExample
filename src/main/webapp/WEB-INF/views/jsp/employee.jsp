<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table style="align-content: center">
    <tr>
        <th>First Name</th>
        <th>Surname</th>
        <th>Position</th>
        <th>Phone number</th>
        <th>Salary</th>
    </tr>
    <tr>
            <td>${employee.name}</td>
            <td>${employee.surname}</td>
            <td>${employee.position}</td>
            <td>${employee.phoneNumber}</td>
            <td>${employee.salary}</td>
    </tr>
</table>

</body>
</html>
