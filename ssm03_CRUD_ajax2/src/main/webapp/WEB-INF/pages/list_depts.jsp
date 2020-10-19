<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<%
    pageContext.setAttribute("path", request.getContextPath());
%>
<head>
    <title>Title</title>
    <!-- 引入-->
    <script type="text/javascript" src="${path}/js/jquery-1.11.0.min.js"></script>
    <!-- 开始ajax编程  -->
    <script type="text/javascript">
        function deleteById(did) {
            $.get('${path}/deptv2/delete?did='+did,function (result) {
                console.info(result)
                if(200==result.code){
                    alert(result.msg)
                    refreshTable()//调用列表更新
                }else{
                    alert(result.msg)
                }
            },'json')
        }
        function switchDiv(part) {
            //隐藏内容
            $('#addDiv').css("display","none")
            $('#listDiv').css("display","none")
            $('#editDiv').css("display","none")
            if(1 == part){//添加页面
                $('#addDiv').css("display","block")
                $('#add_dname').val('')
            }else if(2 == part){//列表页面
                $('#listDiv').css("display","block")
            }else if(3 == part){//编辑页面
                $('#editDiv').css("display","block")
            }

        }
        function refreshTable(){
            //页面加载成功
            $('#table').html('')
            //1:js发送请求
            $.get('${path}/deptv2/list', function (result) {
                //2:js接收结果
                console.info("result=" + result)
                //{"code":200,"msg":"","data":[{"did":1,"dname":"JAVA"},{"did":2,"dname":"测试"},{"did":3,"dname":"最牛部门33"}]}

                //定义表格的内容
                var trs = ''
                //拼接表头
                trs += ' <tr>\n' +
                    '        <td>编号</td>\n' +
                    '        <td>部门名称</td>\n' +
                    '        <td>管理</td>\n' +
                    '\n' +
                    '    </tr>'
                if (200 == result.code) {
                    var items = result.data;
                    //3:js更新页面
                    for (var i = 0; i < items.length; i++) {
                        var dept = items[i]
                        console.info(dept)
                        trs += ' <tr>\n' +
                            '        <td>' + dept.did + '</td>\n' +
                            '        <td>' + dept.dname + '</td>\n' +
                            '        <td><a href="javascript:deleteById('+dept.did+')">删除 | </a><a href="javascript:updateUI('+dept.did+')">修改</a></td>\n' +
                            '\n' +
                            '    </tr>'
                    }//end for

                    $('#table').html(trs)
                }

            }, 'json')  //参1 地址 参2 处理函数  参3 数据类型


        }
        $(function () {
            switchDiv(2)
            refreshTable()
            $('#btn_add').click(function () {
                //alert('btn_add') 普通的表单提交 did=1&dname=测试组
                var data = $('#add_form').serialize() //方法会将表单数据拼接成k1=v1&k2=v2
                $.post('${path}/deptv2/add',data,function (result) {
                    console.info(result)
                    //页面切换
                    switchDiv(2)
                    //重新加载列表
                    refreshTable()
                    alert(result.msg)


                },'json')
            })
        })
        function updateUI(did) {
            //alert(did)
            //显示修改页面
            switchDiv(3)
            //获取被修改的数据作回显
            $.get('${path}/deptv2/find?did='+did,function (result) {
                if(200==result.code){
                    var dept = result.data;
                    //{"code":200,"msg":null,"data":{"did":9,"dname":"测试部门3"}}
                    $('#u_did1').val(dept.did)
                    $('#u_did2').val(dept.did)
                    $('#u_dname').val(dept.dname)
                }else{
                    alert(result.msg)//提示没有查询结果
                }
            },'json')
        }
        function update() {
            var data=$('#update_form').serialize();// k1=v1&k2=v2
            $.post('${path}/deptv2/update',data,function (result) {
                alert(result.msg)
                //切换页面
                switchDiv(2)
                //刷新列表
                refreshTable()
            },'json')
        }
    </script>
</head>
<body>
<div id="listDiv" style="display: block">
    <a href="javascript:switchDiv(1)">新增</a>
    <table border="1px" width="100%" id="table">
    </table>
</div>
<div id="addDiv">
    <h1>添加页面</h1>
    <form id="add_form"  >
        <input type="hidden" name="did"/><br/>
        <input type="text" name="dname" id="add_dname"/><br/>
        <input id="btn_add" type="button" value="保存"/><br/>
    </form>
</div>
<div id="editDiv">
    <h1>编辑页面</h1>
    <form id="update_form">
        <input id="u_did1" type="hidden" name="did"  >
        <input id="u_did2" type="text"   disabled="disabled"/><br/>
        <input id="u_dname" type="text" name="dname" /><br/>
        <input id="btn_update" onclick="update()" type="button" value="保存修改"/><br/>
    </form>
</div>

</body>
</html>
