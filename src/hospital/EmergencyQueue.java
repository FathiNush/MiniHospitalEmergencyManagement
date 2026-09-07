package hospital;

import java.util.LinkedList;
import java.util.Queue;

public class EmergencyQueue {

    private Queue<Patient> queue = new LinkedList<>();

    public void enqueue(Patient patient) {
        queue.add(patient);
        System.out.println("Patient added to emergency queue.");
    }

    public Patient dequeue() {

        if (queue.isEmpty()) {
            System.out.println("Emergency queue is empty.");
            return null;
        }

        Patient patient = queue.remove();

        System.out.println("Next patient selected for treatment:");
        patient.displayPatient();

        return patient;
    }

    public void displayQueue() {

        if (queue.isEmpty()) {
            System.out.println("Emergency queue is empty.");
            return;
        }

        System.out.println("Patients Waiting:");

        for (Patient patient : queue) {
            System.out.println("----------------------------");
            patient.displayPatient();
        }
    }
}
