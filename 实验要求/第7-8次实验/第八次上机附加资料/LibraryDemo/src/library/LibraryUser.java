package library;
/*
 * LibraryUser.java
 *
 */

import java.util.*;

/** 
 * This bean represents an abstraction of
 * the two types of users of the library
 * web application, namely Librarians
 * and Members.  Class <code>Librarian</code>
 * and class <code>Member</code> inherit
 * from the <code>LibraryUser</code> class.
 *
 * @author  iCarnegie
 * @version 1.0
 */
public class LibraryUser{
    
    protected int ssn;
    protected String familyName;
    protected String givenName;
    protected String street;
    protected String city;
    protected String state;
    protected String postalCode;
    protected String phoneNumber;
    protected String email;
    protected String passwd;
    
    /**
     * Class constructor
     */
    public LibraryUser() {
	ssn = -1;
    }

    /**
     * class LibraryUser constructor
     * @param inSsn int containing ssn of the library user 
     * @param inFamilyName String library user's family name
     * @param inGivenName String library user's give name
     * @param inSreet String library user's street address
     * @param inCity String library user's city
     * @param inState String library user's state
     * @param inPostalCode String library user's postal code
     * @param inPhoneNumber String library user's phone number
     * @param inEmail String library user's email
     * @param inPasswd String library user's password
     */
    public LibraryUser( int inSsn, String inFamilyName, String inGivenName, String inStreet,
			String inCity, String inState, String inPostalCode, String inPhoneNumber,
			String inEmail, String inPasswd ) {
	ssn = inSsn;
	familyName = inFamilyName;
	givenName = inGivenName;
	street = inStreet;
	city = inCity;
	state = inState;
	postalCode = inPostalCode;
	phoneNumber = inPhoneNumber;
	email = inEmail;
	passwd = inPasswd;
    }
    
    /**
     * Accessor method for SSN
     * @return int containing user's ssn
     */
    public int getSSN() {
	return ssn;
    }

    /**
     * mutator method for ssn
     * @param inSSN int input ssn
     * @return void
     */
    public void setSSN( int inSSN ) {
        ssn = inSSN;
    }
    
    /**
     * Accessor method for fname
     * @return String containing user's first name
     */
    public String getGivenName() {
	return givenName;
    }

    /**
     * mutator method for given name
     * @param inGname String input given name
     * @return void 
     */
    public void setGivenName( String inGname ) {
        givenName = inGname;
    }
    
    /**
     * Accessor method for lname
     * @return String containing user's last name
     */
    public String getFamilyName() {
	return familyName;
    }

    /**
     * mutator method for family name
     * @param inFname String input family name
     * @return void 
     */
    public void setFamilyName( String inFname ) {
        familyName = inFname;
    }

    /**
     * Accessor method for street
     * @return String containing user's street
     */
    public String getStreet() {
	return street;
    }

    /**
     * mutator method for street
     * @param inStreet String input street
     * @return void 
     */
    public void setStreet( String inStreet ) {
        street = inStreet;
    }

    /**
     * Accessor method for city
     * @return String containing user's city
     */
    public String getCity() {
	return city;
    }

    /**
     * mutator method for city
     * @param inCity String input city
     * @return void 
     */
    public void setCity( String inCity ) {
        city = inCity;
    }
    
    /**
     * Accessor method for state
     * @return String containing user's state
     */
    public String getState() {
	return state;
    }
    
    /**
     * mutator method for state
     * @param inState String input state
     * @return void 
     */
    public void setState( String inState ) {
        state = inState;
    }
    
    /**
     * Accessor method for pcode
     * @return String containing user's postal code
     */
    public String getPostalCode() {
	return postalCode;
    }

    /**
     * mutator method for postcal code
     * @param inPcoce String input postal code
     * @return void 
     */
    public void setPcode( String inPcode ) {
        postalCode = inPcode;
    }
    
    /**
     * Accessor method for phoneNumber
     * @return String containing user's telephone number
     */
    public String getPhone() {
	return phoneNumber;
    }

    /**
     * mutator method for phone
     * @param inPhone String input phone
     * @return void 
     */
    public void setPhone( String inPhone ) {
        phoneNumber = inPhone;
    }
    
    /**
     * Accessor method for email
     * @return String containing user's email address
     */
    public String getEmail() {
	return email;
    }

    /**
     * mutator method for email
     * @param inEmail String input email
     * @return void 
     */
    public void setEmail( String inEmail ) {
        email = inEmail;
    }
    
    /**
     * Accessor method for passwd
     * @return String containing user's password
     */
    public String getPasswd() {
	return passwd;
    }

    /**
     * mutator method for password
     * @param inPasswd String input password
     * @return void 
     */
    public void setPasswd( String inPasswd ) {
        passwd = inPasswd;
    }
    
    /**
     * getName returns full name
     * @return String containing first and last name, separated by a single space
     */
    public String getName() {
	return this.getGivenName() + " " + this.getFamilyName();
    }
}













