package com.accenture.adf.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.accenture.adf.businesstier.dao.VisitorDAO;
import com.accenture.adf.businesstier.entity.Event;
import com.accenture.adf.businesstier.entity.Visitor;
import com.accenture.adf.helper.FERSDataConnection;

/**
 * JUnit test case for VisitorDAO class for testing all repository methods to
 * call database sub-routines
 * 
 */
public class TestVisitorDAO {

	private Visitor visitor;
	private VisitorDAO visitorDAO;
	private ArrayList<Object[]> registeredEvents;
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;
	/**
	 * Setting up initial objects
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		visitor = new Visitor();
		visitorDAO = new VisitorDAO();
		registeredEvents = new ArrayList<Object[]>();
	}

	/**
	 * Deallocating objects after execution of every method
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		/**
		 * @TODO: Release all the objects here by assigning them null  
		 */
	}

	/**
	 * Test case for method insertData
	 */
	@Test
	public void testInsertData() {
		/**
		 * @TODO: Create visitor object by setting appropriate values
		 * Call insertData method by passing this visitor object
		 * Search this new visitor object by calling searchUser method
		 * Assert the values of username
		 */		
	}	

	/**
	 * Test case for method searchUser
	 */
	@Test
	public void testSearchUser() {
		/**
		 * @TODO: Call searchUser method for valid values of username
		 * and password and assert the value of username for the returned type of method
		 */		
	}

	/**
	 * Test case for method registerVisitorToEvent
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testRegisterVisitorToEvent() throws ClassNotFoundException, SQLException {
		/**
		 * @TODO: Fetch visitor object by calling searchUser for valid values of username and password
		 * Pass this visitor object and valid eventid to registerVisitorToEvent method
		 * and assert the value
		 */	
		
		try {
			 visitor= visitorDAO.searchUser("bsmith", "password");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			visitorDAO.registerVisitorToEvent(visitor, 1001, 10001);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String qry="select count(*) from eventsessionsignup where visitorid=? and eventsessionid=10001 and eventid=1001";
		connection=FERSDataConnection.createConnection();
		statement=connection.prepareStatement(qry);
		statement.setInt(1, visitor.getVisitorId());
		resultSet=statement.executeQuery();
		resultSet.next();
		//System.out.println(resultSet.getInt(1));
		int ret= resultSet.getInt(1);
		assertEquals(ret,1);
		
	}	

	/**
	 * Test case for method registeredEvents
	 */
	@Test
	public void testRegisteredEvents() {
		/**
		 * @TODO: Fetch visitor object by calling searchUser for valid values of username and password
		 * Pass this visitor object and valid eventid to registeredEvents method
		 * and assert the value
		 */		
		 Visitor v=new Visitor(); 
		 ArrayList<Object[]> arr=new ArrayList<Object[]>(); 
			try {
				 v=visitorDAO.searchUser("bsmith", "password");
				 System.out.println(v.getVisitorId());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				arr=visitorDAO.registeredEvents(v)	;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			assertEquals(2,arr.size());
	}

	/**
	 * Test case for method updateVisitor
	 */
	@Test
	public void testUpdateVisitor() {
		/**
		 * @TODO: Fetch visitor object by calling searchUser for valid values of username and password
		 * Update the value in this visitor object
		 * Pass this visitor object to updateVisitor method
		 * and assert the value of changed value
		 */		
		Visitor v=new Visitor();
		int retval=0;
		try {
			 v=visitorDAO.searchUser("bsmith", "password");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(v!=null)
		{
			try {
			 retval=visitorDAO.updateVisitor(v);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		assertEquals(1, retval);
	}

	/**
	 * Test case for method registeredEvents
	 */
	@Test
	public void testUnregisterEvent() {
		/**
		 * @TODO: Fetch visitor object by calling searchUser for valid values of username and password
		 * Pass this visitor object and valid eventid to unregisterEvent method
		 * and assert the value
		 */		
		 int status = 1;
		 try {
			 visitor = visitorDAO.searchUser("bsmith", "password");
		try {
			visitorDAO.unregisterEvent(visitor, 1001,10001);;
			String qry = "SELECT COUNT(*) AS EVENTCOUNT FROM EVENTSESSIONSIGNUP WHERE EVENTID=1001 AND VISITORID=1001 AND EVENTSESSIONID=10001 ;";
			connection = FERSDataConnection.createConnection();
			statement = connection.prepareStatement(qry);
			resultSet = statement.executeQuery();
			resultSet.next();
			status = resultSet.getInt(1);
			System.out.println(status);
			}
			catch (Exception e) {

		// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {

		// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {

		// TODO Auto-generated catch block
			e.printStackTrace();

		}
		 assertEquals(0, status);

		}
	
	
	/**
	 * Test case for method change password
	 */
	/*@Test
	public void testChangePassword_VisitorNull() {
		*//**
		 * @TODO: Call changePassword method by passing visitor object as null
		 *//*		
	}*/
	
	/**
	 * Test case for method change password
	 */
	@Test
	public void testChangePassword_VisitorNull() {
		try {
			visitor = null;
			visitorDAO.changePassword(visitor);
		} catch (SQLException exception) {
			fail("SQL Exception");
		} catch (ClassNotFoundException exception) {
			fail("Class Not Found Exception");
		} catch (Exception exception) {
			fail("NULL Exception");
		}
	}

}
