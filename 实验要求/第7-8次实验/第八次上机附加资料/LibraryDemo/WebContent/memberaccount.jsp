'<!-- Interface that gives a member access to the library. -->
<%@ page language="java" import="java.net.*, library.*" errorPage="error.jsp" %>
<!-- Use a session scoped bean member.  This bean is null only if a
     member has not logged in.  If the bean is not null,
     then a member must have logged in. -->
<jsp:useBean id="member" scope="session" class="library.Member" />
<!-- Page scoped bean for a common header and footer. -->
<jsp:useBean id="tags" scope="page" class="library.CommonTags" />

<%
  if (member.getSSN() == -1) {
    response.sendRedirect("member.jsp");
    return;
  }
        
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD html 4.0 transitional//EN">

<html>
  <head>
    <meta name="Description" content=
    "iCarnegie.Library: a demonstration online database project.">

    <title>iCarnegie.Library: Member Account Center.</title>
    <link rel="stylesheet" type="text/css" href=
    "styles.css">
  </head>

  <body>
    <!-- Display the common header using a JavaBean. -->   
    <%=tags.getHeader("")%>
    <p><b>ACCOUNT CENTER</b></p>

    <p>
      <!-- Print the member's name. -->
      <b><%=member.getName() %></b>, welcome to your
      iCarnegie.Library account center.
    </p>

    <ul>
      <!-- View borrowed books. -->
      <li>
        View books that you have 

        <ul>
          <li>
            <b>
              <a href="servlet/MemberViewborrowedController">borrowed</a>
            </b>
            or
          </li>
	
	<!-- View books currently on hold. -->
          <li>
            <b>
              <a href="servlet/MemberViewonholdController">placed on hold.</a>
            </b>
          </li>
        </ul>
      </li>
    </ul>
    <br>
    <!-- Display the copyright information from the custom JSP tags. -->
    <%=tags.getFooter()%>
  </body>
</html>

