import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestPhoneCall {

	private ArrayList<PhoneCall> callList = new ArrayList<>();

	public static void main(String[] args) {
		new TestPhoneCall();
	}

	public TestPhoneCall() {
		readFile();
		promptUser();
	}

	private void promptUser() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter caller number");
		String caller = input.nextLine();
		System.out.println(caller);

		Scanner input2 = new Scanner(System.in);
		System.out.println("Enter callee number");
		String callee = input.nextLine();
		System.out.println(callee);

		int highest = 0;
		String highestDate = null;

		for (PhoneCall c : callList) {
			c.getDur();
			if (c.getCaller().equals(caller) && c.getRec().equals(callee)) {
				System.out.println(c.getDate() + "," + c.getDur() + " seconds");
				if (c.getDur() > highest) {
					highest = c.getDur();
					highestDate = c.getDate();
				}

			}
		}
		System.out.println("The longest call from " + caller + " to " + callee + " was on " + highestDate + " for "
				+ highest + " seconds.");

	}

	///////////////////////////////////////

	private void readFile() {
		Scanner input = null;
		try {
			input = new Scanner(new File("Resources/PhoneCallData.txt"), "UTF-8");
			input.useDelimiter("[,\n]");
		} catch (FileNotFoundException e) {
			System.out.println("No file found");
		}
		String date, caller, reciever, duration;

		while (input.hasNext()) {

			date = input.next().trim();
			caller = input.next().trim();
			reciever = input.next().trim();
			duration = input.next().trim();

			PhoneCall c = new PhoneCall(date, caller, reciever, duration);
			callList.add(c);

		}
		input.close();
	}

}
