<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta charset="utf-8"/>
    <title>${pd.SYSNAME}</title>
    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>
    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href="static/ace/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="static/ace/css/font-awesome.css"/>

    <!-- page specific plugin styles -->
    <!-- text fonts -->
    <link rel="stylesheet" href="static/ace/css/ace-fonts.css"/>
    <!-- ace styles -->
    <link rel="stylesheet" href="static/ace/css/ace.css" class="ace-main-stylesheet" id="main-ace-style"/>
    <!--[if lte IE 9]>
    <link rel="stylesheet" href="static/ace/css/ace-part2.css" class="ace-main-stylesheet"/>
    <![endif]-->
    <!--[if lte IE 9]>
    <link rel="stylesheet" href="static/ace/css/ace-ie.css"/>
    <![endif]-->
    <!-- inline styles related to this page -->
    <!-- ace settings handler -->
    <script src="static/ace/js/ace-extra.js"></script>
    <!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->
    <!--[if lte IE 8]>
    <script src="static/ace/js/html5shiv.js"></script>
    <script src="static/ace/js/respond.js"></script>
    <![endif]-->
    <!--查看图片插件 -->
    <link rel="stylesheet" media="screen" type="text/css" href="plugins/zoomimage/css/zoomimage.css"/>
    <link rel="stylesheet" media="screen" type="text/css" href="plugins/zoomimage/css/custom.css"/>
    <script type="text/javascript" src="plugins/zoomimage/js/jquery.js"></script>
    <script type="text/javascript" src="plugins/zoomimage/js/eye.js"></script>
    <script type="text/javascript" src="plugins/zoomimage/js/utils.js"></script>
    <script type="text/javascript" src="plugins/zoomimage/js/zoomimage.js"></script>
    <script type="text/javascript" src="plugins/zoomimage/js/layout.js"></script>
    <!--查看图片插件 -->

    <style type="text/css">
        table.hovertable {
            font-family: verdana, arial, sans-serif;
            font-size: 11px;
            color: #333333;
            border-width: 1px;
            border-color: #999999;
            border-collapse: collapse;
        }

        table.hovertable th {
            background-color: #c3dde0;
            border-width: 1px;
            padding: 8px;
            border-style: solid;
            border-color: #a9c6c9;
        }

        table.hovertable tr {
            background-color: #d4e3e5;
        }

        table.hovertable td {
            border-width: 1px;
            padding: 8px;
            border-style: solid;
            border-color: #a9c6c9;
        }

        .button {
            display: inline-block;
            outline: none;
            cursor: pointer;
            text-align: center;
            text-decoration: none;
            font: 14px/100% Arial, Helvetica, sans-serif;
            padding: .5em 2em .55em;
            text-shadow: 0 1px 1px rgba(0, 0, 0, .3);
            -webkit-border-radius: .5em;
            -moz-border-radius: .5em;
            border-radius: .5em;
            -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .2);
            -moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .2);
            box-shadow: 0 1px 2px rgba(0, 0, 0, .2);
        }

        .button:hover {
            text-decoration: none;
        }

        .button:active {
            position: relative;
        }
    </style>

