import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions.*;
import java.io.*;

public class MedicalCentreTest {

	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@BeforeEach
	public void setOut() {
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	@Test
	@DisplayName("processQueue test with no patients, expected true")
	public void processQueueTestWithNoPatients() {
		MedicalCentre mc = new MedicalCentre();
		mc.processQueue("processQueueTestNoPatients.txt");
	 	String actual = outputStreamCaptor.toString().trim();
		Assertions.assertEquals(actual, "");
	}

	@Test
	@DisplayName("processQueue test with one patient, expected true")
	public void processQueueTestOnePatients() {
		MedicalCentre mc = new MedicalCentre();
		mc.processQueue("processQueueTestOnePatients.txt");
	 	String actual = outputStreamCaptor.toString().trim();
		Assertions.assertEquals(actual, "Priority: 3, Name: Michael Howard, Age: 9, Medical severity level: low, Patient number: 1");
	}

	@Test
	@DisplayName("processQueue test with more patients, expected true")
	public void processQueueTestWithMorePatients() {
		MedicalCentre mc = new MedicalCentre();
		mc.processQueue("patients_small.txt");
	 	String actual = outputStreamCaptor.toString().trim();
		Assertions.assertEquals(actual, "Priority: 1, Name: Amanda Lopez, Age: 91, Medical severity level: medium, Patient number: 2"
								+ System.lineSeparator() + "Priority: 1, Name: Jesse Curry, Age: 7, Medical severity level: high, Patient number: 3"
								+ System.lineSeparator() + "Priority: 2, Name: John Schmidt, Age: 25, Medical severity level: medium, Patient number: 4"
								+ System.lineSeparator() + "Priority: 3, Name: Michael Howard, Age: 9, Medical severity level: low, Patient number: 1"
								+ System.lineSeparator() + "Priority: 3, Name: Emily Hughes, Age: 84, Medical severity level: low, Patient number: 5");
	}
}