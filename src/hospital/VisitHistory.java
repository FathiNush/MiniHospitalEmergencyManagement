package hospital;

public class VisitHistory {

    private VisitNode head;

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