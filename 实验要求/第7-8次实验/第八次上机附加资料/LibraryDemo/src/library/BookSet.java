package library;
import java.util.*;

/**
 * Class <b>BookSet</b> represents a 
 * collection of books.
 *
 * @author iCarnegie
 * @version 1.0
 */

public class BookSet{
    
    // The set is maintained in a vector.
    private Vector<Book> set;
    
    /**
     * class Book constructor.
     *
     */
    public BookSet() {
	set = new Vector<Book>();
    } 
    
    /**
     * class Book constructor.
     * @param inSet Vector vector of objects to initialize this set.
     */
    public BookSet( Vector<Book> inSet ) {
	set = new Vector<Book>( inSet );
    }
    
    /**
     * getBookAt returns the book at the specified location in the set.
     * @param int index index of Book to return
     * @return Book
     */
    public Book getBookAt( int index ) {
	return (Book)set.get(index);
    }

    /**
     * getBookCount returns the number of books in the set.
     * @return int
     */
    public int getBookCount() {
	return set.size();
    }
    
    /**
     * addBook adds a book to the set
     * @param book Book book to be added to the set.
     * @return void
     */
    public void addBook( Book book ) {
	set.add( book );
    }

    /**
     * removeBookAt removes a book at the specified index and returns it
     * @param index int index of book to remove
     * @return Book
     */
    public Book removeBookAt( int index ) {
	return (Book)set.remove( index );
    }

    /**
     * removeBook removes the input book from the bookset
     * @param book Book book to remove
     * @return boolean
     */
    public boolean removeBook( Book book ) {
	return set.remove( book );
    }
}









