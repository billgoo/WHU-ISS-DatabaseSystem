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
import library.LibraryBook;
import library.LibraryMember;
import library.Library;

/**
 * Class <b>LibrarianCheckoutController</b> contains 
 * the servlet controller functionality for processing
 * book checkouts by librarians.
 * 
 *
 * @author iCarnegie
 * @version 1.0
 */
public class LibrarianCheckoutController extends Controller {

    /**
     * LibrarianCheckoutController doPost method.  This is can be called
     * by <b>Controller</b> superclass' doGet() method.
     * @param req HttpServletRequest servlet request object
     * @param res HttpServletResponse servlet response object
     * @throws ServletException
     * @throws IOException
     */
    public void doPost (HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {

	// Get the session.
	HttpSession session = req.getSession();
	
	// Get the librarian bean from the session.
	Librarian librarian = (Librarian) session.getAttribute("librarian");

	if (librarian == null) {
	    // Forward results to the librarian login page.
	    res.sendRedirect(req.getContextPath() + "/librarian.jsp");
	    return;
	}

	// Get the book bean from the session.
	Book book = null;
	
	// Get the bookid parameter
	int bookID;
	try {
	    bookID = (req.getParameter("bookID") == null) ? -1 : Integer.parseInt(req.getParameter("bookID"));
	} catch( NumberFormatException nfe) {
	    res.sendRedirect(req.getContextPath() + "/librarianaccess.jsp?checkoutBookErrMsg=Book ID must be an integer!");
	    return;
	}

	
	// Initialize the book object. 
	try {
	    book = LibraryBook.getBook(bookID);
	} catch( Exception e ) {
	    sendErrorRedirect(req, res, e);
	    return;
	}
	//Create a new instance of the library object.  
	Library library = null;

	// Create a new instance of the Library object.
        try {
	    library = new Library();
	} catch( Exception e ) {
	    sendErrorRedirect(req, res, e);
	    return;
	}

	int ssn;
	try {
	    // Get the member ssn parameter.
	    ssn = (req.getParameter("ssn") == null) ? -1 : Integer.parseInt(req.getParameter("ssn"));
	} catch( NumberFormatException nfe) {
	    res.sendRedirect(req.getContextPath() + "/librarianaccess.jsp?checkoutMemberErrMsg=Member ID must be in integer!");
	    return;
	}

	// Get the member's ssn.

	// Create a new member object with the ssn.
	Member member = null;
	try {
	    member = LibraryMember.getMember( ssn );
	} catch( Exception e ){
	    sendErrorRedirect(req, res, e);
	    return;
	}	
	
	// Create a get parameter version of the ssn.
	String pssn = (ssn == -1) ? "" : "?ssn=" + ssn;
	
	// Set the book object to the specified book.
	// If the book or member is null, throw an error.
	// Check the book out otherwise.
	if (book != null) {
	    if (member != null) {
		try {
		    // Check out.
		    if ( library.checkOutBook(bookID, ssn, librarian )) {
			// Set the book attribute into the session.
			session.setAttribute( "book", book );			  
			res.sendRedirect(req.getContextPath() + "/entrycomplete.jsp?action=checkedout");
			return;
		    } else {
			// If the checkout fails, let the user know.
			res.sendRedirect(req.getContextPath() + "/librarianaccess.jsp?checkoutBookErrMsg=This book is already checked out!");
			return;
		    }
		} catch (Exception e) {
		    // Send the exception to the standard error page.
		    sendErrorRedirect(req, res, e);
		    return;
		}
	    } else {
		// This member did not exist.  		
		// Return the user to the main librarian page.
		res.sendRedirect(req.getContextPath() + "/librarianaccess.jsp" + pssn + "&checkoutMemberErrMsg=This member cannot be found in the database!");
		return;
	    }
	} else {
	    // This book did not exist.  Set the error in the book.
	    // Return the user to the main librarian page.
	    res.sendRedirect(req.getContextPath() + "/librarianaccess.jsp" + pssn + "&checkoutBookErrMsg=This book cannot be found in the database!");
	    return;
	}
    }
}

