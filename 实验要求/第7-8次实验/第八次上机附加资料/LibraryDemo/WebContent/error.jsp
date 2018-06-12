<!-- Standard iCarnegie library error page. -->
<%@ page language="java" isErrorPage="true" import="java.io.*, java.util.*, java.sql.*" %>
<!-- Page scoped bean for a common header and footer. -->
<jsp:useBean id="tags" scope="page" class="library.CommonTags" />

<%
  // Get the exception stored in the session.
  exception = (Throwable) session.getAttribute("jspException");

  if (exception == null) {
    response.sendRedirect("index.jsp");
    return;
  }
  // Remove the error from the session.  
  session.removeAttribute("jspException");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD html 4.0 transitional//EN">

<html>
  <head>
    <meta name="Description" content=
    "iCarnegie.Library: a demonstration online database project.">

    <title>iCarnegie.Library: Error Page</title>
    <link rel="stylesheet" type="text/css" href=
    "styles.css">
  </head>

  <body>
    <!-- Display the common header using a JavaBean. -->   
    <%=tags.getHeader("")%>

    <h3>Oops!  An Unexpected Error or Exception has Occurred!</h3>
    <h3>Exception:</h3>
    <!-- Display the exception name. -->
    <%=exception%><br>

    <br>

    <!-- Display the stack trace for debugging. -->
    <h3>Stack Trace:</h3>
    <%
      StackTraceElement[] ste = exception.getStackTrace();

      for (int i = 0; i < ste.length -1; i++) {
        out.println(ste[i] + " at<br>");
      }

      out.println(ste[ste.length - 1] + "<br>");
    %><br>
     <!-- Display the copyright information from the custom JSP tags. -->
    <%=tags.getFooter()%>
  </body>   
</html>
