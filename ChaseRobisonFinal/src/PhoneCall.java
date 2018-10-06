
public class PhoneCall {
	private String date, caller, reciever, duration;

	public PhoneCall(String date, String caller, String reciever, String duration) {
		this.date = date;
		this.caller = caller;
		this.reciever = reciever;
		this.duration = duration;
	}

	public String getDate() {
		return date;
	}

	public String getCaller() {
		return caller;
	}

	public String getRec() {
		return reciever;
	}

	public int getDur() {
		String str = null;
		String str1 = null;
		int num = 0;
		int num1 = 0;
		if (duration.length() == 5) {
			str = duration.substring(0, 2);
			str1 = duration.substring(3);
		}

		if (duration.length() == 4) {
			str = duration.substring(0, 1);
			str1 = duration.substring(2);
		}

		num = Integer.parseInt(str);
		num1 = Integer.parseInt(str1);

		num = num * 60;
		num1 = num1 + num;

		return num1;
	}

}
