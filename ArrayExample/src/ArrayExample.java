import java.util.ArrayList;

public class ArrayExample {
	private static Random r = new Random();
	private static int howManyToPrint = 20;
	
	public static void main(String[] args) {
		
		//create array with random integers
		int[] data = createRandomArray(400000);
		
		//create arraylist populated with the same integers as in above array
		ArrayList<Integer> dataList = createRandomArrayList(data);
		
	}

}


  //2D array//
//int [][] data;
//data = new int[100][6]