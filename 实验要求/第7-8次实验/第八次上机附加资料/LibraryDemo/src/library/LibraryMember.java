package library;
/*
 * LibraryMember.java
 *
 */

import java.util.*;
import java.sql.*;

/** 
 * This bean represents a heavy weight librarymember.
 *
 * @author  iCarnegie
 * @version 1.0
 */
public class LibraryMember{
    
    /**
     * class constructor
     */
    public LibraryMember() 
    {}
    
    /**
     * getMember returns a member with specified ssn
     * @param ssn int ssn of member
     * @return Member
     */
    public static Member getMember( int ssn ) 
	throws Exception {
	
	DBWrapper myConnection = DBWrapper.Instance();
	String sqlQuery = "select * from member where ssn='" + ssn + "'";
	ResultSet r = null;
	Member member = null;
	
	r = myConnection.runQuery( sqlQuery );
	if (r.next()) {
	    member = new Member( r.getInt("ssn"), r.getString( "lname" ), r.getString( "fname" ), 
				 r.getString( "street" ), r.getString( "city" ), r.getString( "state" ), 
				 r.getString( "pcode" ), r.getString( "phone"), r.getString( "email" ), 
				 r.getString( "passwd" ), r.getString( "driverlicstate" ), 
				 r.getString( "driverlicnum" ) );
	}
	return member;
    }
    
    /**
     * getMemberHoldCount returns the number of holds held by the specified member
     * @param member Member member to check
     * @return int
     */
    public static int getMemberHoldCount( Member member ) 
	throws Exception {
	
	int count = 0;
	DBWrapper myConnection = DBWrapper.Instance();
        String sqlQuery = "select count(*) as counted from hold where ssn='" + member.getSSN() + "' group by ssn";
        ResultSet r = null;

	r = myConnection.runQuery( sqlQuery );
	if (r.next()) {
	    count = r.getInt( "counted" );
	}
	
	return count;
    }
		
    /**
     * getMemberHolds returns a hold set of all holds held by the specified member
     * @param member Member member to check
     * @return HoldSet
     */
    public static HoldSet getMemberHolds( Member member ) 
	throws Exception{
	
	HoldSet currentHolds = new HoldSet();
	DBWrapper myConnection = DBWrapper.Instance();
	String sqlQuery = "SELECT * FROM Hold WHERE ssn = " + member.getSSN();
        ResultSet r = null;
	
	r = myConnection.runQuery( sqlQuery );
	while( r.next() ) {
	    currentHolds.addHold( new Hold( r.getString( "callnumber" ), r.getString( "ssn" ), r.getTimestamp("holdDateTime") ) );
	}
	
	return currentHolds;
    }

    /**
     * getCheckedOutBookCount returns the number of books checked out for the specified member
     * @param member Member member to check
     * @return int
     */
    public static int getCheckedOutBookCount( Member member )
	throws Exception {
	
	int count = 0;
	DBWrapper myConnection = DBWrapper.Instance();
	String sqlQuery = "SELECT Count(*) as counted FROM Book WHERE borrowerssn = " + member.getSSN();
        ResultSet r = null;
	
	r = myConnection.runQuery( sqlQuery );
	if (r.next())  {
	    count = r.getInt( "counted" );
	}
	
	return count;
    }

    /**
     * getCheckedOutBooks returns the set of books currently checked out by a member
     * @param member Member member to check
     * @return BookSet
     */
    public static BookSet getCheckedOutBooks( Member member ) 
	throws Exception {

	BookSet currentBooks = new BookSet();
	String sqlQuery = "SELECT bookid FROM Book WHERE borrowerssn = " + member.getSSN();
	DBWrapper myConnection = DBWrapper.Instance();
        ResultSet r = null;
	
	//get book info from db here and build a new book object
	r = myConnection.runQuery( sqlQuery );
	while( r.next() ) {
	    currentBooks.addBook( LibraryBook.getBook( r.getInt( "bookid" ) ) );
	}
	return currentBooks;
    }
}












