<!-- This page displays all details about a book.  -->
<%@ page language="java" errorPage="error.jsp" %>
<!-- This page uses two page-scoped beans: a BookTitle and a Book. -->
<jsp:useBean id="title" scope="page" class="library.BookTitle" /> 
<jsp:useBean id="book" scope="page" class="library.Book" /> 
<jsp:useBean id="bookset" scope="page" class="library.BookSet" />
<!-- Page scoped bean for a common header and footer. -->
<jsp:useBean id="tags" scope="page" class="library.CommonTags" />

<!DOCTYPE html PUBLIC "-//W3C//DTD html 4.0 transitional//EN">

<html>
  <head>
    <meta name="Description" content="iCarnegie.Library: a demonstration online database project.">

    <title>iCarnegie.Library: Book Details</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
  </head>

  <body>
    <!-- Display the common header using a JavaBean. -->   
    <%=tags.getHeader("")%>
    <p><b>Book Details</b></p>

    <ul>
      <%
        /**
	 * Get the callnumber (cn) parameter from the URL
	 * and set the BookTitle bean based on this callnumber.
	 */
        String cn = request.getParameter("cn");
        title = library.LibraryBookTitle.getBookTitle(cn);
      %>

      <!-- Display the book details as an invisible (border=0) table.
	   Each of the pieces of information about the books are
	   obtained from the title.getAttribute() methods. -->	
      <li style="list-style: none">
        <table border="0" cellpadding="5" cellspacing="1">
          <tr>
            <td align="right" valign="top" class="inverted">
              <i>Call Number:</i>
            </td>
	    <!-- Display the callnumber. -->
            <td align="left" valign="top">
              <%=title.getCallNumber()%>
            </td>
          </tr>

          <tr>
            <td align="right" valign="top" class="inverted">
              <i>Title:</i>
            </td>
	    <!-- Display the title. -->
            <td align="left" valign="top">
              <%=title.getName()%>
            </td>
          </tr>

          <tr>
            <td align="right" valign="top" class="inverted">
              <i>Publisher:</i>
            </td>
	    <!-- Display the publisher. -->
            <td align="left" valign="top">
              <%=title.getPublisher() %>, <%=title.getYear() %>
            </td>
          </tr>
          
	  <!-- If there is an edition stored in the db, list it also. -->
          <% if (!(title.getEdition().equals(""))) { %>

          <tr>
            <td align="right" valign="top" class="inverted">
              <i>Edition:</i>
            </td>

            <td align="left" valign="top">
              <%=title.getEdition() %>, <%=title.getYear() %>
            </td>
          </tr>

          <% } %>

	  <!-- Display the current status of the different copies
               of this title. -->
          <tr>
            <td colspan="2" align="center" valign="bottom" class="inverted">
              <b>Status</b>
            </td>
          </tr>

          <%
            boolean oneCopyAvailable = false;
            int counter = 0;
            boolean held = library.LibraryBookTitle.isTitleHeld(cn);

            bookset = library.LibraryBookTitle.getTitleCopies(cn);	  
	    int count = bookset.getBookCount();
	    for( int i=0; i<count; i++ )
               {%>
           <tr><td align=left valign=top colspan=2><i>Copy <%=(i+1)%> </i>
		<%
              if (library.LibraryBook.isCheckedOut(bookset.getBookAt(i).getBookId())) {
                out.println(" Checked out. <i>Due on:</i> " + bookset.getBookAt(i).getDueDate());                
              } else {
                oneCopyAvailable = true;
                out.println(" Available.");

                if (held) {
                  out.println(" On Hold.");
                }
              }

              out.println("</td></tr>");
            }
	 %>
        </table>
      </li>
    </ul>
    <!-- Display the copyright information from the custom JSP tags. -->
    <%=tags.getFooter()%>
  </body>
</html>









