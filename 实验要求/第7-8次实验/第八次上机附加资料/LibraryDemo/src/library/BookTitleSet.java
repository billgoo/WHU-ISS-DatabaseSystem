package library;
import java.util.*;

/**
 * Class <b>BookTitleSet</b> represents a 
 * collection of book titles.
 *
 * @author iCarnegie
 * @version 1.0
 */
public class BookTitleSet{
   
    // Set is represented using a vector.
    private Vector<BookTitle> set = null;
    
    /**
     * class Book constructor.
     *
     */
    public BookTitleSet() {
	set = new Vector<BookTitle>();
    } 
    
    /**
     * class BookTitleSet constructor
     * @param inSet Vector of objects to populate this set.
     */
    public BookTitleSet( Vector<BookTitle> inSet ) {
	set = new Vector<BookTitle>( inSet );
    }
    
    /**
     * getBookTitleAt returns the book title at the specified location in the set.
     * @param int index index of BookTitle to return
     * @return BookTitle
     */
    public BookTitle getBookTitleAt( int index ) {
	return (BookTitle)set.get(index);
    }

    /**
     * getBookTitleCount returns the number of book titles in the set.
     * @return int
     */
    public int getBookTitleCount() {
	return set.size();
    }
    
    /**
     * addBookTitle adds a book title to the set
     * @param bookTitle BookTitle book title to be added to the set.
     * @return void
     */
    public void addBookTitle( BookTitle bookTitle ) {
	set.add( bookTitle );
    }

    /**
     * removeBookTitleAt removes a book title at the specified index and returns it
     * @param index int index of book title to remove
     * @return BookTitle
     */
    public BookTitle removeBookTitleAt( int index ) {
	return (BookTitle)set.remove( index );
    }

     /**
     * removeBookTitle removes the input book title from the BookTitleSet
     * @param bookTitle BookTitle book title to remove
     * @return boolean
     */
    public boolean removeBookTitle( BookTitle bookTitle ) {
	return set.remove( bookTitle );
    }
}











