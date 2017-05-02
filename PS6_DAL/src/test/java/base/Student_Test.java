package base;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.StudentDomainModel;

public class Student_Test {
	private static StudentDomainModel stu1;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Date myDate = new Date(2017, 05, 02);
		stu1 = new StudentDomainModel("---","---", "-----", myDate);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void AddStudentTest(){
		StudentDomainModel stu;
		stu = StudentDAL.getStudent(stu1.getStudentID());
		assertNull("not in the database", stu);
		
		StudentDAL.addStudent(stu1);
		stu = StudentDAL.getStudent(stu1.getStudentID());
		assertNotNull("in the database", stu);
	}
	@Test
		public void UpdateStudentTest(){
		StudentDomainModel stu;
		
		stu = StudentDAL.getStudent(stu1.getStudentID());
		assertNull("not in the database", stu);
		StudentDAL.addStudent(stu1);
		
		stu1.setFirstName("---");
		StudentDAL.updateStudent(stu1);
		
		stu = StudentDAL.getStudent(stu1.getStudentID());
		assertEquals(stu1.getFirstName(), "---");
	}
	@Test
		public void deleteStudenttest(){
		StudentDomainModel stu;
		StudentDAL.addStudent(stu1);
		stu = StudentDAL.getStudent(stu1.getStudentID());
		assertNotNull("in the database", stu);
		
		StudentDAL.deleteStudent(stu1.getStudentID());
		stu = StudentDAL.getStudent(stu1.getStudentID());
		assertNull("not in the database", stu);
	}
}
