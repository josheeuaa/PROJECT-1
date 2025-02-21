/**
   An interface that describes the operations of a bag of objects.
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public interface BagInterface<T>
{
	/** Gets the current number of entries in this bag.
		 @return  The integer number of entries currently in the bag. */
	public int getCurrentSize();
	
	/** Sees whether this bag is empty.
		 @return  True if the bag is empty, or false if not. */
	public boolean isEmpty();
	
	/** Adds a new entry to this bag.
	    @param newEntry  The object to be added as a new entry.
	    @return  True if the addition is successful, or false if not. */
	public boolean add(T newEntry);

	/** Removes one unspecified entry from this bag, if possible.
       @return  Either the removed entry, if the removal.
                was successful, or null. */
	public T remove();
   
	/** Removes one occurrence of a given entry from this bag, if possible.
       @param anEntry  The entry to be removed.
       @return  True if the removal was successful, or false if not. */

  	public boolean remove(T anEntry);
	
	/** Removes all entries from this bag. */
	public void clear();
	
	/** Counts the number of times a given entry appears in this bag.
		 @param anEntry  The entry to be counted.
		 @return  The number of times anEntry appears in the bag. */
	public int getFrequencyOf(T anEntry);
	
	/** Tests whether this bag contains a given entry.
		 @param anEntry  The entry to find.
		 @return  True if the bag contains anEntry, or false if not. */
	public boolean contains(T anEntry);
   
	/** Retrieves all entries that are in this bag.
		 @return  A newly allocated array of all the entries in the bag.
                Note: If the bag is empty, the returned array is empty. */
	public T[] toArray();

	public BagInterface<T> union(BagInterface<T> other);
	/** Returns a new bag that represents the union of this bag and another bag */

	public BagInterface<T> intersection(BagInterface<T> other);
	/** The intersection method returns a new bag that represents the intersection of this bag and another bag. 
 		<T> = generic type, return type = BagInterface<T> 
   		The method parameter (BagInterface<T> other), allows any class that implements the return type to be passed in. */
	
	public BagInterface<T> difference(BagInterface<T> other);
	/** Returns a completely new bag that represents the difference of one bag from another bag that is being compared */

	/** All 3, union, intersection, and difference all use BagInterface<T> as a parameter, which improves the interoperability through our ResizableArrayBag and LinkedBag
 		each method also returns a new bag to be called within our other files. DOES NOT WORK ON ITS OWN this is just the interface file
   		this is also just a rough addition of what it could look like within this bag we should start in resizablearraybag */

	
} // end BagInterface
