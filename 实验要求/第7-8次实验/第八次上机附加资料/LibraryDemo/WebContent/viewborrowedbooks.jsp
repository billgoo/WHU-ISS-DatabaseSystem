<!-- Allow a member to view borrowed books. -->
<%@ page language="java" import="library.*" errorPage="error.jsp" %>
<!-- Use two session scoped beans, one representing a book
     and another representing a memebr. Also use a page 
     scoped bean to display book title information. -->
<jsp:useBean id="member" scope="session" class="library.Member" />
<jsp:useBean id="bookset" scope="page" class="library.BookSet" />
<jsp:useBean id="book" scope="page" class="library.Book" />
<jsp:useBean id="title" scope="page" class="library.BookTitle" />
<!-- Page scoped bean for a common header and footer. -->
<jsp:useBean id="tags" scope="page" class="library.CommonTags" />

<%
  // If SSN is -1, then the member must log in.
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

    <title>iCarnegie.Library: Member Account Center - Book Status</title>
    <link rel="stylesheet" type="text/css" href=
    "styles.css">
  </head>

  <body> 
    <!-- Display the common header using a JavaBean. -->   
    <%=tags.getHeader("")%> 

    <p><b>ACCOUNT CENTER</b></p>
   
    <p>
      <b>
        <a href="servlet/MemberViewonholdController">
          View books you have placed on hold.
        </a>
      </b><br>

      <br>
      <!-- View the books this member has on hold. -->   
      <b><i>Books you have borrowed.</i></b> 
	<% bookset = (BookSet) session.getAttribute( "checkedoutBooks" );
      if (bookset.getBookCount() == 0) { %>
    </p>

    <div style="margin-left: 2em">
      <b>There are no books on loan to you.</b>
    </div>

    <p>
      <% } else { %>
    </p>

    <div style="margin-left: 2em; width: 600;">

    <table border="0" cellpadding="5" cellspacing="1" width="90%">
      <tr>
        <td align="right" valign="top"><br></td>

        <td align="left" valign="top">
          <b class="smaller">CALL NUMBER</b>
        </td>

        <td align="left" valign="top">
          <b class="smaller">TITLE</b>
        </td>

        <td align="left" valign="top"><br></td>
      </tr>
      <!-- Display attributes of the book. -->
      <%
        int counter = 0;
        
	for( int i=0; i<bookset.getBookCount(); i++ ){
      %>
        <tr>
          <td align="right" valign="top" class="smaller"><%=(i+1)%></td>

          <td align="left" valign="top" class="smaller">
            <%=bookset.getBookAt(i).getCallNumber()%>
          </td>

          <% title = LibraryBookTitle.getBookTitle( bookset.getBookAt(i).getCallNumber()); %>

          <td align="left" valign="top" class="smaller"><%=title.getName()%></td>

          <td align="left" valign="top" class="smaller">
             <b>Due:</b> <%=bookset.getBookAt(i).getDueDate()%>
          </td>
        </tr>
      <% }
      out.println("</table>");
    } %>

      <br>
    </div>
    <!-- Display the copyright information from the custom JSP tags. -->
    <%=tags.getFooter()%>
  </body>
</html>

