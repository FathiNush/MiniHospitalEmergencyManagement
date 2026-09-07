package hospital;

import java.util.Stack;

/**
 * Stores completed treatment records using a Stack.
 * Follows LIFO (Last-In, First-Out): the most recently completed
 * treatment is always the first one popped/removed.
 */
public class TreatmentStack {

    private Stack<TreatmentRecord> stack = new Stack<>();

    /**
     * Pushes a newly completed treatment record onto the stack.
     */
    public void push(TreatmentRecord record) {
        stack.push(record);
        System.out.println("Treatment record added.");
    }

    /**
     * Removes and returns the most recently added treatment record.
     * Handles the empty-stack case gracefully instead of throwing
     * an exception.
     */
    public TreatmentRecord pop() {

        if (stack.isEmpty()) {
            System.out.println("Treatment stack is empty.");
            return null;
        }

        TreatmentRecord record = stack.pop();

        System.out.println("Most recent treatment removed:");
        record.displayRecord();

        return record;
    }

    /**
     * Displays all treatment records, most recent first,
     * without removing them from the stack.
     */
    public void displayStack() {

        if (stack.isEmpty()) {
            System.out.println("Treatment stack is empty.");
            return;
        }

        System.out.println("Treatment History:");

        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.println("----------------------------");
            stack.get(i).displayRecord();
        }
    }
}