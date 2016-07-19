import static org.junit.Assert.*;
import java.util.NoSuchElementException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.BeforeClass;
import org.junit.Test;



public class MainPanelTest {
	  public static MainPanel mainpanel;
	  public static Cell cell; 
	  public Cell[][] cells = new Cell[12][12];
	  
	  @BeforeClass
	  public static void beforeClass() 
	  {
		  mainpanel = new MainPanel(12); 
		  cell = new Cell();
	  }
	
	//  test convertToInt()
	//	I used 0, 4, 1000 to test this method. 
	//	In the original method, the output is 0, 4, and 1000 
	//	using 0, 4, 1000 as input separately. 
	//	I need to test whether I can still get 0, 4, 1000 
	//	in this new method.
	    
	@Test
	public void testconvertToInt4() throws NoSuchMethodException,
    InvocationTargetException, IllegalAccessException {
		try
		{
			int input = 4;
			Method method = MainPanel.class.getDeclaredMethod("convertToInt",int.class);
			method.setAccessible(true);
			int output = (int) method.invoke(mainpanel, input);
			assertEquals(4, output);
		}
		catch(NoSuchElementException nseex) {
			fail();	
		}
	}
	
	@Test
	public void testconvertToInt1000() throws NoSuchMethodException,
    InvocationTargetException, IllegalAccessException {
		try
		{
			int input = 1000;
			Method method = MainPanel.class.getDeclaredMethod("convertToInt",int.class);
			method.setAccessible(true);
			int output = (int) method.invoke(mainpanel, input);
			assertEquals(1000, output);
		}
		catch(NoSuchElementException nseex) {
			fail();	
		}
	}
	
	@Test
	public void testconvertToInt0() throws NoSuchMethodException,
    InvocationTargetException, IllegalAccessException {
		try
		{
			int input = 0;
			Method method = MainPanel.class.getDeclaredMethod("convertToInt",int.class);
			method.setAccessible(true);
			int output = (int) method.invoke(mainpanel, input);
			assertEquals(0, output);
		}
		catch(NoSuchElementException nseex) {
			fail();	
		}
	}

	// test runCountinuous
	// create a function Continuous() in MainPanel 
	// which uses size and _maxCount as inputs and returns _r 
	// also test whether size, _maxCount impact output
	
	@Test
	public void testrunContinuous1(){
		try
		{
			int size = 12;
			int _maxCount = 100;
			int output = mainpanel.runContinuoustestr(size, _maxCount);
			assertEquals(1000, output);
		}
		catch(NoSuchElementException nseex) {
			fail();	
		}
	}
	
	@Test
	public void testrunContinuous2(){
		try
		{
			int size = 24;
			int _maxCount = 100;
			int output = mainpanel.runContinuoustestr(size, _maxCount);
			assertEquals(1000, output);
		}
		catch(NoSuchElementException nseex) {
			fail();	
		}
	}
	
	
	@Test
	public void testrunContinuous3(){
		try
		{
			int size = 24;
			int _maxCount = 1000;
			int output = mainpanel.runContinuoustestr(size, _maxCount);
			assertEquals(1000, output);
		}
		catch(NoSuchElementException nseex) {
			fail();	
		}
	}
	
	// test iterateCell
	// create a function iterateCell1() in MainPanel 
	// which also uses alive and numNeighbors as inputs 
	// compare output with original codes with different values of alive and numNeighbors
	
	@Test
	public void testiterateCell1(){
		try
		{
			boolean alive = false;	
			int numNeighbors = 2;
			boolean output = mainpanel.iterateCelltest(1, 2, alive, numNeighbors);
			assertEquals(false, output);
		}
		catch(NoSuchElementException nseex) {
			fail();	
		}
	}
	
	
	@Test
	public void testiterateCell2(){
		try
		{
			boolean alive = true;	
			int numNeighbors = 4;
			boolean output = mainpanel.iterateCelltest(1, 2, alive, numNeighbors);
			assertEquals(false, output);
		}
		catch(NoSuchElementException nseex) {
			fail();	
		}
	}
	
	@Test
	public void testiterateCell3(){
		try
		{
			boolean alive = false;	
			int numNeighbors = 0;
			boolean output = mainpanel.iterateCelltest(1, 2, alive, numNeighbors);
			assertEquals(false, output);
		}
		catch(NoSuchElementException nseex) {
			fail();	
		}
	}
	
	
	@Test
	public void testiterateCell4(){
		try
		{
			boolean alive = true;	
			int numNeighbors = 3;
			boolean output = mainpanel.iterateCelltest(1, 2, alive, numNeighbors);
			assertEquals(true, output);
		}
		catch(NoSuchElementException nseex) {
			fail();	
		}
	}
	

	// test toString() in Cell
	// define cells[0][0] in this unit test
	// and set the status of cells[0][0] as true or false
	// test whether it has the same output as original program
	
	@Test
	public void testtoString1(){
		try
		{
			cells[0][0] = new Cell(true);
			String output = cells[0][0].toString();
			assertEquals("X", output);
		}
		catch(NoSuchElementException nseex) {
			fail();	
		}
	}
	
	@Test
	public void testtoString2(){
		try
		{
			cells[0][0] = new Cell(false);
			String output = cells[0][0].toString();
			assertFalse("X" == output);
		}
		catch(NoSuchElementException nseex) {
			fail();	
		}
	}
	
	@Test
	public void testtoString3(){
		try
		{
			cells[0][2] = new Cell(false);
			String output = cells[0][2].toString();
			assertFalse("X" == output);
		}
		catch(NoSuchElementException nseex) {
			fail();	
		}
	}
	

	
}
