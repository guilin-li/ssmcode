<%--
  Created by IntelliJ IDEA.
  User: guilin
  Date: 2020/10/16
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="2px" width="100%"
       <c:forEach items="${list}" var="person">
           <tr>
               <td>${person.id}</td>
               <td>${person.name}</td>
               <td>${person.money}</td>

           </tr>
       </c:forEach>

</table>

</body>
</html>
