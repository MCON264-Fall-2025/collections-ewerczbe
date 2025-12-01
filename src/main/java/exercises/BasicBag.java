package exercises;

import edu.touro.mcon264.apps.collections.ArrayCollection;
import edu.touro.mcon264.apps.collections.BagInterface;

import java.util.Arrays;
import java.util.Random;

public class BasicBag<T> extends ArrayCollection<T> implements BagInterface<T> {
    private Random rand = new Random();

    @Override
    public T grab() {
        if (isEmpty()) return null;

        // pick a random index
        int index = rand.nextInt(numElements);
        T element = elements[index];

        // shift elements left to fill the gap
        for (int i = index; i < numElements - 1; i++) {
            elements[i] = elements[i + 1];
        }

        // clear last slot
        elements[numElements - 1] = null;
        numElements--;

        return element;

    }

    @Override
    public int count(T target) {
        int c = 0;
        for (int i = 0; i < numElements; i++) {
            if ((target == null && elements[i] == null) ||
                    (target != null && target.equals(elements[i]))) {
                c++;
            }
        }
        return c;

    }

    @Override
    public int removeAll(T target) {
        int removed = 0;
        int j = 0;
        for (int i = 0; i < numElements; i++) {
            if ((target == null && elements[i] == null) ||
                    (target != null && target.equals(elements[i]))) {
                removed++;
            } else {
                elements[j++] = elements[i];
            }
        }
        numElements = j;
        return removed;

    }

    @Override
    public void clear() {
        Arrays.fill(elements, 0, numElements, null);
        numElements = 0;


    }

    // TODO: implement the methods in the BagInterface using an array as the underlying data structure
    // consider extending ArrayCollection<T>
    // put in the JavaDoc comments as specified in the BagInterface.
    // Which SOLID principles is being applied here?


}
