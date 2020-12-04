<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/10
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        var ws =null; //该变量，用于保存建立好的连接管道
        var target = "ws://localhost:7777/chat";//指定要连接的socket服务地址

        //连接的方法
        function conn() {

            //连接指定服务的地址，得到创建好的连接管道（在连接的时候，要判断，当前浏览器是否支持websocket）
            if ('WebSocket' in window) {
                ws = new WebSocket(target);
            } else if ('MozWebSocket' in window) {
                ws = new MozWebSocket(target);
            } else {
                alert("你的浏览器，不支持websocket");
                return;
            }

            //该函数，是当连接创建成功时，回调的方法
            ws.onopen = function () {
                alert("连接管道，创建成功!");
            };

            //该函数，是当服务器端推送消息时，客户端接收消息时，回调的方法
            ws.onmessage = function (event) {

                alert(event.data); //event.data，即可获得服务端返回的数据
            };

        }

        //发送消息的方法
        function send() {

            //取得消息内容
            var val = document.getElementById("msg").value;

            //通过管道，向服务器发送消息
            ws.send(val);
        }

    </script>
</head>
<body>
消息：<input type="text" size="50px" id="msg"/><br>

<BR>

<input type="button" value="连接服务器" onclick="conn()">

<input type="button" value="发送消息" onclick="send()">

</body>
</html>
