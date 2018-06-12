<%@ page language="java" import="library.*" errorPage="error.jsp" %>

<!-- Page scoped bean for a common header and footer. -->
<jsp:useBean id="tags" scope="page" class="library.CommonTags" />

<!DOCTYPE html PUBLIC "-//W3C//DTD html 4.0 transitional//EN">

<html>
  <head>
    <meta name="Description" content=
    "iCarnegie.Library: a demonstration online database project.">

    <title>iCarnegie.Library: a demonstration online database
    project.</title>
    <link rel="stylesheet" type="text/css" href=
    "styles.css">
  </head>

  <body>
    <!-- Display the common header using a JavaBean, omit the search link. -->   
    <%=tags.getHeader("OMIT_SEARCH")%>

    <form action="servlet/SearchController" method="post">
      <input type="hidden" name="action" value="search"> 

      <table cellpadding="10" cellspacing="0" border="0">
        <tr>
          <td align="left" valign="top">
            <b>Search by :</b>

            <select name="searchby" size="1">
              <option value="author">
                Author
              </option>

              <option value="title">
                Title
              </option>
            </select>
          </td>

          <td align="left" valign="top">
            <input type="text" name="str" value="" size="20" maxlength="120">
            <input type="image" src="images/b_ok.gif" border="0" name="OK" id="OK">
          </td>
        </tr>
      </table>
    </form>
   <%=tags.getFooter()%>
  </body>
</html>

