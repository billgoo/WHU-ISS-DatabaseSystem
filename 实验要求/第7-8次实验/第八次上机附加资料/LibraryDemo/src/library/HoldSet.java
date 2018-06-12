package library;
import java.util.*;

/**
* A class representing a set of holds
*
* @author iCarnegie
* @version 1.0
*/
public class HoldSet{
   
    // set is stored as a vector.
    private Vector<Hold> set = null;
    
    /**
     * class HoldSet constructor.
     *
     */
    public HoldSet() {
	set = new Vector<Hold>();
    } 
    
    /**
     * class HoldSet constructor
     * @param inSet Vector of holds to initialize this set
     */
    public HoldSet( Vector<Hold> inSet ) {
	set = new Vector<Hold>( inSet );
    }
    
    /**
     * getHoldAt returns the Hold at the specified index
     * @param index int index of hold to return
     * @return Hold 
     */
    public Hold getHoldAt( int index ) {
	return (Hold)set.get(index);
    }

    /**
     * getHoldCount returns the number of holds in this set
     * @return int
     */
    public int getHoldCount() {
	return set.size();
    }
    
    /**
     * addHold adds a hold to this set
     * @param hold Hold hold to add to the set
     * @return void
     */
    public void addHold( Hold hold ) {
	set.add( hold );
    }

    /**
     * removeHoldAt removes and returns the hold at the specified index
     * @param index int index of hold to remove
     * @return Hold
     */
    public Hold removeHoldAt( int index ) {
	return (Hold)set.remove( index );
    }
    
    /**
     * removeHold removes the specified hold from the set
     * @param hold Hold hold to remove
     * @return boolean
     */
    public boolean removeHold( Hold hold ) {
	return set.remove( hold );
    }
}









