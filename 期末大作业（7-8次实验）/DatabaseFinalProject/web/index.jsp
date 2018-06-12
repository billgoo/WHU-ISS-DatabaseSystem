<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2016/6/6
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Database Homepage</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css" media="all" />
    <link href='//fonts.googleapis.com/css?family=Raleway:400,100,200,300,500,600,700,800,900' rel='stylesheet' type='text/css'>
  </head>
  <body>
  <!-- main -->
  <div class="main">
    <center><h1>This is the homepage!</h1></center>
    <center><h2>Author:<I>Gu Yan</I></h2></center>
    <center><h2>Student ID:<I>2014302580191</I></h2></center>
    <h2><b>Choose a view:</b></h2>
    <div class="ckeck-bg">
      <div class="checkbox-form">
        <div class="check-left">
          <form>
            <input type="submit" name="homeBranch" value="Branch" onclick="window.location='branch.jsp';return false;">
          </form>
        </div>
        <div class="check-right">
          <form>
            <input type="submit" name="homeStaff" value="Staff" onclick="window.location='staff.jsp';return false;">
          </form>
        </div>
      </div>
    </div>
  </div>
  <!-- //main -->
  </body>
</html>
