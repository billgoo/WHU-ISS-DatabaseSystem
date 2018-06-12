<%@ page import="java.sql.*" %>
<%@ page import="finalProject.DatabaseConnect" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2016/6/7
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login in</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css" media="all" />
    <link href='//fonts.googleapis.com/css?family=Raleway:400,100,200,300,500,600,700,800,900' rel='stylesheet' type='text/css'>
</head>
<body>
<!-- main -->
<div class="main">
    <h1>Welcome to the Branch View!</h1>
    <%
        try{
            Class.forName("org.postgresql.Driver").newInstance();
            String url ="jdbc:postgresql://localhost:5432/DreamHouse";
            Connection conn= DriverManager.getConnection(url,"branch", "1234");
    %>
    <div class="ckeck-bg">
        <div class="checkbox-form">
            <div class="check-left">
                <form>
                    <input type="submit" name="bwback" value="Back" onclick="window.location='index.jsp';return false;">
                </form>
            </div>
            <div class="check-right">
                <form>
                    <input type="submit" name="bwhome" value="Next" onclick="window.location='bWelcome.jsp';return false;">
                </form>
            </div>
        </div>
    </div>
</div>
<!-- //main -->
</body>
<%
        conn.close();
    }catch(ClassNotFoundException cnfe){
        out.print(cnfe);
    }catch(SQLException sqle){
        out.print(sqle);
    }catch(Exception e){
        out.print(e);
    }
%>
</html>
