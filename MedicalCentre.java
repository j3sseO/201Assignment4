import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Medical Centre class
 *
 * The MedicalCentre class stores an operation
 * called processQueue.
 */
public class MedicalCentre {

	/**
	 * processQueue(String fileName)
	 * Method that takes patient details from a file
	 * and inserts it into the priority queue, putting
	 * patients that need urgent care at the front of
	 * the queue. The order of patients are then printed
	 * out as they are removed.
	 * @param fileName, name of file with patient details
	 */
	public void processQueue(String fileName) {
		try {
			File file = new File(fileName);
			Scanner sc = new Scanner(file);
			
			// Get how many patients are in file
			int capacity = 0;
			while (sc.hasNextLine()) {
				capacity++;
				sc.nextLine();
			}
			
			// Reset Scanner object
			sc.reset();
			sc = new Scanner(file);

			// Create PriorityQueue object
			PriorityQueue queue = new PriorityQueue(capacity);

			// Initialise count for patient numbers
			int count = 0;

			while (sc.hasNextLine()) {
				// Increment patient number count
				count++;

				// Split patient details at comma, and insert into array 
				String[] line = sc.nextLine().split(",");
				
				// Set priority based off severity and age of patient
				int priority = 0;
				if (line[2].equals("low")) {
					priority = 3;
				}
				else if (line[2].equals("medium") && Integer.parseInt(line[1]) < 65) {
					priority = 2;
				}
				else if (line[2].equals("medium") && Integer.parseInt(line[1]) > 65) {
					priority = 1;
				}
				else {
					priority = 1;
				}

				// Create new patient
				Patient patient = new Patient(line[0], line[2], Integer.parseInt(line[1]), priority);
				// Set patient number to number of patients in queue
				patient.patientNumber = count;
				// Insert patient into queue
				queue.insert(patient);
			}

			// Print out patient details
			for (int i = 0; i < capacity; i++) {
				// Cast Node return fro delete method into Patient object
				Patient p = (Patient) queue.delete();
				System.out.println(p.toStringLong());
			}	

 		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

}