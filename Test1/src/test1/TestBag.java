package test1;

	//Make no changes to this class
	public class TestBag {
		private static int testNumber = 1;

		public static void main(String[] args) {

			int counter;

			Bag b1 = new Bag();
			testEquals(b1.toString(), "Bag 1 contents:"); // Test 1
			
			Bag b2 = new Bag();
			testEquals(b2.toString(), "Bag 2 contents:"); // Test 2
			
			Bag b3 = new Bag();
			testEquals(b3.toString(), "Bag 3 contents:"); // Test 3


			counter = b1.count("car");
			testEquals(counter, 0); // Test 4
		
			b1.addTo("car"); // add the String “car” to Bag b1
			testEquals(b1.toString(), "Bag 1 contents:car"); //Test 5
		
			b1.addTo("truck");
			testEquals(b1.toString(), "Bag 1 contents:car truck"); //Test 6
	
			b1.addTo("bus");
			testEquals(b1.toString(), "Bag 1 contents:car truck bus"); //Test 7
			b1.addTo("car");
			testEquals(b1.toString(), "Bag 1 contents:car truck bus car"); // Test 8


			counter = b1.count("car");
			testEquals(counter, 2); // Test 9
			
			counter = b1.count("truck");
			testEquals(counter, 1); // Test 10
	

			b2.addTo("bike");
			b2.addTo("tractor");
			b2.addTo("car");
			b2.addTo("bus");
			b2.addTo("car");
			b2.addTo("car");

			testEquals(b2.toString(), "Bag 2 contents:bike tractor car bus car car"); // Test 11
			
			counter = b2.count("car");
			testEquals(counter, 3); //Test 12
	
			

			b1.addTo("bus"); // add another bus to b1
			testEquals(b1.toString(), "Bag 1 contents:car truck bus car bus"); // Test 13

			b2.addTo("car"); // add another car to b2
			testEquals(b2.toString(), "Bag 2 contents:bike tractor car bus car car car"); // Test 14
			
		}

		private static void testEquals(int actual, int expected) {
			// TODO Auto-generated method stub
			testEquals(Integer.toString(actual), Integer.toString(expected));

		}

		private static void testEquals(String actual, String expected) {
			// TODO Auto-generated method stub
			System.out.println("\nTest " + testNumber + " results");

			try {
				System.out.println("\t" + "Actual result = " + actual);
				System.out.println("\t" + "Expected result = " + expected);
				System.out.println("\tTest " + testNumber + " " + translate(actual.equals(expected)));
			} catch (Exception e) {
				System.out.println("\tTest " + testNumber + " failed");
			} finally {
				testNumber++;
			}
		}

		private static String translate(boolean b) {
			if (b)
				return "passed";
			else
				return "failed";
		}

	}



