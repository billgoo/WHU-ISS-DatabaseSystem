<!-- Display that a librarian's action have been completed. -->
<%@ page language="java" import="library.*" %>
<!-- Use two session scoped beans: a book and a librarian.  
     The book stores information about the book that has just 
     been manipulated by the librarian.  The librian bean
     stores whether or not a librarian has logged in. -->
<jsp:useBean id="book" scope="session" class="library.Book" />
<jsp:useBean id="librarian" scope="session" class="library.Librarian" />
<!-- Page scoped bean for a common header and footer. -->
<jsp:useBean id="tags" scope="page" class="library.CommonTags" />

<%
  /**
   * If the librarian's SSN is -1, send the user back to the main
   * librarian page becuase they have not logged in as a 
   * librarian.  
   */
  if (librarian.getSSN() == -1) {
    response.sendRedirect("librarian.jsp");
    return;
  }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD html 4.0 transitional//EN">

<html>
  <head>
    <meta name="Description" content=
    "iCarnegie.Library: a demonstration online database project.">

    <title>iCarnegie.Library: Book <%=book.getCallNumber()%></title>
    <link rel="stylesheet" type="text/css" href=
    "styles.css">
  </head>

  <body>
    <!-- Display the common header using a JavaBean. -->   
    <%=tags.getHeader("")%>

    <p>
      <b>
      <%
        String action = request.getParameter("action");
	// Display the book that has just been manipulated.
        out.println("Book ID: " + book.getBookId() + " (" + book.getCallNumber() + ")");
	// Display the action that has just been performed.
        if (action.equals("checkedout")) {
          out.println(" has been successfully checked out.");
        } else if (action.equals("checkedin")) {
          out.println(" has been successfully checked in.");
        }

	// Set the session attribute book to null.
        session.setAttribute("book", null);
      %>
      </b>
    </p>
    <!-- Display the copyright information from the custom JSP tags. -->
    <%=tags.getFooter()%>
  </body>
</html>

