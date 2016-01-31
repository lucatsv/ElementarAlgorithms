
public class Main {

	private static int[] array;
	private final static int KEY_NOT_FOUND = -1;
	
	public static void main(String[] args)
	{
		array = new int[7];
		array[0] = 2;
		array[1] = 4;
		array[2] = 8;
		array[3] = 16;
		array[4] = 32;
		array[5] = 64;
		array[6] = 128;
		
		System.out.println(find(32));
		System.out.println(findBinary(32));		

	}	
	
	public static int find(int value)
	{
		for(int i=0; i<array.length; i++)
		{
			if(array[i] == value)
				return i;
		}
		return -1;
	}
	
	public static int findBinary(int value)
	{
		int index_middle, 
				index_min = 0,
				index_max = array.length -1;
		while(index_min <= index_max)
		{
			index_middle = (int)((index_min + index_max)/2);
			if(array[index_middle] ==  value)
				return index_middle;
			else if(array[index_middle] < value)
				index_min = index_middle + 1;	
			else if(array[index_middle] > value)	
		        index_max = index_middle - 1;

		}

			
		return KEY_NOT_FOUND;
	}
	
}
