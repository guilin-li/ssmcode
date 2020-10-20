<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <% pageContext.setAttribute("path",request.getContextPath()); %>
    <link href="${path}/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="${path}/js/jquery-1.11.0.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="${path}/js/bootstrap.min.js"></script>
    <title>Title</title>
</head>
<body>
<div class="container" >
    <!-- container 表示容器，所有内容放进这个容器-->
    <div class="row">
        <!-- row表示 一行的宽度-->
        <div class="col-md-4" >
            <!--col-md-4 表示使用一行的4/12宽度 -->
            <h1>添加部门</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12" >
            <form>
                <div class="form-group">
                    <label for="dname">部门名称</label>
                    <input type="text" class="form-control" id="dname" placeholder="部门名称">
                </div>

                <button type="submit" class="btn btn-default">保存</button>
            </form>
        </div>
    </div>


</div>
</body>

</html>
