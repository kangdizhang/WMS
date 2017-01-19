<%--
  Created by IntelliJ IDEA.
  User: 23626
  Date: 2016/11/11
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>


    <script type="text/javascript" src="/static/login/js/jquery-1.5.1.min.js"></script>
</head>
<body>
<div>
    <table border="1px">
        <thead>
        <tr>
            <td>姓名</td>
            <td>性别</td>
            <td>班级</td>
            <td>年龄</td>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>A</td>
            <td>男</td>
            <td>一年1班</td>
            <td>8</td>
        </tr>
        <tr>
            <td>B</td>
            <td>女</td>
            <td>一年1班</td>
            <td>8</td>
        </tr>
        <tr>
            <td>C</td>
            <td>女</td>
            <td>一年1班</td>
            <td>7</td>
        </tr>
        <tr>
            <td>D</td>
            <td>男</td>
            <td>一年1班</td>
            <td>9</td>
        </tr>
        </tbody>
    </table>
</div>
</body>
<script>
    function doRefresh() {
        window.location.reload();
    }
    $(function(){
        var changed  = false;
        $("tbody").sortable({
            opacity: 0.5,//拖动的透明度
            revert: true, //缓冲效果
            cursor: 'move', //拖动的时候鼠标样式
            start:function(event, ui){
                if(navigator.userAgent.toLowerCase().match(/firefox/)&&ui.helper!=undefined){
                    ui.helper.css('position','absolute').css('mergin-top',$(window).scrollTop());
                    //当滚动条滚动时关联事件
                    $(window).bind('scroll.sortableplaylist',function(){
                        ui.helper.css('position','absolute').css('mergin-top',$(window).scrollTop());
                    });
                }
            },
            beforeStop:function(event, ui){
                $(window).bind('scroll.sortableplaylist',function(){
                    ui.helper.css('position','absolute').css('mergin-top',0);
                });
            },
            helper:function(e,ui){//设置拖动时辅助显示帮助
                ui.children().each(function(){
                    $(this).width($(this).width());
                });
                return ui;
            },
            scroller:true,
            change : function(event,ui){
                changed = true;
            },
            stop:function(event,ui){//允许滚动显示
                //在拖动排序停止时可以保存排序
                if(changed){
                    var currObj = ui.item;
                    var currId = currObj.attr("id");
                    var prevId = currObj.prev().attr("id");
                    var nextId = currObj.next().attr("id");
                    if(undefined==prevId){
                        prevId=0;
                    }
                    if(undefined==nextId){
                        nextId=0;
                    }
                    $.post(ROOT_PATH+"questions/question/"+currId+"/order",{prevId:prevId,nextId:nextId},function(data){
                        if(data==1){
                            doRefresh();
                        }
                    });
                }
            }

        }).disableSelection();
    });
</script>
</html>
