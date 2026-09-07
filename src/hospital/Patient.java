package hospital;

/**
 * Represents a single hospital patient.
 * Each Patient stores their personal/medical details along with
 * their own Visit History (a singly linked list of past visits),
 * so that visit records are kept separately per patient.
 */
public class Patient {

    private int patientId;
    private String patientName;
    private int age;
    private String contactNumber;
    private String medicalCondition;

    private VisitHistory visitHistory;

    /**
     * Creates a new Patient record.
     *
     * @param patientId         unique identifier used as the BST key
     * @param patientName       full name of the patient
     * @param age               patient's age
     * @param contactNumber     phone number for contact
     * @param medicalCondition  current medical condition/notes
     */
    public Patient(int patientId, String patientName, int age,
                   String contactNumber, String medicalCondition) {

        this.patientId = patientId;
        this.patientName = patientName;
        this.age = age;
        this.contactNumber = contactNumber;
        this.medicalCondition = medicalCondition;

        // Every patient gets their own independent visit history list.
        this.visitHistory = new VisitHistory();
    }

    public int getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public int getAge() {
        return age;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getMedicalCondition() {
        return medicalCondition;
    }

    /**
     * @return this patient's personal Visit History linked list.
     */
    public VisitHistory getVisitHistory() {
        return visitHistory;
    }

    /**
     * Prints this patient's details to the console.
     */
    public void displayPatient() {

        System.out.println("Patient ID: " + patientId);
        System.out.println("Patient Name: " + patientName);
        System.out.println("Age: " + age);
        System.out.println("Contact Number: " + contactNumber);
        System.out.println("Medical Condition: " + medicalCondition);
    }
}