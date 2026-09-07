package hospital;

/**
 * Singly linked list holding one patient's visit history.
 * Each Patient object owns its own separate VisitHistory instance,
 * so visits are never mixed between different patients.
 * Supports adding, removing, searching, and displaying visits.
 */
public class VisitHistory {

    private VisitNode head;

    /**
     * Adds a new visit to the end of this patient's visit history.
     */
    public void addVisit(Visit visit) {

        VisitNode newNode = new VisitNode(visit);

        if (head == null) {
            head = newNode;
        } 
        else {
            VisitNode current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        System.out.println("Visit added successfully.");
    }

    /**
     * Removes a visit from this patient's history by Visit ID.
     * Handles the empty-list case and the "not found" case.
     */
    public void removeVisit(int visitId) {

        if (head == null) {
            System.out.println("Visit history is empty.");
            return;
        }

        if (head.visit.getVisitId() == visitId) {
            head = head.next;
            System.out.println("Visit removed successfully.");
            return;
        }

        VisitNode current = head;

        while (current.next != null) {

            if (current.next.visit.getVisitId() == visitId) {
                current.next = current.next.next;
                System.out.println("Visit removed successfully.");
                return;
            }

            current = current.next;
        }

        System.out.println("Visit not found.");
    }

    /**
     * Searches this patient's visit history for a given Visit ID.
     *
     * @return the matching Visit, or null if not found.
     */
    public Visit searchVisit(int visitId) {

        VisitNode current = head;

        while (current != null) {

            if (current.visit.getVisitId() == visitId) {
                return current.visit;
            }

            current = current.next;
        }

        return null;
    }

    /**
     * Displays every visit in this patient's history, in the
     * order they were added.
     */
    public void displayHistory() {

        if (head == null) {
            System.out.println("No visit history found.");
            return;
        }

        VisitNode current = head;

        while (current != null) {

            System.out.println("----------------------------");
            current.visit.displayVisit();

            current = current.next;
        }
    }
}