package library;
import java.sql.*;

/**
 * A class representing a hold.
 *
 * @author iCarnegie
 * @version 1.0
 *
 */
public class Hold {
    
    private String callNumber;
    private String holderSSN;
    private java.sql.Timestamp holdDateTime;
    
    /**
     * public class Hold constructor
     *
     */
    public Hold(){} 

    /**
     * class Hold constructor
     * @param inCallNumber String input call number
     * @param inHolder String input holder ssn
     * @param inHoldDate java.sql.Timestamp input hold date and time
     */
    public Hold( String inCallNumber, String inHolder, java.sql.Timestamp inHoldDateTime ) {
	callNumber = inCallNumber;
	holderSSN = inHolder;
	holdDateTime = inHoldDateTime;
    }
    
    /**
     * getCallNumber access or call number
     * @return String
     */
    public String getCallNumber() {
	return callNumber;
    }

    /**
     * setCallNumber is mutator for call numer
     * @param inCallNumber String input call number
     * @return void
     */
    public void setCallNumber( String inCallNumber ) {
	callNumber = inCallNumber;
    }
    
    /**
     * getHolderSSN is accessor for holder's ssn 
     * @return String
     */
    public String getHolderSSN() {
	return holderSSN;
    }
    
    /**
     * setHolderSSN is mutator for holder's ssn
     * @param inHolder String new holder's ssn
     * @return void
     */
    public void setHolderSSN( String inHolder ) {
	holderSSN = inHolder;
    }

    /**
     * getHoldDateTime is access for hold date and time
     * @return java.sql.Timestamp
     */
    public java.sql.Timestamp getHoldDateTime() {
	return holdDateTime;
    }
    
    /**
     * setHoldDateTime is mutator for hold date and time
     * @param inDateTime java.sql.Timestamp new date and time
     * @return void
     */
    public void setHoldDateTime( java.sql.Timestamp inDateTime )
    {
	holdDateTime=inDateTime;
    }
}



