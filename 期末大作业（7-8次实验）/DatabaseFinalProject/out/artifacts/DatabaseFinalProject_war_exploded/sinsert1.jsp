<%@ page import="java.sql.*" %>
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
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String url="jdbc:postgresql://localhost:5432/DreamHouse";
        String tableName = request.getParameter("tableName");
        String sql = "select*from "+tableName;
        String partSql = "";
        String[]data;
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException ce){
            out.println(ce.getMessage());
        }

        try{
            conn= DriverManager.getConnection(url,"staff","5678");
            stmt=conn.prepareStatement(sql);
            rs=stmt.executeQuery();
            ResultSetMetaData rsMetaData = rs.getMetaData();
            int numOfColumns = rsMetaData.getColumnCount();//得到表的列数
            data = new String[numOfColumns];
            for(int i = 0;i < numOfColumns;i++){
                data[i] = request.getParameter("column" + String.valueOf(i+1));//关于i有可能有点小问题
            }

            for(int i = 0;i < numOfColumns;i++){
                if(rsMetaData.getColumnTypeName(i + 1).equals("number"))
                    if(i != numOfColumns - 1)
                        partSql += data[i] + ",";
                    else
                        partSql += data[i];
                else if(i != numOfColumns - 1)
                    partSql += data[i]+ ",";
                else
                    partSql += data[i];
            }
            sql = "insert into " + tableName + " values(" + partSql + ")";
            stmt=conn.prepareStatement(sql);
            int b = stmt.executeUpdate();
            if(b!=0)
                out.println("<div><h1>Complete in lines: "+b+"</h1></div>");
            else
                out.println("<div><h1>Failure!</h1></div>");
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