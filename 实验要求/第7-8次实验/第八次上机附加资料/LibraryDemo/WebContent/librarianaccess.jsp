<!-- Page to allow the librarian access to the library system. -->
<%@ page language="java" import="library.*"  %>
<!-- Use three beans.  Two session scoped beans, book and
     librarian.  Also use a page scoped bean named allbooks. -->
<jsp:useBean id="book" scope="session" class="library.Book" />
<jsp:useBean id="allbooks" scope="page" class="library.BookSet" />
<jsp:useBean id="librarian" scope="session" class="library.Librarian" />
<jsp:useBean id="library" scope="page" class="library.Library" />
<!-- Page scoped bean for a common header and footer. -->
<jsp:useBean id="tags" scope="page" class="library.CommonTags" />

<%
  /**
   * If the librarian SSN is -1, send the user back to the
   * librarian log in page.  This prevents a user
   * from accessing librarian functions when a 
   * librarian is not logged in.
   */
  if (librarian.getSSN() == -1) {
    response.sendRedirect("librarian.jsp");
    return;
  }
        
  // See if the ssn of the librarian is present.
  String ssn = (request.getParameter("ssn") == null) ? "" 
             : request.getParameter("ssn");

  // Get an error messages in the request object.
  String checkoutBookErrMsg = (request.getParameter("checkoutBookErrMsg") == null)
                ? ""
                : request.getParameter("checkoutBookErrMsg");
  String checkoutMemberErrMsg = (request.getParameter("checkoutMemberErrMsg") == null)
                ? ""
                : request.getParameter("checkoutMemberErrMsg");
  String checkinBookErrMsg = (request.getParameter("checkinBookErrMsg") == null)
                ? ""
                : request.getParameter("checkinBookErrMsg");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD html 4.0 transitional//EN">

<html>
  <head>
    <meta name="Description" content=
    "iCarnegie.Library: a demonstration online database project.">

    <title>iCarnegie.Library: Librarian Access.</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
  </head>

  <body>
    <!-- Display the common header using a JavaBean. -->   
    <%=tags.getHeader("")%>

    <p><b>LIBRARIAN ACCESS</b></p>

    <!-- Print the librarian's name. -->
    <p>Hi <b><%=librarian.getName()%></b>!</p>

    <div style="margin-left: 2em">
      <u>Checkout Book</u><br>

      <!-- Display a form that allows a librarian to send books to the
	   LibrarianCheckoutController servlet to be checked out. -->	
      <form action="servlet/LibrarianCheckoutController" method="post">

        Book ID<b><sup><a href="#bookID">*</a></sup></b>:<br>

        <b class="error"><%=checkoutBookErrMsg%></b><br>

        <input type="text" name="bookID" value="<%=book.getBookId()%>"
        maxlength="3" size="4"> 

	<!-- Get the member's ID number. -->
        <p>Member ID:<br>

        <b class="error"><%=checkoutMemberErrMsg%></b><br>

        <input type="text" name="ssn" value="<%=ssn%>"
        maxlength="50" size="20">
        <input type="submit" value="OK"></p>
      </form><br>

      <hr size="1" noshade align="left" width="200">
      <br>
      <u>Return Book</u> 

	<!-- Display a form that allows a librarian to send books to the
	   LibrarianCheckinController servlet to be checked in. -->	
      <form action="servlet/LibrarianCheckinController" method="post">

        Book ID<b><sup><a href="#bookID">*</a></sup></b>:<br>

        <b class="error"><%=checkinBookErrMsg%></b><br>

        <input type="text" name="bookID" value="<%=book.getBookId()%>"
        maxlength="3" size="4">
        <input type="submit" value="OK">
      </form>
    </div>

    <hr size="1" noshade align="left" width="550">

    <a name="bookID"></a>
    <div style="width: 600">
      <b class="smaller" style="color: #990000">*</b>
      Book IDs: This section of the system requires the librarian to
      scan the book so as to retrieve its ID number. For demonstration
      purposes we list all the book IDs below with their corresponding
      call numbers:</font>
    
    <br>
    <table border="1">	
    <tr><td>ID</td><td>Call Number</td></tr>
    <%
         // Get all of the books in the library and display them.
	allbooks = library.getBooks();
	for( int i = 0; i<allbooks.getBookCount(); i++ ){%>
	  <tr><td><%=allbooks.getBookAt(i).getBookId()%></td><td><%=allbooks.getBookAt(i).getCallNumber()%></td></tr>
     <%}%>
</table>
      </div>
    <!-- Display the copyright information from the custom JSP tags. -->
    <%=tags.getFooter()%>
  </body>
</html>

