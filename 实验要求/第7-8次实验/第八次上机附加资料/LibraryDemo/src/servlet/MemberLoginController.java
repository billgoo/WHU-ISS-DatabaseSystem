package servlet;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import library.Book;
import library.Hold;
import library.Member;
import library.Library;

/**
 * Class <b>MemberLoginController</b> contains 
 * the servlet controller functionality for processing
 * member login requests.
 * 
 *
 * @author iCarnegie
 * @version 1.0
 */
public class MemberLoginController extends Controller {

    /**
     * MemberLoginController doPost method.  This is can be called
     * by <b>Controller</b> superclass' doGet() method.
     * @param req HttpServletRequest servlet request object
     * @param res HttpServletResponse servlet response object
     * @throws ServletException
     * @throws IOException
     */
    public void doPost (HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException {
	
	String pass=null;
	int uname=-1;

	// Get the HttpSession object.
	HttpSession session = req.getSession();
	// Invalidate session to get rid of any old Member or Librarian objects.
	session.invalidate();
	
	// Get a fresh session.
	session = req.getSession();
	
	// Create a Library object instance.
	Library library = null;

	// Create a new instance of the Library object.
        try {
	    library = new Library();
	} catch( Exception e ) {
	    sendErrorRedirect(req, res, e);
	    return;
	}
	
	// Get the username and password parameters.
	pass = req.getParameter("passwd");
	try {
	    // Get the uname parameter.
	    uname = (req.getParameter("uname") == null) ? 0 : Integer.parseInt(req.getParameter("uname"));
	} catch( NumberFormatException nfe) {
	    res.sendRedirect(req.getContextPath() + "/member.jsp?uname="
			     + req.getParameter("uname") 
			     + "&errMsg=Member ID must be in integer!");
	    return;
	}
		
	// Create a new library member through validation.  If the uname is not valid, the member is null.
	Member member = null;
	
	try {
	    member = library.validateMember( uname, pass );
	} catch( Exception e ){
	    sendErrorRedirect(req, res, e);
	    return;
	}
	
	try {
	    // The member is not null, so he must have been validated.  Place the member into the session.
	    if (member!=null) {
		session.setAttribute("member", member);
		res.sendRedirect(req.getContextPath() + "/memberaccount.jsp");
		return;
	    } else {
		/**
		 * The member was not validated.  We simply
		 * set an error message, and redirect back to
		 * the member login page.
		 */
		res.sendRedirect(req.getContextPath() + "/member.jsp?uname="
			     + req.getParameter("uname") 
			     + "&errMsg=Incorrect User id and/or password");
		return;
	    }
	} catch (Exception e2) {
	    // Something bad happened, so redirect to the error page.
	    sendErrorRedirect(req, res, e2);
	    return;
	}
    }
}

    


