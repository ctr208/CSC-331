package assignment0;

import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) {
		System.out.println("Hello World");
		
		int a;
		int b = 10;
		
		int [] data = new int[10];
		
		Scanner s = new Scanner(System.in);
		
		for(int i=0; i < data.length; i++) {
			System.out.println("Enter number"+(i+1)+": ");
			data[i] = s.nextInt();
		}
		
		for(int p: data)
			System.out.println(p);
		
		int max = findMax(data);
		
		System.out.println("Biggest value = " + max);			

	}

	private static int findMax(int[] data) {
		int max = data[0];
		for(int p: data)
			if (p > max)
				max = p;
		return max;
	}
	

}
