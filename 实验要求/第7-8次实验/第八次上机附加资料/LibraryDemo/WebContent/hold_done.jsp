<!-- Let the user know that the hold has been placed. -->
<%@ page language="java" import="java.net.*, library.*" errorPage="error.jsp" %>
<!-- Use the session scoped member bean.  This bean is set when a user logs in. -->
<jsp:useBean id="member" scope="session" class="library.Member" />
<!-- Page scoped bean for a common header and footer. -->
<jsp:useBean id="tags" scope="page" class="library.CommonTags" />

<%
  // If ssn is -1, send the user back to the initial member's page.
  if (member.getSSN() == -1) {
    response.sendRedirect("member.jsp");
    return;
  }

  // Get the callnumber (cn) parameter.
  String cn = request.getParameter("cn");
  int ok = (request.getParameter("ok") == null) ? 0
         : Integer.parseInt(request.getParameter("ok"));     
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD html 4.0 transitional//EN">

<html>
  <head>
    <meta name="Description" content=
    "iCarnegie.Library: a demonstration online database project.">

    <title>iCarnegie.Library: Hold book with call number <%=cn%></title>
    <link rel="stylesheet" type="text/css" href=
    "styles.css">
  </head>

  <body>
    <!-- Display the common header using a JavaBean. -->   
    <%=tags.getHeader("")%>

    <p>
      <% if (ok==1) { %>
        <b>Thank you!</b></p>
	<!-- Display the callnumber that has been placed on hold. -->
        <p>
          The book with call number "<%=cn%>" has been
          successfully placed on hold. 
        </p>
      <% } else { %>
        <p><b>Sorry!</b></p>
	<!-- Display an error message. -->
        <p>
          The book with call number "<%=cn%>" cannot be placed
          on hold for one of the following reasons:<br>
        </p>

        <ul>
          <li>You currently have a copy of that book, or</li>
          <li>You currently have it on hold.</li>
        </ul>
      <% } %>
    </p>
    <!-- Display the copyright information from the custom JSP tags. -->
    <%=tags.getFooter()%>
  </body>
</html>

