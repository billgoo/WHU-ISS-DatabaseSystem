package library;
import java.util.*;
import java.io.*;
import java.sql.*;

/** 
 * class LibraryBook is a heavy weight representation
 * of a book at a library
 */
public class LibraryBook
{
    /**
     * class LibraryBook constructor
     */
    public LibraryBook()
    {}
    
    /**
     * getBook returns a book object with the specified id
     * @param inBookId int id of book
     * @return Book
     */
    public static Book getBook( int inBookId ) 
	throws Exception {
	
	Book myBook = null;
	String sqlQuery = "select * from book b, booktitle bt where b.callnumber = bt.callnumber and b.bookid='" + inBookId + "'";
	// Get a the singleton db wrapper
	DBWrapper myConnection = DBWrapper.Instance();
        ResultSet r = null;
	
	r = myConnection.runQuery( sqlQuery );
	if (r.next()) {
	    String duedate = null;
	    if (r.getString( "duedate" )==null) {
		duedate="";
	    }
	    // create the book object
	    myBook = new Book( r.getInt( "bookid" ), LibraryMember.getMember( r.getInt( "borrowerssn" )),
				   LibraryLibrarian.getLibrarian( r.getInt("librarianssn" ) ), 
			       r.getString( "duedate" ), r.getString( "callnumber" ), r.getString( "name" ),
			       r.getString( "author" ), r.getString( "isbn" ), r.getString( "edition" ),
			       r.getString( "publisher" ), r.getInt( "year" ) );
	}
	// close the result set
	r.close();
	return myBook;
    }
    
    /**
     * isCheckedOut returns whether or not a book with the given id is checked out
     * @param inBookId int id of book to check
     * @return boolean
     */
    public static boolean isCheckedOut( int inBookId ) 
	throws Exception{
	
	boolean checkedOut = false;
	String sqlQuery = "select bookid from book where bookid=" + inBookId + "  and duedate is not null";
	
	//Get singleton database instance	
	DBWrapper myConnection = DBWrapper.Instance();
        ResultSet r = null;
	
	r = myConnection.runQuery( sqlQuery );
	if (r.next()) {
	    checkedOut = true;
	}
	return checkedOut;
    }
}















