package library;
/*
 * Librarian.java
 *
 */

import java.util.*;
import java.sql.*;

/** 
 * This bean represents a librarian.
 * Class Librarian inherits
 * from class LibraryUser.
 *
 * @author  iCarnegie
 * @version 1.0
 */
public class Librarian extends LibraryUser {
    
    /**
     * Class constructor
     */
    public Librarian() {
	super();
    }
    
    /**
     * Class Librarian constructor
     * @param inSsn int containing ssn of the librarian 
     * @param inFamilyName String librarian's family name
     * @param inGivenName String librarian's give name
     * @param inSreet String librarian's street address
     * @param inCity String librarian's city
     * @param inState String librarian's state
     * @param inPostalCode String librarian's postal code
     * @param inPhoneNumber String librarian's phone number
     * @param inEmail String librarian's email
     * @param inPasswd String librarian's password
     */

    public Librarian( int inSsn, String inFamilyName, String inGivenName, String inStreet,
		      String inCity, String inState, String inPostalCode, String inPhoneNumber,
		      String inEmail, String inPasswd ) {
	
	// call super class' constructor
        super(inSsn, inFamilyName, inGivenName, inStreet, inCity, inState, inPostalCode,
              inPhoneNumber, inEmail, inPasswd );
    }
} 
