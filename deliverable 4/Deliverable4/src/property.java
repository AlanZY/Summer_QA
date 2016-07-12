import java.util.Random;
public class property {
	
	// random generate array
	public  int[] RandomArray(int size)
	{
		Random random = new Random();
		int[] array = new int[size];
		for(int i = 0;i<size;i++)
		{
			array[i] = random.nextInt(100)+1;
		}
		return array;
	}
	
	// map function
	public int[] billify(int[] x)
	{	
		int[] SquareArray = new int[x.length+1];
		int sum = 0;
		for(int i=0;i<x.length;i++)
		{
			SquareArray[i] = x[i]*x[i];
			sum = sum + SquareArray[i];
		}
		SquareArray[x.length] = sum;
		return SquareArray;
	}
}
