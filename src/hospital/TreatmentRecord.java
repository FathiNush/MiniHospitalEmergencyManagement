package hospital;

/**
 * Represents a single completed treatment for a patient.
 * These records are stored in a TreatmentStack (LIFO order).
 */
public class TreatmentRecord {

    private int patientId;
    private String patientName;
    private String treatment;
    private String doctorName;

    public TreatmentRecord(int patientId, String patientName,
                           String treatment, String doctorName) {

        this.patientId = patientId;
        this.patientName = patientName;
        this.treatment = treatment;
        this.doctorName = doctorName;
    }

    /**
     * Prints this treatment record's details to the console.
     */
    public void displayRecord() {

        System.out.println("Patient ID: " + patientId);
        System.out.println("Patient Name: " + patientName);
        System.out.println("Treatment: " + treatment);
        System.out.println("Doctor: " + doctorName);
    }
}