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
import library.HoldSet;
import library.BookTitleSet;
import library.LibraryMember;
import library.LibraryBook;
import library.LibraryBookTitle;

/**
 * Class <b>MemberViewonholdController</b> contains 
 * the servlet controller functionality for
 * handling all requests for viewing
 * books on hold by library members.  
 *
 * @author iCarnegie
 * @version 1.0
 */
public class MemberViewonholdController extends Controller {
    
     /**
     * MemberViewonholdController doPost method.  This is can be called
     * by <b>Controller</b> superclass' doGet() method.
     * @param req HttpServletRequest servlet request object
     * @param res HttpServletResponse servlet response object
     * @throws ServletException
     * @throws IOException
     */
    public void doPost (HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException {

	// Get the session object.
	HttpSession session = req.getSession();
	
	// Retrieve the member from the session.
	Member member = (Member) session.getAttribute("member");

	if (member == null) {
	    // Forward results to the display page.
	    res.sendRedirect(req.getContextPath() + "/member.jsp");
	    return;
	}

	// Get the set of holds for this member.
	HoldSet heldBooks = null;
	
	try {
	    heldBooks = LibraryMember.getMemberHolds( member );
	} catch( Exception e ){
	    sendErrorRedirect(req, res, e);
	    return;
	}

	// Create a BookTitleSet.
	BookTitleSet books = new BookTitleSet();
	
	// Move the holds to the BookTitleSet.
	try {
	    for( int i=0; i<heldBooks.getHoldCount(); i++ ) {
		books.addBookTitle( LibraryBookTitle.getBookTitle( heldBooks.getHoldAt(i).getCallNumber() ) );
	    }
	} catch( Exception e ){
	    sendErrorRedirect(req, res, e);
	    return;
	}
	
	// Store the BookTitleSet object in the session.
	session.setAttribute("books", books);
	
	// redirect to the display page.
	res.sendRedirect(req.getContextPath() + "/viewheldbooks.jsp");
	return;
    }
}

    


