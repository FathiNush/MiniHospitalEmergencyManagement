package hospital;

/**
 * Binary Search Tree that stores all Patient records, keyed by
 * Patient ID. Supports insertion, search, deletion, and an
 * in-order traversal that displays patients in ascending ID order.
 */
public class PatientBST {

    private PatientNode root;

    /**
     * Inserts a new patient into the tree based on Patient ID.
     * If the ID already exists, the patient is not inserted again.
     */
    public void insert(Patient patient) {
        root = insertRecursive(root, patient);
    }

    private PatientNode insertRecursive(PatientNode current, Patient patient) {

        if (current == null) {
            return new PatientNode(patient);
        }

        if (patient.getPatientId() < current.patient.getPatientId()) {
            current.left = insertRecursive(current.left, patient);
        } 
        else if (patient.getPatientId() > current.patient.getPatientId()) {
            current.right = insertRecursive(current.right, patient);
        } 
        else {
            System.out.println("Patient ID already exists.");
        }

        return current;
    }

    /**
     * Searches for a patient by ID.
     *
     * @return the matching Patient, or null if not found.
     */
    public Patient search(int patientId) {
        PatientNode result = searchRecursive(root, patientId);

        if (result != null) {
            return result.patient;
        }

        return null;
    }

    private PatientNode searchRecursive(PatientNode current, int patientId) {

        if (current == null) {
            return null;
        }

        if (patientId == current.patient.getPatientId()) {
            return current;
        }

        if (patientId < current.patient.getPatientId()) {
            return searchRecursive(current.left, patientId);
        }

        return searchRecursive(current.right, patientId);
    }

    /**
     * Displays all patients in ascending order of Patient ID
     * using an in-order traversal of the tree.
     */
    public void displayInOrder() {
        if (root == null) {
            System.out.println("No patients found.");
            return;
        }

        inOrder(root);
    }

    private void inOrder(PatientNode current) {

        if (current != null) {
            inOrder(current.left);

            System.out.println("----------------------------");
            current.patient.displayPatient();

            inOrder(current.right);
        }
    }

    /**
     * Deletes a patient from the tree by ID, handling all three
     * BST deletion cases: no children, one child, and two children
     * (using the in-order successor).
     */
    public void delete(int patientId) {
        root = deleteRecursive(root, patientId);
    }

    private PatientNode deleteRecursive(PatientNode current, int patientId) {

        if (current == null) {
            System.out.println("Patient not found.");
            return null;
        }

        if (patientId < current.patient.getPatientId()) {
            current.left = deleteRecursive(current.left, patientId);
        } 
        else if (patientId > current.patient.getPatientId()) {
            current.right = deleteRecursive(current.right, patientId);
        } 
        else {

            // Case 1: no left child - replace with right subtree
            if (current.left == null) {
                return current.right;
            }

            // Case 2: no right child - replace with left subtree
            if (current.right == null) {
                return current.left;
            }

            // Case 3: two children - replace with in-order successor
            PatientNode successor = findMinimum(current.right);
            current.patient = successor.patient;
            current.right = deleteRecursive(
                    current.right,
                    successor.patient.getPatientId()
            );
        }

        return current;
    }

    private PatientNode findMinimum(PatientNode current) {

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }
}