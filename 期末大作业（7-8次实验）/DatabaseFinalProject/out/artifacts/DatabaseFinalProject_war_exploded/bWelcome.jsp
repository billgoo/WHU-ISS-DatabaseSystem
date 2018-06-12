<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2016/6/8
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Branch Homepage</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css" media="all" />
    <link href='//fonts.googleapis.com/css?family=Raleway:400,100,200,300,500,600,700,800,900' rel='stylesheet' type='text/css'>
</head>
<body>
<!-- main -->
<div class="main">
    <div>
    <form id="f1" name="f1" method="post" action="binsert.jsp">
        <h3>Insert: please input the table name</h3>
        <br/>
        <input type="text" name="insertName">
        <br/>
        <br/>
        <input type="submit" value="Insert" />
    </form>
    <br/>
    <form id="f2" name="f2" method="post" action="bdelete.jsp">
        <h3>Delete: please input the table name and the condition</h3>
        <br/>
        <input type="text" name="deleteName">
        <input type="text" name="deleteCondition">
        <br/>
        <br/>
        <input type="submit" value="Delete"/>
    </form>
    <br/>
    <form id="f4" name="f4" method="post" action="bupdate.jsp">
        <h3>Update: please input the table name and the condition</h3>
        <br/>
        <input type="text" name="updateName">
        <input type="text" name="updateValue">
        <input type="text" name="updateCondition">
        <br/>
        <br/>
        <input type="submit" value="Update"/>
    </form>
    <br/>
    <form id="f3" name="f3" method="post" action="bquery.jsp">
        <h3>Select: please input the table name</h3>
        <br/>
        <input type="text" name="simQueryName">
        <br/>
        <br/>
        <input type="submit" value="Query"/>
    </form>
    </div>
    <div class="ckeck-bg">
        <div class="checkbox-form">
            <div class="check-left">
                <form>
                    <input type="submit" name="bwback" value="Back" onclick="window.location='branch.jsp';return false;">
                </form>
            </div>
            <div class="check-right">
                <form>
                    <input type="submit" name="bwhome" value="Home" onclick="window.location='index.jsp';return false;">
                </form>
            </div>
        </div>
    </div>
</div>
<!-- //main -->
</body>
</html>
