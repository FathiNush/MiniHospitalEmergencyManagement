package hospital;

/**
 * A single node in a patient's Visit History singly linked list.
 * Holds one Visit object plus a reference to the next node.
 */
public class VisitNode {

    Visit visit;
    VisitNode next;

    public VisitNode(Visit visit) {
        this.visit = visit;
        this.next = null;
    }
}