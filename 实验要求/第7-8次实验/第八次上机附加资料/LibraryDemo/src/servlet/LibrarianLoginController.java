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

/**
 * Class <b>LibrarianLoginController</b> contains 
 * the servlet controller functionality for processing
 * librian login requests.
 * 
 *
 * @author iCarnegie
 * @version 1.0
 */
public class LibrarianLoginController extends Controller {
    
    /**
     * LibrarianLoginController doPost method.  This is can be called
     * by <b>Controller</b> superclass' doGet() method.
     * @param req HttpServletRequest servlet request object
     * @param res HttpServletResponse servlet response object
     * @throws ServletException
     * @throws IOException
     */
    public void doPost (HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
	
	// Get the session object.
	HttpSession session = req.getSession();
	
	// Lets invalidate the session to get rid of the unnecessary objects.
	session.invalidate();
	
	// Get a fresh HttpSession.
	session = req.getSession();
	
	Library library = null;

	// Create a new instance of the Library object.
        try {
	    library = new Library();
	} catch( Exception e ) {
	    sendErrorRedirect(req, res, e);
	    return;
	}
	
	// Get the username and password parameters from the log in form.
	int ssn;
	try {
	    // Get the uname parameter.
	    ssn = (req.getParameter("uname") == null) ? 0 : Integer.parseInt(req.getParameter("uname"));
	} catch( NumberFormatException nfe) {
	    res.sendRedirect(req.getContextPath() + "/librarian.jsp?uname="
			     + req.getParameter("uname") 
			     + "&errMsg=Librarian ID must be in integer!");
	    return;
	}
	String passWord = req.getParameter("passwd");
	
	// Attempt to validate the librarian.
	Librarian librarian = null;
	
	try {
	    librarian = library.validateLibrarian( ssn, passWord );
	} catch( Exception e ){
	    sendErrorRedirect(req, res, e);
	    return;
	}
	
	try {
	    // Place the librarian bean back into the session.
	    if (librarian!=null) {
		session.setAttribute("librarian", librarian);
		res.sendRedirect(req.getContextPath() + "/librarianaccess.jsp");
		return;
	    } else {
		// If the librarian object is null, then validation has failed.  Tell this to the user.
		res.sendRedirect(req.getContextPath() + "/librarian.jsp?uname="
			     + req.getParameter("uname") 
			     + "&errMsg=Invalid user id and/or password");
		return;
	    }
	} catch (Exception e) {
	    // Send the exception to the standard error page.
	    sendErrorRedirect(req, res, e);
	    return;
	}
    }
}





