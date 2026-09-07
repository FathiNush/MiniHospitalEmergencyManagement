package hospital;

/**
 * A single node in the Patient Binary Search Tree.
 * Holds one Patient object plus references to its left and
 * right child nodes (smaller and larger Patient IDs respectively).
 */
public class PatientNode {

    Patient patient;
    PatientNode left;
    PatientNode right;

    public PatientNode(Patient patient) {
        this.patient = patient;
        this.left = null;
        this.right = null;
    }
}