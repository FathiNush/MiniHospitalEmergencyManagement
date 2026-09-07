# Testing Notes

This document records manual testing performed on the Mini Hospital
Emergency Management System, covering every required operation for
each data structure.

## How to test
Run `Main.java` and use the numbered menu to exercise each operation
below, in the same session (data is stored in memory and does not
persist between runs).

## 1. Patient Records (BST)
- [ ] Add multiple patients with different IDs (option 1)
- [ ] Add a patient with a duplicate ID -> should be rejected
- [ ] Search for an existing Patient ID (option 2) -> found
- [ ] Search for a non-existent Patient ID (option 2) -> not found
- [ ] Display all patients (option 4) -> shown in ascending ID order
- [ ] Delete a patient (option 3) -> confirm they no longer appear
      in the in-order display
- [ ] Delete a non-existent Patient ID -> handled gracefully

## 2. Emergency Queue
- [ ] Add an existing patient to the emergency queue (option 5)
- [ ] Display the queue (option 7) -> patients shown in the order added
- [ ] Treat next patient (option 6) -> removes the first patient added (FIFO)
- [ ] Treat next patient when queue is empty -> handled gracefully,
      no crash

## 3. Treatment Stack
- [ ] Add a treatment record for a patient (option 8)
- [ ] Add a second treatment record for the same or another patient
- [ ] Display treatment history (option 10) -> most recent shown first
- [ ] Remove latest treatment (option 9) -> removes the most recently
      added record (LIFO)
- [ ] Remove latest treatment when stack is empty -> handled
      gracefully, no crash

## 4. Patient Visit History (Singly Linked List)
- [ ] Add a visit to a patient (option 11)
- [ ] Add a second visit to the same patient
- [ ] Add a visit with a duplicate Visit ID for the same patient ->
      rejected
- [ ] Search for a visit by ID (option 12) -> found
- [ ] Search for a visit that doesn't exist -> not found
- [ ] Display a patient's visit history (option 14) -> all visits shown
- [ ] Remove a visit (option 13) -> confirm it no longer appears in
      the history display
- [ ] Confirm a different patient's visit history is unaffected
      (visits are stored per patient, not globally)

## 5. Input Validation
- [ ] Enter a letter instead of a number at the main menu -> program
      re-prompts instead of crashing
- [ ] Enter a letter instead of a number for any ID prompt -> program
      re-prompts instead of crashing
- [ ] Leave a text field (name, date, etc.) blank -> program
      re-prompts instead of accepting empty input

## Result
All operations above were tested manually and behaved as expected,
including empty-structure handling (empty queue, empty stack, empty
visit history) and invalid input handling (non-numeric input, blank
fields, duplicate IDs).