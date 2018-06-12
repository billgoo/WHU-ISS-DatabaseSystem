package library;
/*
 * LibraryLibrarian.java
 *
 */

import java.util.*;
import java.sql.*;

/** 
 * This bean represents a heavyweight librarian.
 * @author  iCarnegie
 * @version 1.0
 */
public class LibraryLibrarian{
    
    /**
     * class LibraruLibrarian constructor
     */
    public LibraryLibrarian() 
    {}
    
    /**
     * getLibrarian returns a new librarian with the specified ssn
     * @param ssn int ssn of librarian to create
     * @retrun Librarian
     */
    public static Librarian getLibrarian( int ssn )
	throws Exception {
	
	DBWrapper myConnection = DBWrapper.Instance();
	String sqlQuery = "select * from Librarian where ssn='" + ssn + "'";
	ResultSet r = null;
	Librarian librarian = null;
	
	r = myConnection.runQuery( sqlQuery );
	if (r.next()) {
	    librarian = new Librarian( r.getInt("ssn"), r.getString( "lname" ), r.getString( "fname" ), 
				       r.getString( "street" ), r.getString( "city" ), r.getString( "state" ), 
				       r.getString( "pcode" ), r.getString( "phone"), r.getString( "email" ), 
				       r.getString( "passwd" ) );
	}
	return librarian;
    }
}












