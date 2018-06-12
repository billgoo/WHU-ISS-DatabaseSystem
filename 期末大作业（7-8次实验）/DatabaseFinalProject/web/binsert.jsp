<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2016/6/8
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DreamHouse DBMA</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
    <link href='//fonts.googleapis.com/css?family=Raleway:400,100,200,300,500,600,700,800,900' rel='stylesheet' type='text/css'>
</head>
<body>
<!-- main -->
<div class="main">
    <hr align="center" width="55%" color="#991111" size="5"/><!--//表单开头红色线-->
    <%
        request.setCharacterEncoding("GBK");
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String url="jdbc:postgresql://localhost:5432/DreamHouse";
        String tableName = request.getParameter("insertName");
        String sql = "select*from "+tableName;

        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException ce){
            out.println(ce.getMessage());
        }

        try{
            conn= DriverManager.getConnection(url,"branch","1234");
            stmt=conn.prepareStatement(sql);
            rs=stmt.executeQuery();
            int m = 1;
            ResultSetMetaData rsMetaData = rs.getMetaData();
            int numOfColumns = rsMetaData.getColumnCount();//得到表的列数
            out.print("<div>");
            out.print(" <form id='insertForm' name='insertForm' method='post' action='binsert1.jsp'> ");
            out.print("<h3>Table Name:</h3>");
            out.print("<br/>");
            out.print("<input type='text' name=tableName" + " value=" + tableName +">");
            out.print("<br/>");
            out.print("<br/>");
            out.print("<h3>Please input each item you want to insert:</h3><br/>");
            for(int i = 0;i < numOfColumns;i++){
                String temp = "column" + String.valueOf(i+1);
                out.print(rsMetaData.getColumnName(i + 1)+":\t");
                out.print("<input type='text' name=" +temp+">");
                out.print("<br/>");
                out.print("<br/>");
            }
            out.print("<input type='submit' value='Insert'/>");
            out.print("</form>");
            out.print("</div>");
            out.print("<div class=\"ckeck-bg\">\n" +
                    "        <div class=\"checkbox-form\">\n" +
                    "            <div class=\"check-left\">\n" +
                    "                <form>\n" +
                    "                    <input type=\"submit\" name=\"bwback\" value=\"Back\" onclick=\"window.location='bWelcome.jsp';return false;\">\n" +
                    "                </form>\n" +
                    "            </div>\n" +
                    "            <div class=\"check-right\">\n" +
                    "                <form>\n" +
                    "                    <input type=\"submit\" name=\"bwhome\" value=\"Home\" onclick=\"window.location='branch.jsp';return false;\">\n" +
                    "                </form>\n" +
                    "            </div>\n" +
                    "        </div>\n" +
                    "    </div>");
            rs.close();
            stmt.close();
            conn.close();
        }catch(Exception e){
            out.println(e.getMessage());
        }
    %>
</div>
<!-- //main -->
</body>
</html>
