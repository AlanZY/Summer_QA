
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.mockito.*;


public class CitySim9002Test {

@SuppressWarnings("unchecked")
	
	@Mock
	Visitors mockedLinkedList = Mockito.mock(Visitors.class);
	Visitors mockvisitors = Mockito.mock(Visitors.class);
	

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(mockedLinkedList);
		MockitoAnnotations.initMocks(mockvisitors);
	}

	@After
	public void tearDown() throws Exception {
		// any necessary tear down - none needed here
	}	
	
	//--------------------------------------------------------
	//               LinkedList tests 
	//--------------------------------------------------------
	
	// test whether the LinkedList is created successfully
	// visitor LinkedList
	@Test
	public void testgen_visitors()
	{
		LinkedList<String> test2 = new LinkedList<String>();
		Node<String> blogger = new Node<String>("Blogger");
		Node<String> professor = new Node<String>("Professor");
		Node<String> business = new Node<String>("Bussiness Person");
		Node<String> student = new Node<String>("Student");
		test2.addToEnd(professor);
		test2.addToEnd(business);
		test2.addToEnd(student);
		test2.addToEnd(blogger);
		
		CitySim9002 citysim = new CitySim9002();
		Visitors mockedvisitors = Mockito.mock(Visitors.class);
		Mockito.when(mockedvisitors.gen_visitors()).thenReturn(test2);	
		LinkedList<String> result = citysim.gen_visitors(mockedvisitors);
		assertTrue(test2.equals(result));
	}
	
    // locations LinkedList
	@Test
	public void testgen_locations()
	{
		LinkedList<String> test = new LinkedList<String>();
		Node<String> cathdral = new Node<String>(" The Cathedral of Learning");
		Node<String> squirhill = new Node<String>("Squirrel Hill");
		Node<String> point = new Node<String>("The Point");
		Node<String> downtown = new Node<String>("Downtown");
		Node<String> left = new Node<String>("left");
		test.addToEnd(left);	
		test.addToEnd(downtown);
		test.addToEnd(point);
		test.addToEnd(squirhill);
		test.addToEnd(cathdral);
		
		CitySim9002 citysim = new CitySim9002();
		Locations mockedlocations = Mockito.mock(Locations.class);
		Mockito.when(mockedlocations.gen_locations()).thenReturn(test);	
		Mockito.when(mockedlocations.kthToLast(1)).thenReturn("Squirrel Hill");
		String result = citysim.get_location(1,mockedlocations);
		assertSame(result,"Squirrel Hill");
	}
	
	//--------------------------------------------------------
	//               get item tests 
	//--------------------------------------------------------
	
	// test whether we can get one item from LinkedList
	// this method is based on kthToLast
	// call the method, it should return the item that there are k items
	// between it and the last one
	// visitor LinkedList
	@Test
	public void testget_visitor()
	{
		LinkedList<String> test = new LinkedList<String>();
		Node<String> blogger = new Node<String>("Blogger");
		Node<String> professor = new Node<String>("Professor");
		Node<String> business = new Node<String>("Bussiness Person");
		Node<String> student = new Node<String>("Student");
		test.addToEnd(student);
		test.addToEnd(business);
		test.addToEnd(professor);
		test.addToEnd(blogger);
		
		CitySim9002 citysim = new CitySim9002();
		Visitors mockedvisitors = Mockito.mock(Visitors.class);
		Mockito.when(mockedvisitors.gen_visitors()).thenReturn(test);	
		Mockito.when(mockedvisitors.kthToLast(1)).thenReturn("Professor");
		String result = citysim.get_visitor(1,mockedvisitors);
		assertEquals("Professor",result);
	}

	// location LinkedList
	@Test
	public void testget_location()
	{
		LinkedList<String> test = new LinkedList<String>();
		Node<String> cathdral = new Node<String>("The Cathedral of Learning");
		Node<String> squirhill = new Node<String>("Squirrel Hill");
		Node<String> point = new Node<String>("The Point");
		Node<String> downtown = new Node<String>("Downtown");
		Node<String> left = new Node<String>("left");
		test.addToEnd(left);	
		test.addToEnd(downtown);
		test.addToEnd(point);
		test.addToEnd(squirhill);
		test.addToEnd(cathdral);
		
		CitySim9002 citysim = new CitySim9002();
		Locations mockedlocations = Mockito.mock(Locations.class);
		Mockito.when(mockedlocations.gen_locations()).thenReturn(test);	
		Mockito.when(mockedlocations.kthToLast(2)).thenReturn("Squirrel Hill");
		String result = citysim.get_location(2,mockedlocations);
		assertFalse(result.equals("Squirrel Hill"));
		
	}
	
	//--------------------------------------------------------
	//               check preference tests 
	//--------------------------------------------------------
	
	// the output of this check_preference function should be 0 or 1
	@Test
	public void testcheck_like_business()
	{
		CitySim9002 citysim = new CitySim9002();
		Visitors mockedvisitors = Mockito.mock(Visitors.class);
		int returnlike = citysim.check_like_business("The Point", mockedvisitors);
		assertTrue((returnlike == 1)||(returnlike == 0));
	}
	
	@Test
	public void testcheck_like_blogger()
	{
		CitySim9002 citysim = new CitySim9002();
		Visitors mockedvisitors = Mockito.mock(Visitors.class);
		int returnlike = citysim.check_like_blogger("The Point", mockedvisitors);
		assertTrue((returnlike == 0));
	}
	
	@Test
	public void testcheck_like_student()
	{
		CitySim9002 citysim = new CitySim9002();
		Visitors mockedvisitors = Mockito.mock(Visitors.class);
		int returnlike = citysim.check_like_student("The Cathedral of Learning", mockedvisitors);
		assertEquals(returnlike,0);
	}
	
	@Test
	public void testcheck_like_professor()
	{
		CitySim9002 citysim = new CitySim9002();
		Visitors mockedvisitors = Mockito.mock(Visitors.class);
		int returnlike = citysim.check_like_professor("The Cathedral of Learning", mockedvisitors);
		assertFalse(returnlike==9);
	}
	
	//--------------------------------------------------------
	//               random tests 
	//--------------------------------------------------------

	// check whether random function return value ranges from 0 to 3 
	@Test
	public void testvisitor_random_all()
	{
		CitySim9002 citysim = new CitySim9002();
		Visitors mockedvisitors = Mockito.mock(Visitors.class);
		int random_num = citysim.visitor_random_all(1, mockedvisitors,0);
		assertTrue(random_num == 0);
	}
	
	// check whether this method can return output ranges from 0 to 4
	// Meanwhile it should always return same value with a fixed seed 
	@Test
	public void testlocation_first_random()
	{
		CitySim9002 citysim = new CitySim9002();
		int result;
		result = citysim.location_first_random(3);
		assertEquals(4, result);
	}
	
	// check whether this method can return output ranges from 0 to 4
	@Test
	public void testlocation_random()
	{
		CitySim9002 citysim = new CitySim9002();
		int result;
		result = citysim.location_random();
		assertTrue(result>=0 && result<=4);
	}
	
}
