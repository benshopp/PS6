package base;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;

public class Person_Test {

	private static PersonDomainModel per1;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		 LocalDate today = LocalDate.now();
		per1 = new PersonDomainModel();
		per1.setFirstName("xxx");
		per1.setLastName("xxxxxxx");
		per1.setStreet("street address");
		per1.setPostalCode(06300);
		per1.setCity("city");
		per1.setBirthday(today);
	}


	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		// this delete the person we test after each test
		PersonDomainModel per;
		per = PersonDAL.getPerson(per1.getPersonID());
		PersonDAL.deletePerson(per1.getPersonID());
		assertNull("removed",per);
	}



@Test
public void AddPersonTest(){
	PersonDomainModel per;
	per = PersonDAL.getPerson(per1.getPersonID());
	assertNull("not in the database", per);
	
	PersonDAL.addPerson(per1);
	per = PersonDAL.getPerson(per1.getPersonID());
	assertNotNull("in the database", per);
}
@Test
	public void UpdatePersonTest(){
	PersonDomainModel per;
	
	per = PersonDAL.getPerson(per1.getPersonID());
	assertNull("not in the database", per);
	PersonDAL.addPerson(per1);
	
	per1.setFirstName("xxx");
	PersonDAL.updatePerson(per1);
	
	per = PersonDAL.getPerson(per1.getPersonID());
	assertEquals(per1.getFirstName(), "xxx");
}
@Test
	public void deletePersontest(){
	PersonDomainModel per;
	per = PersonDAL.getPerson(per1.getPersonID());
	assertNull("not in the database", per);
	
	PersonDAL.addPerson(per1);
	per = PersonDAL.getPerson(per1.getPersonID());
	assertNotNull("in the database", per);
	
	per1.setFirstName("xxx");
	PersonDAL.updatePerson(per1);
	
	PersonDAL.deletePerson(per1.getPersonID());
	per = PersonDAL.getPerson(per1.getPersonID());
	assertNull("not in the database", per);
}
}