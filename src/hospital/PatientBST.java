package hospital;

public class PatientBST {

    private PatientNode root;

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

            if (current.left == null) {
                return current.right;
            }

            if (current.right == null) {
                return current.left;
            }

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
