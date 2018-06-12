package servlet;
import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import library.Book;
import library.Librarian;
import library.Member;
import library.Library;
import library.LibraryBook;

/**
 * Class <b>LibrarianCheckinController</b> contains 
 * the servlet controller functionality for processing
 * book check ins by librarians.
 * 
 *
 * @author iCarnegie
 * @version 1.0
 */
public class LibrarianCheckinController extends Controller {

    /**
     * LibrarianCheckinController doPost method.  This is can be called
     * by <b>Controller</b> superclass' doGet() method.
     * @param req HttpServletRequest servlet request object
     * @param res HttpServletResponse servlet response object
     * @throws ServletException
     * @throws IOException
     */
    public void doPost (HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {

	// Get the current HttpSession.
	HttpSession session = req.getSession();
	
	// Get the Librarian bean from the session.
	Librarian librarian = (Librarian) session.getAttribute("librarian");
	if (librarian == null) {
	    // Forward results to the librarian login page.
	    res.sendRedirect(req.getContextPath() + "/librarian.jsp");
	    return;
	}
	
	// Create a book object. 
	Book book = null;
	
	Library library = null;

	// Create a new instance of the Library object.
        try {
	    library = new Library();
	} catch( Exception e ) {
	    sendErrorRedirect(req, res, e);
	    return;
	}

	int bookID;
	try {
	    // Get the bookid parameter.
	    bookID = (req.getParameter("bookID") == null) ? 0 : Integer.parseInt(req.getParameter("bookID"));
	} catch( NumberFormatException nfe) {
	    res.sendRedirect(req.getContextPath() + "/librarianaccess.jsp?checkinBookErrMsg=Book ID must be in integer!");
	    return;
	}

	// Initialize the book object and place it into the session.
	try {
	    book = LibraryBook.getBook(bookID);
	    session.setAttribute( "book", book );
	} catch( Exception e ) {
	    sendErrorRedirect(req, res, e);
	    return;
	}
	
	// If the book is null, it is not in the database.  
	// If not null, check it in.
	if (book != null) {
	    try {
		// Check the book in.
		if (library.checkInBook(bookID)) {
		    res.sendRedirect(req.getContextPath() + "/entrycomplete.jsp?action=checkedin");
		    return;
		} else {
		    res.sendRedirect(req.getContextPath() + "/librarianaccess.jsp");
		    return;
		}
	    } catch (Exception e) {
		// Send the exception to the standard error page.
		sendErrorRedirect(req, res, e);
		return;
	    }
	} else {
	    // This book did not exist.	    
	    // Send the user back to the librarianaccess page.
	    res.sendRedirect(req.getContextPath() + "/librarianaccess.jsp?checkinBookErrMsg=This book is not found in the database!");
	    return;
	}
    }
}





