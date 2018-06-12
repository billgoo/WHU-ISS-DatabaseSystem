package library;
/*
 * Member.java
 *
 */

import java.util.*;

/** 
 * This bean represents a member.
 * Class <code>Member</code> inherits
 * from class <code>LibraryUser</code>.
 *
 * @author  iCarnegie
 * @version 1.0
 */
public class Member extends LibraryUser{
    
    private String driverLicState;
    private String driverLicNumber;
    
    /**
     * Class constructor
     */
    public Member() 
    {
	super();
    }
    
    /**
     * Class member constructor
     * @param inSsn int containing ssn of the member 
     * @param inFamilyName String member's family name
     * @param inGivenName String member's give name
     * @param inSreet String member's street address
     * @param inCity String member's city
     * @param inState String member's state
     * @param inPostalCode String member's postal code
     * @param inPhoneNumber String member's phone number
     * @param inEmail String member's email
     * @param inPasswd String member's password
     * @param inDLicState String member's drivers license state
     * @param inDLicNum String member's drivers license number
     */
    public Member(int inSsn, String inFamilyName, String inGivenName, String inStreet,
		  String inCity, String inState, String inPostalCode, String inPhoneNumber,
		  String inEmail, String inPasswd, String inDLicState, String inDLicNum ) {

    	super(inSsn, inFamilyName, inGivenName, inStreet, inCity, inState, inPostalCode, 
	      inPhoneNumber, inEmail, inPasswd );
	
	driverLicState = inDLicState;
	driverLicNumber = inDLicNum;
    }
    
    /**
     * access method for drivers license state
     * @return String
     */
    public String getDriverLicState() {
	return driverLicState;
    }

    /**
     * mutator for drivers license state
     * @param inDLicState String input drivers license state
     * @return void 
     */
    public void setDriverLicState( String inDLicState ) {
	driverLicState = inDLicState;
    }
    
    /**
     * accessor methd for drivers license number
     * @return String
     */
    public String getDriverLicNumber() {
	return driverLicNumber;
    }

    /** 
     * mutator method for driver's license state
     * @param inDLicState String input drivers license state
     * @return void
     */
    public void setDriverLicNumber( String inDLicNumber ) {
        driverLicNumber = inDLicNumber;
    }   
}
