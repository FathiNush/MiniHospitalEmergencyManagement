package hospital;

/**
 * Represents a single hospital visit for a patient.
 * Visit objects are stored inside a patient's VisitHistory
 * (a singly linked list) so each patient keeps their own record
 * of past visits.
 */
public class Visit {

    private int visitId;
    private String visitDate;
    private String doctorName;
    private String diagnosis;
    private String treatment;

    public Visit(int visitId, String visitDate, String doctorName,
                 String diagnosis, String treatment) {

        this.visitId = visitId;
        this.visitDate = visitDate;
        this.doctorName = doctorName;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    public int getVisitId() {
        return visitId;
    }

    /**
     * Prints this visit's details to the console.
     */
    public void displayVisit() {

        System.out.println("Visit ID: " + visitId);
        System.out.println("Visit Date: " + visitDate);
        System.out.println("Doctor: " + doctorName);
        System.out.println("Diagnosis: " + diagnosis);
        System.out.println("Treatment: " + treatment);
    }
}