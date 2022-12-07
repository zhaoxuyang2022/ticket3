<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>购票大厅</title>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }c
    </style>

    <script>
        window.onload = function (){
            document.getElementById("buy").onclick = function (){
                document.getElementById("form").submit();
            }
        }
    </script>
</head>
<body>



<div class="container">
    <h3 style="text-align: center">购票大厅</h3>

    <div style="float: left;">

        <form class="form-inline" action="${pageContext.request.contextPath}/trainListServlet" method="post">
            <div class="form-group">
                <label for="exampleInputName2">日期</label>
                <input type="text" name="train_time" class="form-control" id="exampleInputName2" >
            </div>
            <div class="form-group">
                <label for="exampleInputName3">始发地</label>
                <input type="text" name="origin" class="form-control" id="exampleInputName3" >
            </div>

            <div class="form-group">
                <label for="exampleInputName4">目的地</label>
                <input type="text" name="destination" class="form-control" id="exampleInputName4"  >
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>

    </div>

    <div style="float: right;margin: 5px;">
        <a class="btn btn-primary" href="javascript:void(0)" id="buy">购票</a>
    </div>
    <form id="form" action="${pageContext.request.contextPath}/buyServlet" method="post">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th></th>
                <th>编号</th>
                <th>日期</th>
                <th>车次</th>
                <th>始发地</th>
                <th>目的地</th>
                <th>剩余票数</th>
            </tr>

            <c:forEach items="${trains}" var="train" varStatus="s">
                <tr>
                    <td><input type="checkbox" name="uid" value="${train.id}"></td>
                    <td>${s.count}</td>
                    <td>${train.train_time}</td>
                    <td>${train.train_name}</td>
                    <td>${train.origin}</td>
                    <td>${train.destination}</td>
                    <td>${train.num}</td>
                </tr>

            </c:forEach>


        </table>
    </form>

</div>


</body>
</html>