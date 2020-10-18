
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>添加部门</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/dept/save">
    <input type="text" name="dname"/><br/>
    <input type="submit" value="保存"/><br/>
</form>
</body>
</html>
