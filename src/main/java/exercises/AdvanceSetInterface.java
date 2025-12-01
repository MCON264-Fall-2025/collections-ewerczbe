package exercises;

import edu.touro.mcon264.apps.collections.CollectionInterface;

/**
 * Advanced Set Interface
 * @param <T> the type of elements in the set
 */
public interface AdvanceSetInterface<T> extends CollectionInterface<T> {
    /**
     * Returns a new set that is the union of this set and another.
     * @param other the other set
     * @return a new set containing all elements from both sets
     */
    AdvanceSetInterface<T> union(AdvanceSetInterface<T> other);

    /**
     * Returns a new set that is the intersection of this set and another.
     * @param other the other set
     * @return a new set containing elements common to both sets
     */
    AdvanceSetInterface<T> intersection(AdvanceSetInterface<T> other);

    /**
     * Returns a new set that is the difference of this set and another.
     * @param other the other set
     * @return a new set containing elements in this set but not in the other
     */
    AdvanceSetInterface<T> difference(AdvanceSetInterface<T> other);
}