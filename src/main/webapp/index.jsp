<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h2>Hello World!</h2>

<script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
    $(function(){
        $("#testJson").click(function(){
            var url = this.href;
            var args = {"name":"yz","sex":"男","email":"357823669@qq"};
            $.ajax({ url: url,contentType:"application/json",method:"POST", data:args,success: function(){
                    alert(data);
                }});
            return false;
        });
    })
</script>

<a href="/myController/toSuccess.do">toSuccess</a><br>
<a href="/myController/testMethod/1">testMethodGet</a><br>
<form action="myController/testMethod/1" method="post">
    <%--<input name="id" />--%>
    <input type="submit" value="TestRest POST"/>
</form>

<br>

<form action="myController/testMethod/3" method="post">
    <input type="hidden" name="_method" value="DELETE"/>
    <input type="submit" value="TestRest DELETE"/>
</form>

<br>
<form action="myController/testMethod/2" method="post">
    <input type="hidden" name="_method" value="PUT"/>
    <input type="submit" value="TestRest PUT"/>
</form>

<br>

<a href="/myController/testRequestParam?name=yz&sex=boy">testRequestParam</a><br>
<a href="/myController/testPoJo?name=yz&sex=boy&email=123">testPoJo</a><br>
<a href="/myController/testRedirect">testRedirect</a><br>
<a href="/myController/testForward">testForward</a><br>

<a href="/myController/testCoversionService?param=yz,boy,123">testCoversionService</a><br>

<a href="/myController/testMessageCover">testMessageCover</a><br>

<a href="/myController/testMessageCover" id="testJson">testMessageCoverRequest</a><br>


<form action="/myController/testFileUpload" method="POST" enctype="multipart/form-data">
    File: <input type="file" name="file"/>
    Desc: <input type="text" name="desc"/>
    <input type="submit" value="Submit"/>
</form>


<a href="/myController/testSpring" >testSpring</a><br>
</body>
</html>
