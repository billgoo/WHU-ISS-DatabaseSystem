<!-- Member login page. -->
<%@ page language="java" import="library.*" errorPage="error.jsp" %>
<!-- Page scoped bean for a common header and footer. -->
<jsp:useBean id="tags" scope="page" class="library.CommonTags" />

<%
  // Get an error messages in the request object.
  String errMsg = (request.getParameter("errMsg") == null)
                ? ""
                : request.getParameter("errMsg");
  String uname = (request.getParameter("uname") == null)
                ? ""
                : request.getParameter("uname");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD html 4.0 transitional//EN">

<html>
  <head>
    <meta name="Description" content=
    "iCarnegie.Library: a demonstration online database project.">

    <title>iCarnegie.Library: Member Login.</title>
    <link rel="stylesheet" type="text/css" href=
    "styles.css">
  </head>

  <body>
    <!-- Display the common header using a JavaBean with member link omitted. -->
    <%=tags.getHeader("OMIT_MEMBER")%>

    <p><b>MEMBER LOGIN</b></p>

    <div style="margin-left: 2em">
      <form action="servlet/MemberLoginController" method="post">
        <table border="0" cellpadding="5" cellspacing="0">
          <tr>
            <td align="left" valign="top" class="inverted">
              <b>ENTER ID and PASSWORD</b>
            </td>
          </tr>

          <tr>
            <td align="left" valign="top">

              <b class="smaller">Member ID</b><br>

              <input type="text" name="uname" maxlength="50" size="20" value=<%=uname%>>
              <b class="error"><%=errMsg%></b><br>

              <b class="smaller">Password</b><br>

              <input type="password" name="passwd" maxlength="20" size="20">
            </td>
          </tr>

          <tr>
            <td align="center" valign="top" class="inverted">
              <input type="submit" value="Login" name="login">
            </td>
          </tr>
        </table>
      </form>
    </div><br>
    <!-- Display the copyright information from the custom JSP tags. -->
    <%=tags.getFooter()%>
  </body>
</html>
