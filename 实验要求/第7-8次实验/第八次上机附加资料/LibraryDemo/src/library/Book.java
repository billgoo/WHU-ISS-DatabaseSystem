package library;
import java.text.*;

/**
* A class representing a book
*
* @author iCarnegie
* @version 1.0
*/
public class Book extends BookTitle{
   
    private int bookId;
    private Member borrower;
    private Librarian librarian;
    private String dueDate;
    
    /**
     * class Book constructor.
     *
     */
    public Book(){} 
    
    /**
     * class Book constructor.
     * @param inBookId int book identification number.
     * @param inBorrower Member member who has borrowed this book.
     * @param inLibrarian Librarian who has checked this book out.
     * @param inDueDate String book's due date.
     * @param inCallNumber String book's call number.
     * @param inName String book's name (title).
     * @param inAuthors String book's authors.
     * @param inIsbn String book's ISBN
     * @param inEdition String book's edition.
     * @param inPublisher String book's publisher.
     * @param inYear int book's year.
     *
     */
    public Book( int inBookId, Member inBorrower, Librarian inLibrarian, String inDueDate,
		 String inCallNumber, String inName, String inAuthors, String inIsbn,
		 String inEdition, String inPublisher, int inYear ) {

	// Call super class' constructor.
	super( inCallNumber, inName, inAuthors, inIsbn, inEdition, inPublisher, inYear );
	
	// Set instance variables.
	bookId = inBookId;
	borrower = inBorrower;
	librarian = inLibrarian;
	dueDate = inDueDate;
    }

    /**
     * Accessor for book id
     * @return int
     */
    public int getBookId() {
	return bookId;
    }
    
    /**
     * Mutator for book id
     * @return void
     */
    public void getBookID( int inBookId ) {
        bookId = inBookId;
    }
    
    /**
     * Accessor for Call Number
     * @return String
     */
    public String getCallNumber() {
	return callNumber;
    }
    
    /**
     * Mutator for Call Number
     * @return void
     */
    public void setCallNumber( String inCallNumber ) {
        callNumber = new String( inCallNumber );
    }
    
    /**
     * Accessor for due date
     * @return String
     */
    public String getDueDate() {
	return dueDate;
    }
    
    /**
     * Mutator for due date
     * @return void
     */
    public void setDueDate( String inDueDate ) {
        dueDate = new String( inDueDate );
    }
    
    /**
     * Accessor for borrower
     * @return Member
     */
    public Member getBorrower() {
    	return borrower;
    }
    
    /**
     * Mutator for borrower
     * @return void
     */
    public void setBorrower( Member inBorrower ) {
        borrower = inBorrower;
    }
    
    /**
     * Accessor for librarian
     * @return Librarian
     */
    public Librarian getLibrarian() {
	return librarian;
    }
    
    /**
     * Mutator for librarian
     * @return void
     */
    public void setLibrarian( Librarian inLibrarian ) {
        librarian = inLibrarian;
    }
}









