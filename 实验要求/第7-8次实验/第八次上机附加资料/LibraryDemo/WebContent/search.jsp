<!-- Interface for displaying search results. -->
<%@ page language="java" import="library.*, java.sql.*, java.io.*, java.util.*, java.net.*" %>
<!-- Session scoped results vector stores the results of the search.  This
     is set by the search controller servlet. -->
<jsp:useBean id="results" scope="session" class="library.BookTitleSet" />
<jsp:useBean id="title" scope="session" class="library.BookTitle" />
<!-- Page scoped bean for a common header and footer. -->
<jsp:useBean id="tags" scope="page" class="library.CommonTags" />

<!DOCTYPE html PUBLIC "-//W3C//DTD html 4.0 transitional//EN">

<html>
  <head>
    <meta name="Description" content=
    "iCarnegie.Library: a demonstration online database project.">

    <title>iCarnegie.Library: Search Results</title>
    <link rel="stylesheet" type="text/css" href=
    "styles.css">
  </head>

  <body>
    <!-- Display the common header using a JavaBean. -->   
    <%=tags.getHeader("")%>
    <div style="width: 600">
      <p>
        <b>Search Results ...</b>
        <%
  	  // Display what type of seach we have done.
          String str = request.getParameter("str");
          String searchby = request.getParameter("searchby");
          int start = Integer.parseInt(request.getParameter("start"));
          out.println("<i>for " + searchby + " includes '" + str + "'</i>");
        %>
        <br>

        <%
          if (results.getBookTitleCount() == 0) {
            out.println("<p><blockquote><b>Sorry! No books were found!</b></blockquote>");
          } else { 
            if (results.getBookTitleCount() == 1) {
               out.println(results.getBookTitleCount() + " book found");
            } else {
              out.println(results.getBookTitleCount() + " books found");
            }
        %>
      </p>
	
      <!-- Display the search results one book at a time. -->
      <div style="margin-left: 2em">
        <dl>
          <dd>
            <p>
              <% 
                for (int i=start; i < (start + 10) && (i < results.getBookTitleCount()); i++) {
                  BookTitle result = results.getBookTitleAt(i);
		  String escaped = URLEncoder.encode(result.getCallNumber(), "UTF-8");
              %>
            </p>
          </dd>

          <dt>
            <b>
              <a href="bookdetails.jsp?cn=<%=escaped%>"><%=result.getName()%></a>
            </b><br>

          </dt>
          <!-- Display the information about a book. -->
          <dd>
            <b class="smaller">Author:</b>
            <%=result.getAuthors()%><br>

            <b class="smaller">Call Number:</b>
            <%=result.getCallNumber()%><br>

            <b class="smaller">Published:</b>
            <%=result.getYear()%><br>

            <% if (!result.getEdition().equals("")) { %>
              <b class="smaller">Edition:</b>
              <% out.println(result.getEdition() + "<br>");
               }
            %>

            <hr size="1" noshade>

            <% } %>
          </dd>
        </dl>

        <%
          // Do we need to show a 'Previous 10' link?
          if (start > 0) {
            String encurl = response.encodeRedirectURL("search.jsp?start=" 
                          + (start - 10) + "&searchby=" + searchby 
                          + "&str=" + str);
        %>
          <a href="<%=encurl%>">&lt;&lt; Previous10</a>
        <% } else { %>
          <font color="gray">&lt;&lt; Previous 10 </font>
        <%
           }

           // Do we need to show a 'Next 10' link?
           if (start + 10 < results.getBookTitleCount()) {
             int num = results.getBookTitleCount() - (start + 10);

             if (num > 10) {
               num = 10;
             }

             String encurl = response.encodeRedirectURL("search.jsp?start=" 
                           + (start + 10) + "&searchby=" + searchby + "&str=" + str);
           %>
             <a href="<%=encurl%>">Next <%=num%> &gt;&gt;</a> 
           <% } else { %>
             <font color="gray">Next 10 &gt;&gt;</font>
           <%
              }
            }
        %>
      </div>
    </div>
    <!-- Display the copyright information from the custom JSP tags. -->
    <%=tags.getFooter()%>
  </body>
</html>
