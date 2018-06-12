<!-- View books that a member has on hold. -->
<%@ page language="java" import="java.net.*, library.*"  %>
<!-- Use two session scoped beans, one representing a book on hold
     and another representing a memebr. Also use a page 
     scoped bean to display book title information. -->
<jsp:useBean id="title" scope="page" class="library.BookTitle" />
<jsp:useBean id="hold" scope="session" class="library.Hold" />
<jsp:useBean id="titleset" scope="session" class="library.BookTitleSet" />
<jsp:useBean id="member" scope="session" class="library.Member" />
<!-- Page scoped bean for a common header and footer. -->
<jsp:useBean id="tags" scope="page" class="library.CommonTags" />

<%
  // Has the user logged in?
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
        <a href="servlet/MemberViewborrowedController">
          View books you currently have borrowed.
        </a>
      </b><br>

      <br>

      <b><i>Books you have held.</i></b> 
      <% titleset = (BookTitleSet) session.getAttribute( "books" );
	if (titleset.getBookTitleCount() == 0) { %>
    </p>

    <div style="margin-left: 2em">
      <b>There are no books on hold for you.</b>
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
	<!-- Display the book title information. -->
        <%
          int counter = 0;

	  for( int i=0; i<titleset.getBookTitleCount(); i++ ){
         %>
         <tr>
           <td align="right" valign="top" class="smaller">
             "<%=(i+1)%>"
           </td>

           <td align="left" valign="top" class="smaller">
             <%=titleset.getBookTitleAt(i).getCallNumber()%>
           </td>

           <% title=titleset.getBookTitleAt(i); %>

           <td align="left" valign="top" class="smaller">
             <%=title.getName()%>
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
