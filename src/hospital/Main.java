package hospital;

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

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

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
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        scanner.close();
    }

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

    public static void addPatient() {

        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Contact Number: ");
        String contact = scanner.nextLine();

        System.out.print("Enter Medical Condition: ");
        String condition = scanner.nextLine();

        Patient patient = new Patient(
                id, name, age, contact, condition
        );

        patientBST.insert(patient);

        System.out.println("Patient added successfully.");
    }

    public static void searchPatient() {

        System.out.print("Enter Patient ID to search: ");
        int id = scanner.nextInt();

        Patient patient = patientBST.search(id);

        if (patient != null) {
            System.out.println("\nPatient Found:");
            patient.displayPatient();
        } 
        else {
            System.out.println("Patient not found.");
        }
    }

    public static void deletePatient() {

        System.out.print("Enter Patient ID to delete: ");
        int id = scanner.nextInt();

        patientBST.delete(id);
        System.out.println("Delete operation completed.");
    }

    public static void addEmergencyPatient() {

        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();

        Patient patient = patientBST.search(id);

        if (patient != null) {
            emergencyQueue.enqueue(patient);
        } 
        else {
            System.out.println("Patient not found in patient records.");
        }
    }

    public static void addTreatment() {

        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Patient patient = patientBST.search(id);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.print("Enter Treatment: ");
        String treatment = scanner.nextLine();

        System.out.print("Enter Doctor Name: ");
        String doctor = scanner.nextLine();

        TreatmentRecord record = new TreatmentRecord(
                patient.getPatientId(),
                patient.getPatientName(),
                treatment,
                doctor
        );

        treatmentStack.push(record);
    }

    public static void addVisit() {

        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();

        Patient patient = patientBST.search(patientId);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.print("Enter Visit ID: ");
        int visitId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Visit Date: ");
        String date = scanner.nextLine();

        System.out.print("Enter Doctor Name: ");
        String doctor = scanner.nextLine();

        System.out.print("Enter Diagnosis: ");
        String diagnosis = scanner.nextLine();

        System.out.print("Enter Treatment: ");
        String treatment = scanner.nextLine();

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

        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();

        Patient patient = patientBST.search(patientId);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.print("Enter Visit ID to search: ");
        int visitId = scanner.nextInt();

        Visit visit = patient.getVisitHistory().searchVisit(visitId);

        if (visit != null) {

            System.out.println("\nVisit Found:");
            visit.displayVisit();

        } else {

            System.out.println("Visit not found.");
        }
    }
    public static void removeVisit() {

        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();

        Patient patient = patientBST.search(patientId);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.print("Enter Visit ID to remove: ");
        int visitId = scanner.nextInt();

        patient.getVisitHistory().removeVisit(visitId);
    }
  
        public static void displayPatientVisitHistory() {

            System.out.print("Enter Patient ID: ");
            int patientId = scanner.nextInt();

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
   