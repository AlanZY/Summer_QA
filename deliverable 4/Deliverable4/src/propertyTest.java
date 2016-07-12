import static org.junit.Assert.*;

import java.util.NoSuchElementException;
import java.util.Random;
import org.junit.Test;


public class propertyTest {

	// property 1: the size of output array is the size of input array plus one 
	@Test
	public void testsize() {
		property testsize = new property();
		try
		{
			int iteration = 100;
			for(int j = 0;j<iteration;j++)
			{
				int size = j+1 ;
				int[] array = testsize.RandomArray(size);
				int[] result = testsize.billify(array);	
				assertTrue(j+2 == result.length);
			}
		}catch(NoSuchElementException nseex){
			fail();
		}
	}
	
	// property 2: all number in this output array is larger than 0
	@Test
	public void testlargerthan0()
	{
		Random random = new Random();
		property testlargerthan0 = new property();
		try{
			int iteration = 150;
			for(int j = 0;j<iteration;j++)
			{
				int size = random.nextInt(100)+1;
				int[] array = testlargerthan0.RandomArray(size);
				int[] result = testlargerthan0.billify(array);	
				for(int i=0;i<size+1;i++)
				{
					assertFalse(result[i]<1);
				}
			}
		}catch(NoSuchElementException nseex){
			fail();
		}	
	}
	
	
	// property 3: all the numbers in the array(except the last one)
	//             are less than 10001
	@Test
	public void testlessthan10001()
	{
		Random random = new Random();
		property testlessthan10001 = new property();
		int iteration = 150;
		try{
			for(int j = 0;j<iteration;j++)
			{
				int size =  random.nextInt(100)+1;;
				int[] array = testlessthan10001.RandomArray(size);
				int[] result = testlessthan10001.billify(array);	
				for(int i=0;i<size;i++)
				{
					assertTrue(result[i]<10001);
				}
			}
		}catch(NoSuchElementException nseex){
			fail();
		}
	}
	
	
	// property: the last element is larger than any other number in 
	//           the array
	@Test
	public void testlastlargest()
	{
		property testlastlargest = new property();
		Random random = new Random();
		int iteration = 150;
		try{
			for(int j = 0;j<iteration;j++)
			{
				int size =  random.nextInt(100)+1;;
				int[] array = testlastlargest.RandomArray(size);
				int[] result = testlastlargest.billify(array);	
				// find the largest element
				int tmp = 0;
				for(int i=0;i<size+1;i++)
				{
					if(result[i]>tmp)
						tmp = result[i];
				}
				assertEquals(tmp,result[size]);
			
			}
		}catch(NoSuchElementException nseex){
			fail();
		}
	}
}
