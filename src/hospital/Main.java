package hospital;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static PatientBST patientBST = new PatientBST();
    static EmergencyQueue emergencyQueue = new EmergencyQueue();
    static TreatmentStack treatmentStack = new TreatmentStack();

    public static void main(String[] args) {

        int choice;

        do {

            displayMenu();

            choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addPatient();
                    break;

                case 2:
                    searchPatient();
                    break;

                case 3:
                    deletePatient();
                    break;

                case 4:
                    patientBST.displayInOrder();
                    break;

                case 5:
                    addEmergencyPatient();
                    break;

                case 6:
                    emergencyQueue.dequeue();
                    break;

                case 7:
                    emergencyQueue.displayQueue();
                    break;

                case 8:
                    addTreatment();
                    break;

                case 9:
                    treatmentStack.pop();
                    break;

                case 10:
                    treatmentStack.displayStack();
                    break;

                case 11:
                    addVisit();
                    break;

                case 12:
                    searchVisit();
                    break;

                case 13:
                    removeVisit();
                    break;

                case 14:
                    displayPatientVisitHistory();
                    break;

                case 0:
                    System.out.println("Thank you for using the system.");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number from the menu.");
            }

        } while (choice != 0);

        scanner.close();
    }

    // ---------- Input helper methods ----------

    /**
     * Reads an integer safely. Keeps re-prompting until a valid
     * whole number is entered, so the program never crashes on
     * bad input (e.g. letters, blank lines, decimals).
     */
    public static int readInt(String prompt) {

        while (true) {

            System.out.print(prompt);

            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine(); // consume leftover newline
                return value;
            } else {
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.nextLine(); // discard the bad token
            }
        }
    }

    /**
     * Reads a non-empty line of text. Keeps re-prompting if the
     * user enters nothing, since blank names/dates/etc. would
     * otherwise silently corrupt records.
     */
    public static String readNonEmptyLine(String prompt) {

        while (true) {

            System.out.print(prompt);
            String value = scanner.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println("This field cannot be empty. Please try again.");
        }
    }

    // ---------- Menu ----------

    public static void displayMenu() {

        System.out.println("\n==============================================");
        System.out.println(" MINI HOSPITAL EMERGENCY MANAGEMENT SYSTEM");
        System.out.println("==============================================");
        System.out.println("1. Add Patient");
        System.out.println("2. Search Patient");
        System.out.println("3. Delete Patient");
        System.out.println("4. Display All Patients");
        System.out.println("5. Add Emergency Patient");
        System.out.println("6. Treat Next Patient");
        System.out.println("7. Display Emergency Queue");
        System.out.println("8. Add Treatment Record");
        System.out.println("9. Remove Latest Treatment");
        System.out.println("10. Display Treatment History");
        System.out.println("11. Add Patient Visit");
        System.out.println("12. Search Visit");
        System.out.println("13. Remove Visit");
        System.out.println("14. Display Visit History");
        System.out.println("0. Exit");
        System.out.println("==============================================");
    }

    // ---------- Patient (BST) ----------

    public static void addPatient() {

        int id = readInt("Enter Patient ID: ");

        if (id <= 0) {
            System.out.println("Patient ID must be a positive number. Patient not added.");
            return;
        }

        if (patientBST.search(id) != null) {
            System.out.println("Patient ID already exists. Patient not added.");
            return;
        }

        String name = readNonEmptyLine("Enter Patient Name: ");

        int age = readInt("Enter Age: ");

        if (age <= 0 || age > 150) {
            System.out.println("Age must be a realistic positive number. Patient not added.");
            return;
        }

        String contact = readNonEmptyLine("Enter Contact Number: ");
        String condition = readNonEmptyLine("Enter Medical Condition: ");

        Patient patient = new Patient(
                id, name, age, contact, condition
        );

        patientBST.insert(patient);

        System.out.println("Patient added successfully.");
    }

    public static void searchPatient() {

        int id = readInt("Enter Patient ID to search: ");

        Patient patient = patientBST.search(id);

        if (patient != null) {
            System.out.println("\nPatient Found:");
            patient.displayPatient();
        } else {
            System.out.println("Patient not found.");
        }
    }

    public static void deletePatient() {

        int id = readInt("Enter Patient ID to delete: ");

        if (patientBST.search(id) == null) {
            System.out.println("Patient not found. Nothing was deleted.");
            return;
        }

        patientBST.delete(id);
        System.out.println("Delete operation completed.");
    }

    // ---------- Emergency Queue ----------

    public static void addEmergencyPatient() {

        int id = readInt("Enter Patient ID: ");

        Patient patient = patientBST.search(id);

        if (patient != null) {
            emergencyQueue.enqueue(patient);
        } else {
            System.out.println("Patient not found in patient records.");
        }
    }

    // ---------- Treatment Stack ----------

    public static void addTreatment() {

        int id = readInt("Enter Patient ID: ");

        Patient patient = patientBST.search(id);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        String treatment = readNonEmptyLine("Enter Treatment: ");
        String doctor = readNonEmptyLine("Enter Doctor Name: ");

        TreatmentRecord record = new TreatmentRecord(
                patient.getPatientId(),
                patient.getPatientName(),
                treatment,
                doctor
        );

        treatmentStack.push(record);
    }

    // ---------- Visit History (Linked List, per patient) ----------

    public static void addVisit() {

        int patientId = readInt("Enter Patient ID: ");

        Patient patient = patientBST.search(patientId);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        int visitId = readInt("Enter Visit ID: ");

        if (patient.getVisitHistory().searchVisit(visitId) != null) {
            System.out.println("A visit with this ID already exists for this patient.");
            return;
        }

        String date = readNonEmptyLine("Enter Visit Date: ");
        String doctor = readNonEmptyLine("Enter Doctor Name: ");
        String diagnosis = readNonEmptyLine("Enter Diagnosis: ");
        String treatment = readNonEmptyLine("Enter Treatment: ");

        Visit visit = new Visit(
                visitId,
                date,
                doctor,
                diagnosis,
                treatment
        );

        patient.getVisitHistory().addVisit(visit);

        System.out.println("Visit added to Patient ID " + patientId);
    }

    public static void searchVisit() {

        int patientId = readInt("Enter Patient ID: ");

        Patient patient = patientBST.search(patientId);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        int visitId = readInt("Enter Visit ID to search: ");

        Visit visit = patient.getVisitHistory().searchVisit(visitId);

        if (visit != null) {
            System.out.println("\nVisit Found:");
            visit.displayVisit();
        } else {
            System.out.println("Visit not found.");
        }
    }

    public static void removeVisit() {

        int patientId = readInt("Enter Patient ID: ");

        Patient patient = patientBST.search(patientId);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        int visitId = readInt("Enter Visit ID to remove: ");

        patient.getVisitHistory().removeVisit(visitId);
    }

    public static void displayPatientVisitHistory() {

        int patientId = readInt("Enter Patient ID: ");

        Patient patient = patientBST.search(patientId);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.println("\nVisit History for Patient:");
        patient.displayPatient();

        System.out.println("\nPrevious Visits:");
        patient.getVisitHistory().displayHistory();
    }
}