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
<div class="main_query">
    <hr align="center" width="55%" color="#991111" size="5"/><!--//表单开头红色线-->
    <%
        request.setCharacterEncoding("GBK");
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String url="jdbc:postgresql://localhost:5432/DreamHouse";
        String tableName = request.getParameter("simQueryName");
        String sql = "select*from "+tableName;

        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException ce){
            out.println(ce.getMessage());
        }

        try{
            conn= DriverManager.getConnection(url,"staff","5678");
            stmt=conn.prepareStatement(sql);
            rs=stmt.executeQuery();

            int m = 1;
            ResultSetMetaData rsMetaData = rs.getMetaData();
            int numOfColumns = rsMetaData.getColumnCount();//得到表的列数

            out.print("<center><TABLE BORDER='1' cellspacing='2' align=center width='600'>");
            for(int i = 0;i < numOfColumns;i++){
                String rsMD = rsMetaData.getColumnName(i + 1);
                if(0 == i)
                    out.print("<TR><TD><b>"+rsMD+"</b></TD>");
                else if(numOfColumns - 1 == i)
                    out.print("<TD><b>"+rsMD+"</b></TD></TR>");
                else
                    out.print("<TD><b>"+rsMD+"</b></TD>");
            }
            while(rs.next()){
                for(int j = 0;j < numOfColumns;j++){
                    if(0 == j)
                        out.print("<TR><TD>"+rs.getString(j + 1)+"</TD>");
                    else if(numOfColumns - 1 == j)
                        out.print("<TD>"+rs.getString(j + 1)+"</TD></TR>");
                    else
                        out.print("<TD>"+rs.getString(j + 1)+"</TD>");
                }
            }
            out.print("</TABLE></center>");
            out.print("<div class=\"ckeck-bg\">\n" +
                    "        <div class=\"checkbox-form\">\n" +
                    "            <div class=\"check-left\">\n" +
                    "                <form>\n" +
                    "                    <input type=\"submit\" name=\"bwback\" value=\"Back\" onclick=\"window.location='sWelcome.jsp';return false;\">\n" +
                    "                </form>\n" +
                    "            </div>\n" +
                    "            <div class=\"check-right\">\n" +
                    "                <form>\n" +
                    "                    <input type=\"submit\" name=\"bwhome\" value=\"Home\" onclick=\"window.location='staff.jsp';return false;\">\n" +
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
