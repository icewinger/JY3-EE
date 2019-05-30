<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/28 0028
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap 101 Template</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <style type="text/css">
        @media (min-width: 768px) {
            #slider_sub {
                width: 250px;
                margin-top: 51px;
                position: absolute;
                z-index: 1;
                height: 600px;
            }

            .mysearch {
                margin: 10px 0;
            }

            .page_main {
                margin-left: 255px;
            }
        }

        .splitter {
            width: 5px;
            height: 100%;
            bottom: 0;
            left: 240px;
            position: absolute;
            overflow: hidden;
            background-color: #fff;
        }

        .pageContent {
            height: 100%;
            min-width: 768px;
            left: 246px;
            top: 0;
            right: 0;
            z-index: 3;
            padding-top: 60px;
            padding-bottom: 30px;
            position: absolute;
        }
        #btn1
        {
            margin-left:200px ;
        }

    </style>
</head>
<body>
<!-- 导航-->
<nav class="navbar navbar-default navbar-static-top">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#slider_sub"
                aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a href="#" class="navbar-brand">网站后台管理</a>
    </div>
    <ul class="nav navbar-nav navbar-right" style="margin-right:25px;">
        <li><a href="#"><span class="bage" style="background: #C12E2A;">23</span></a></li>
        <li><a href="#"><span class="glyphicon glyphicon-off"></span> 注销</a></li>
    </ul>

    <!-- 侧边栏-->
    <div class="navbar-default navbar-collapse" id="slider_sub">
        <ul class="nav">
            <li>
                <div class="input-group mysearch">
                    <form action="queryByKey.do" method="post" target="mainFrame">
                        <input type="text" class="form-control" name="likequery"/>
                            <span class="input-group-btn">
                                <button type="submit" class="btn btn-default" id="btn1" name="btn1">
                                   <span class="glyphicon glyphicon-search"></span>
                                </button>
                            </span>
                    </form>
                </div>
            </li>
            <li><a href="#sub1" data-toggle="collapse">系统功能<span
                    class="glyphicon glyphicon-chevron-right pull-right"></span></a>
                <ul id="sub1" class="nav cllapse">
                    <li><a href="/query.do" target="mainFrame"><span
                            class="glyphicon glyphicon-info-sign">查询全部商品信息</span></a></li>
                    <li><a href="addOnePro.jsp" target="mainFrame"><span
                            class="glyphicon glyphicon-info-sign">添加商品</span></a></li>
                    <li><a href="show02.do" target="mainFrame"><span class="glyphicon glyphicon-info-sign"></span>修改商品信息</a>
                    </li>
                    <li><a href="show01.do" target="mainFrame"><span
                            class="glyphicon glyphicon-info-sign"></span>删除商品</a></li>
                </ul>
            </li>
            <li><a href="#sub2" data-toggle="collapse">栏目功能<span
                    class="glyphicon glyphicon-chevron-right pull-right"></span></a>
                <ul id="sub2" class="nav cllapse">
                    <li><a href="#"><span class="glyphicon glyphicon-info-sign"></span>查询商品类别</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-info-sign"></span>添加商品类别</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-info-sign"></span>修改商品类别</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-info-sign"></span>删除商品类别</a></li>
                </ul>
            </li>
        </ul>
    </div>
</nav>

<!-- 左侧导航和正文内容的分隔线 -->
<div class="splitter"></div>
<!-- 正文内容部分 -->
<div class="pageContent">
    <iframe src="welcome.jsp" id="mainFrame" name="mainFrame"
            frameborder="0" width="100%" height="100%" frameBorder="0">
    </iframe>
</div>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</body>
</html>

