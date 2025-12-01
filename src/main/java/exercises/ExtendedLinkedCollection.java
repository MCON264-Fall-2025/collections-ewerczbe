package exercises;

import edu.touro.mcon264.apps.collections.LinkedCollection;
import edu.touro.mcon264.support.LLNode;

public class ExtendedLinkedCollection<T> extends LinkedCollection<T> {
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        LLNode<T> current = head;
        while (current != null) {
            sb.append(current.getInfo());
            if (current.getLink() != null) {
                sb.append(", ");
            }
            current = current.getLink();
        }
        sb.append("]");
        return sb.toString();
    }


    public int count(T target) {
        int count = 0;
        LLNode<T> current = head;
        while (current != null) {
            T info = current.getInfo();
            if ((target == null && info == null) ||
                    (target != null && target.equals(info))) {
                count++;
            }
            current = current.getLink();
        }
        return count;
    }

    public void removeAll(T target) {
        // Remove leading matches at the head
        while (head != null &&
                ((target == null && head.getInfo() == null) ||
                        (target != null && target.equals(head.getInfo())))) {
            head = head.getLink();
            numElements--;
        }

        // Traverse the rest
        LLNode<T> current = head;
        LLNode<T> previous = null;
        while (current != null) {
            T info = current.getInfo();
            if ((target == null && info == null) ||
                    (target != null && target.equals(info))) {
                // unlink current
                if (previous != null) {
                    previous.setLink(current.getLink());
                }
                numElements--;
            } else {
                previous = current;
            }
            current = current.getLink();
        }
    }
}
