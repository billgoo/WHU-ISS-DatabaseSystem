package library;

/**
* A heavyweight class representing a book title
*
* @author iCarnegie
* @version 1.0
*/

import java.sql.*;

public class LibraryBookTitle{
     
    /**
     * class LibraryBookTitle constructor
     *
     */
    public LibraryBookTitle(){} 

    /**
     * getTitleHolds retuns the set of all holds for the specified call number
     * @param callNumber String call number of title to chek
     * @return HoldSet
     */
    public static HoldSet getTitleHolds( String callNumber ) 
	throws Exception {
	
	ResultSet r = null;
        int count = 0;
        DBWrapper myConnection = null;
	
	// Get instance of singleton dbwrapper
        myConnection = DBWrapper.Instance();
	HoldSet currentHolds = new HoldSet();
	
        String sqlQuery = "SELECT * FROM Hold WHERE CallNumber = '" + callNumber + "'";
	
	r = myConnection.runQuery( sqlQuery );
	while( r.next() ) {
	    currentHolds.addHold( new Hold( callNumber, r.getString( "ssn" ), r.getTimestamp("holdDateTime") ) );
	}
	return currentHolds;
    }

    /**
     * getTitleCopies returns a set of books for the given call number
     * @param callNumber String call number of title to check 
     * @return BookSet
     */
    public static BookSet getTitleCopies( String callNumber ) 
	throws Exception {
	
	ResultSet r = null;
        int count = 0;
        DBWrapper myConnection = null;
	
	// Get instance of singleton dbwrapper
        myConnection = DBWrapper.Instance();
        BookSet currentHolds = new BookSet();
	
	String sqlQuery = "SELECT bookid FROM Book WHERE CallNumber = '" + callNumber + "'";
	
	//get info from db to make a book
	r = myConnection.runQuery( sqlQuery );
	while( r.next() ) {
	    currentHolds.addBook( LibraryBook.getBook( r.getInt( "bookid" ) ) );
	}
        return currentHolds;
    }
    
    /**
     * getTitleHoldCount gets the number of holds on the specified call number
     * @param callNumber String call number of book title to check
     * @return int
     */
    public static int getTitleHoldCount( String callNumber ) 
	throws Exception {

	ResultSet r = null;
	int count = 0;
	DBWrapper myConnection = null;
	
	myConnection = DBWrapper.Instance();
	
	String sqlQuery = "SELECT Count(*) as counted FROM Hold WHERE CallNumber = '" + callNumber + "'";
	
	r = myConnection.runQuery( sqlQuery );
	r.next();
	count = r.getInt("counted");
	
	return count;
    }
    
    /**
     * isTitleHeld returns whether or not the specified call number is held
     * @param callNumber String call number of title to check
     * @return boolean
     */
    public static boolean isTitleHeld( String callNumber ) 
	throws Exception {
	
	int count = getTitleHoldCount( callNumber );
	if (count==0) {
	    return false;
	} else {
	    return true;
	}
    }

    /**
     * getTitleCopyCount returns the number of copies of the specified call number
     * @param callNumber String call number of title to check
     * @return int
     */
    public static int getTitleCopyCount( String callNumber )
	throws Exception {
	
	ResultSet r = null;
        int count = 0;
        DBWrapper myConnection = null;
	
	String sqlQuery = "select count(*) as counted from book where callnumber='" + callNumber + "' group by callnumber" ;
	myConnection = DBWrapper.Instance();
	r = myConnection.runQuery( sqlQuery );
	r.next();
	count = r.getInt( "counted" );
	
	return count;
    }

    /**
     * getAvailableTitleCopyCount returns the number of available copies of the specified title
     * @param callNumber String call number of title to check
     * @return int
     */
    public static int getAvailableTitleCopyCount( String callNumber ) 
	throws Exception {
        
	ResultSet r = null;
        int count = 0;
        DBWrapper myConnection = null;
	
	String sqlQuery = "SELECT Count(*) as counted FROM Book WHERE (DueDate IS NULL) AND CallNumber = '" + callNumber + "'";
	myConnection = DBWrapper.Instance();
	r = myConnection.runQuery( sqlQuery );
	r.next();
	count = r.getInt( "counted" );
	
        return count;
    }
    
    /**
     * getAvailableTitleCopies returns the set of all available books with the specified call number
     * @param callNumber String call number of title to check
     * @return BookSet
     */
    public static BookSet getAvailableTitleCopies( String callNumber ) 
	throws Exception {

        ResultSet r = null;
        int count = 0;
        DBWrapper myConnection = DBWrapper.Instance();
	BookSet mySet = null;
	
	String sqlQuery = "SELECT bookid FROM Book WHERE (DueDate IS NULL) AND CallNumber = '" + callNumber + "'";
	
	//get book info from the db
	r = myConnection.runQuery( sqlQuery );
	while( r.next() ) {
	    mySet.addBook( LibraryBook.getBook( r.getInt( "bookid" ) ) );
	}
	return mySet;
    }

    /**
     * getBookTitle returns a BookTitle object for the specified call number
     * @param callNumber String call number of title to check
     * @return BookTitle
     */
    public static BookTitle getBookTitle( String callNumber ) 
	throws Exception {
	
	BookTitle myBookTitle = null;
	ResultSet r = null;
        int count = 0;
        DBWrapper myConnection = DBWrapper.Instance();
	
        String sqlQuery = "SELECT * FROM BookTitle WHERE CallNumber = '" + callNumber + "'";
	r = myConnection.runQuery( sqlQuery );
	if (r.next()) {
	    myBookTitle = new BookTitle( r.getString( "callNumber" ), r.getString( "name" ), 
					 r.getString( "author" ), r.getString( "isbn" ), r.getString( "edition" ),
					 r.getString( "publisher" ), r.getInt( "year" ) );
	}

	return myBookTitle;
    }
}










