
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>修改部门</title>
</head>
<body>

    <form method="post" action="${pageContext.request.contextPath}/dept/update">
        <input type="hidden" name="did" value="${dept.did}" >
        <input type="text"  value="${dept.did}" disabled="disabled"/><br/>
        <input type="text" name="dname" value="${dept.dname}"/><br/>
        <input type="submit" value="保存修改"/><br/>
    </form>
</body>
</html>
