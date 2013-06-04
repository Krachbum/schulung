import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class MitarbeiterTest {
	protected Mitarbeiter testInstance;
	
	@Before
	public void setUp() {
		testInstance =  new Mitarbeiter(1, "Titel", "Vorname", "Nachname");
	}

	@Test
	public void testConstructor() {
		assertEquals(1, testInstance.getMaNr());
		assertEquals("Titel", testInstance.getTitel());
		assertEquals("Vorname", testInstance.getVorname());
		assertEquals("Nachname", testInstance.getNachname());
		assertEquals(Mitarbeiter.class, testInstance.getClass());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorWithHugeMaNr() {
		testInstance =  new Mitarbeiter(Integer.MAX_VALUE+1, "Titel", "Vorname", "Nachname");
	}

	@Test
	public void testGetMaNr() {
		assertEquals(1, testInstance.getMaNr());
	}

	@Test
	public void testSetGetTitel() {
		testInstance.setTitel("NewTitle");
		assertEquals("NewTitle", testInstance.getTitel());
	}
	
	@Test
	public void testSetGetTitelWithNull() {
		testInstance.setTitel(null);
		assertNull(testInstance.getTitel());
	}
	
	@Test
	public void testSetGetTitelWithNone() {
		testInstance.setTitel("");
		assertEquals("", testInstance.getTitel());
	}

	@Test
	public void testSetGetVorname() {
		testInstance.setVorname("Hugo");
		assertEquals("Hugo", testInstance.getVorname());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetGetVornameWithNull() {
		testInstance.setVorname(null);
	}

	@Test
	public void testSetGetNachname() {
		testInstance.setNachname("Meier");
		assertEquals("Meier", testInstance.getNachname());
	}
	
	@Test
	public void testSetGetNachnameWithNull() {
		testInstance.setNachname(null);
		assertNull(testInstance.getNachname());
	}

	@Test
	public void testSetGetNachnameWithNone() {
		testInstance.setNachname("");
		assertEquals("", testInstance.getNachname());
	}
}
