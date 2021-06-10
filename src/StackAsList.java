
/**
 * This class takes a Stack and converts it to a Linked List.
 *
 * @author	robinwettstaedt
 * @author	n-c0de-r
 * @version	21-06-03 update 21-06-07
 */

//Assignment 2
public class StackAsList implements Stack{

    private Node first;

    /**
     * constructor for the stack as a linked list.
     */
    public StackAsList() {
    }

    class Node {
        String data;
        Node next;

        //Constructor of the Node class
        public Node() {
        }

    }

    /**
     * Insert an element in the beginning of the list,
     * as the top-most element of a stack.
     * @return The String just stored in the Node.
     */
    @Override
    public String push(String element) {

        Node node = new Node();
        node.data = element;
        node.next = first;
        first 	  = node;
        return element;
    }

    /**
     * Gets the first/ top-most element of the list,
     * and removes it from the order and it's linking,
     * @return String stored in the Node's data field.
     */
    @Override
    public String pop() {
        if (!isEmpty()) {
            String s = first.data;
            first	 = first.next;
            return s;
        } else {
            return null;
        }
    }

    /**
     * Just look into the data field of the top-most Node.
     * * @return String stored in the Node's data field.
     */
    @Override
    public String peek() {
        if (isEmpty())
            return null;
        else
            return first.data;
    }

    /**
     * Check if the list/stack is empty.
     * @return Boolean, true if there are no Nodes in the list.
     */
    @Override
    public boolean isEmpty() {
        if (first == null)
            return true;
        return false;
    }

    //not sure why we would need this.
    @Override
    public String toString() {
        String s = "";
        if (isEmpty()) {
            return s;
        }

        Node current = first;

        while (true) {
            s = s + "[ " + current.data + " ] ";
            if (current.next == null) {
                break;
            }
            current = current.next;
        }
        return first.data;
    }
}
