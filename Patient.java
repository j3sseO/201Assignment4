/**
 * Patient class
 *
 * The Patient class is a sublass of Node and
 * holds the name, severity, age, and patient
 * number
 */
public class Patient extends Node {

	//Patient name
	String name;

	// Severity of injury
	String severity;
	
	// Age of patient
	int age;

	// Patient number
	int patientNumber = 1;

	/**
	 * Patient constructor
	 */
	public Patient(String name, String severity, int age, int priority) {
		super(priority);
		this.name = name;
		this.severity = severity;
		this.age = age;
		this.patientNumber = patientNumber;
		
	}

	/**`
	 * toString()
	 * toString method that returns the priority
	 * and name of the Patient
	 * @return String, String value of Patient
	 */
	public String toString() {
		return "Priority: " + priority + ", Name: " + name;
	}

	/**
	 * toStringLong()
	 * toString method that returns the priority, name, 
	 * age, severity, and patient number as a String
	 * @return String, String value of Patient
	 */
	public String toStringLong() {
		return toString() +  ", Age: " + age + ", Medical severity level: "
				+ severity + ", Patient number: " + patientNumber;
	}

}