
public class Main {

	private static int[] array, rotated_array;
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

		rotated_array = new int[7];
		rotated_array[0] = 32;
		rotated_array[1] = 64;
		rotated_array[2] = 128;
		rotated_array[3] = 2;
		rotated_array[4] = 4;
		rotated_array[5] = 8;
		rotated_array[6] = 16;
		
		System.out.println(find(32));
		System.out.println(findBinary(32));		
		System.out.println(findRotatedBinary(2));		
	}	
	
	/**
	 * Linear finding
	 * @param value target
	 * @return target index, -1 for value not found
	 */
	public static int find(int value)
	{
		for(int i=0; i<array.length; i++)
		{
			if(array[i] == value)
				return i;
		}
		return -1;
	}
	
	/**
	 * Binary Search
	 * @param value target
	 * @return target index, -1 for value not found
	 */
	public static int findBinary(int value)
	{
		int index_middle, 
				index_min = 0, //index_le and index_max initial setting, spans all array
				index_max = array.length -1;
		while(index_min <= index_max)
		{
			index_middle = (int)((index_min + index_max)/2);
			if(array[index_middle] ==  value)
				return index_middle;
			else if(array[index_middle] < value)
				index_min = index_middle + 1;	//if value at array's middle is smaller, get 
			else if(array[index_middle] > value)	
		        index_max = index_middle - 1;
		}			
		return KEY_NOT_FOUND;
	}
	
	/**
	 * Binary Search for rotated arrays
	 * @param value target
	 * @return target index, -1 for value not found
	 */
	public static int findRotatedBinary(int value)
	{
		int index_middle, 
		index_min = 0, //index_le and index_max initial setting, spans all array
		index_max = array.length -1;

		 while (index_min <= index_max) 
		 {
			 index_middle = (int)((index_min + index_max)/2);
			 if (rotated_array[index_middle] == value) 
			    return index_middle;		 
			  
			 // the bottom half is sorted
			 if (rotated_array[index_min] <= rotated_array[index_max]) 
			 {
				 if (rotated_array[index_min] <= value && value < rotated_array[index_middle])
			        index_max = index_middle - 1;
			      else
			        index_min = index_max + 1;
			 }
			 // the upper half is sorted
			 else 
			 {
				 if (rotated_array[index_middle] < value && value <= rotated_array[index_max])
			        index_min = index_max + 1;
			      else 
			        index_max = index_min - 1;
			 }
		}		
		return KEY_NOT_FOUND;
	}
}
