package hospital;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Manages patients waiting in the emergency unit using a Queue.
 * Follows FIFO (First-In, First-Out): the first patient enqueued
 * is always the first one dequeued for treatment.
 */
public class EmergencyQueue {

    private Queue<Patient> queue = new LinkedList<>();

    /**
     * Adds a patient to the back of the waiting queue.
     */
    public void enqueue(Patient patient) {
        queue.add(patient);
        System.out.println("Patient added to emergency queue.");
    }

    /**
     * Removes and returns the patient at the front of the queue
     * (the next patient due for treatment).
     * Handles the empty-queue case gracefully instead of throwing
     * an exception.
     */
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

    /**
     * Displays every patient currently waiting, in queue order.
     */
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
