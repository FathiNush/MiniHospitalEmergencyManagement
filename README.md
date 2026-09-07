# Mini Hospital Emergency Management System

CIT300 - Data Structures and Algorithms - Individual Mid Assignment

## Project Overview

This is a console-based Java application that simulates the core
operations of a hospital's emergency management system. It manages
patient registration, emergency treatment queuing, treatment history,
and per-patient visit history, using four required data structures.

The system is menu-driven: the user selects a numbered option to
perform an operation, and the program loops until the user chooses
to exit.

## Data Structures Used

| Requirement | Data Structure | Where implemented |
|---|---|---|
| Patient Records | Binary Search Tree (BST), keyed by Patient ID | `PatientBST.java`, `PatientNode.java` |
| Emergency Patient Queue | Queue (FIFO) | `EmergencyQueue.java` |
| Treatment History | Stack (LIFO) | `TreatmentStack.java`, `TreatmentRecord.java` |
| Patient Visit History | Singly Linked List, one per patient | `VisitHistory.java`, `VisitNode.java`, `Visit.java` |

### Patient Records - Binary Search Tree
Each `Patient` is inserted into a BST using their Patient ID as the
key. Supports insert, search, delete (including the two-children
case using the in-order successor), and an in-order traversal that
displays all patients in ascending Patient ID order.

### Emergency Patient Queue
Patients waiting for emergency treatment are stored in a `Queue`
(backed by `LinkedList`). Supports enqueue, dequeue, displaying all
waiting patients, and safely handles an empty queue without crashing.

### Treatment History - Stack
Once a treatment is recorded, it is pushed onto a `Stack`. Supports
push, pop (removing the most recently completed treatment first),
displaying the full history most-recent-first, and safely handles
an empty stack.

### Patient Visit History - Singly Linked List
Each `Patient` object owns its own `VisitHistory`, a singly linked
list of `Visit` records. This means every patient's visit history is
kept completely separate from every other patient's. Supports adding
a visit, removing a visit by ID, searching for a visit by ID, and
displaying the full history.

## How to Run

1. Clone or download this repository.
2. Open the project in Eclipse IDE (File > Import > Existing Projects
   into Workspace).
3. Run `Main.java` (it contains the `main` method).
4. Use the on-screen numbered menu to interact with the system.

Requires Java (JDK 17 or later recommended).

## Menu Options

```
1. Add Patient
2. Search Patient
3. Delete Patient
4. Display All Patients
5. Add Emergency Patient
6. Treat Next Patient
7. Display Emergency Queue
8. Add Treatment Record
9. Remove Latest Treatment
10. Display Treatment History
11. Add Patient Visit
12. Search Visit
13. Remove Visit
14. Display Visit History
0. Exit
```

## Notes on Data Persistence

This system stores all data in memory only, as required by the
assignment scope. Data does not persist between separate runs of the
program — all patients, queue entries, treatment records, and visit
histories are reset when the program restarts.

## Input Validation

All numeric menu and ID inputs are validated so that non-numeric
input (letters, blank input, decimals) does not crash the program;
the user is re-prompted instead. Text fields reject blank input.
Duplicate Patient IDs and duplicate Visit IDs (per patient) are
rejected with a clear message.

## Testing

See `TESTING.md` for the manual test checklist covering every
required operation across all four data structures, plus empty-state
and invalid-input handling.

## Technologies

- Java
- Eclipse IDE

## Author

Nusha (FathiNush)