</head>
<body class="no-skin">
<div class="main-container pagination pagination-right" id="main-container">
    <!-- /section:basics/sidebar -->
    <div class="main-content">
        <div class="main-content-inner">
            <form action="pms/compareTable.do" method="post" name="Form" id="Form">
                <table style="margin-top:5px;">
                    <table style="margin-top:5px;">
                        <tr>
                            <td>
                                <div class="nav-search">
								<span class="input-icon">
									<%--<input autocomplete="off" class="nav-search-input" id="nav-search-input" type="text"--%>
                                           <%--name="tableName" value="${pd.keywords}" placeholder="这里输入表名"/>--%>
                                    <select name="type" value="${pd.keywords}" class="nav-search-input" style="width: 200px;">

                                        <option value=""></option>
                                        <option value="1">表差异</option>
                                        <option value="2">字段差异</option>
                                        <option value="3">字段类型，字段长度差异</option>
                                    </select>
								</span>
                                </div>
                            </td>
                            <td style="vertical-align:top;padding-left:2px;">
                                <input type="submit" value="查询" class="button">
                                <!-- 检索  -->
                                <a href="/pms/list.do" class="button">table</a>
                                <a href="/pms/columns.do" class="button">columns</a>
                                <a href="/pms/index.do" class="button">index</a>
                                <a href="/pms/trigger.do" class="button">trigger</a>
                            </td>
                        </tr>
                    </table>
                    <div style="width:50%;height: 100%;float: left">
                    <table class="hovertable" style="margin-top:0px;padding-top: 0px;">
                        <tr>
                            <td class='center'>序号</td>
                            <th class='center'>p46差异</th>
                        </tr>
                        <tbody>
                        <!-- 开始循环 -->
                        <c:choose>
                            <c:when test="${not empty p46List}">
                                <c:forEach items="${p46List}" var="var" varStatus="vs">
                                    <tr onmouseover="this.style.backgroundColor='#ffff66';"
                                        onmouseout="this.style.backgroundColor='#d4e3e5';">
                                        <td >${vs.index}</td>
                                        <td style="float:left;">${var.str}</td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <tr class="main_info">
                                    <td colspan="100" class="center">没有相关数据</td>
                                </tr>
                            </c:otherwise>
                        </c:choose>
                        </tbody>
                    </table>

                    </div>
                    <div style="width:50%;hight:100%;float:left;">
                        <table class="hovertable" style="margin-top:0px;padding-top: 0px;">
                            <tr>
                                <td class='center'>序号</td>
                                <th class='center'>p461差异</th>
                            </tr>
                            <tbody>
                            <!-- 开始循环 -->
                            <c:choose>
                                <c:when test="${not empty p461List}">
                                    <c:forEach items="${p461List}" var="var" varStatus="vs">
                                        <tr onmouseover="this.style.backgroundColor='#ffff66';"
                                            onmouseout="this.style.backgroundColor='#d4e3e5';">
                                            <td >${vs.index}</td>
                                            <td  style="float:left;">${var.str}</td>
                                        </tr>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <tr class="main_info">
                                        <td colspan="100" class="center">没有相关数据</td>
                                    </tr>
                                </c:otherwise>
                            </c:choose>
                            </tbody>
                        </table>
                    </div>
                        <div class="page-header position-relative">
                            <table style="width:100%;">
                                <tr>
                                    <td style="vertical-align:top;">
                                        <div class="pagination" style="float: left;padding-top: 0px;margin-top: 0px;">
                                            ${page.pageStr}
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </div>
                </table>
            </form>
            <!-- /.page-content -->
        </div>
    </div>
    <!-- /.main-content -->
    <!-- 返回顶部 -->
    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
    </a>
</div>
<!-- /.main-container -->
<!-- basic scripts -->
<!-- 页面底部js¨ -->
<!-- ace scripts -->
<script src="static/ace/js/ace/ace.js"></script>
<script src="static/ace/js/ace/page.js"></script>
</body>
<script type="text/javascript">
    function nextPage(page) {
        var showCount = $("#showcount").val();
        if (true && document.forms[0]) {
            var url = document.forms[0].getAttribute("action");
            if (url.indexOf('?') > -1) {
                url += "&currentPage=";
            }
            else {
                url += "?currentPage=";
            }
            url = url + page + "&showCount=" + showCount;
            document.forms[0].action = url;
            document.forms[0].submit();
        } else {
            var url = document.location + '';
            if (url.indexOf('?') > -1) {
                if (url.indexOf('currentPage') > -1) {
                    var reg = /currentPage=\d*/g;
                    url = url.replace(reg, 'currentPage=');
                } else {
                    url += "&currentPage=";
                }
            } else {
                url += "?currentPage=";
            }
            url = url + page + "&showCount=" + showCount;
            document.location = url;
        }
    }
    function changeCount(value) {
        if (true && document.forms[0]) {
            var url = document.forms[0].getAttribute("action");
            if (url.indexOf('?') > -1) {
                url += "&currentPage=";
            }
            else {
                url += "?currentPage=";
            }
            url = url + "1&showCount=" + value;
            document.forms[0].action = url;
            document.forms[0].submit();
        } else {
            var url = document.location + '';
            if (url.indexOf('?') > -1) {
                if (url.indexOf('currentPage') > -1) {
                    var reg = /currentPage=\d*/g;
                    url = url.replace(reg, 'currentPage=');
                } else {
                    url += "1&currentPage=";
                }
            } else {
                url += "?currentPage=";
            }
            url = url + "&showCount=" + value;
            document.location = url;
        }
    }
    function toTZ() {
        var toPaggeVlue = document.getElementById("toGoPage").value;
        if (toPaggeVlue == '') {
            document.getElementById("toGoPage").value = 1;
            return;
        }
        if (isNaN(Number(toPaggeVlue))) {
            document.getElementById("toGoPage").value = 1;
            return;
        }
        nextPage(toPaggeVlue);
    }
</script>
</html>

