/*
 * By: Leann Labelle
 */
public class Main {

	public static void main (String[] args) throws InterruptedException
	{
		AlarmClock ac = new AlarmClock();
		User me = new User(ac);
		
		System.out.println("Use Case #11: Set Alarm Setting to Radio: ");
		System.out.println("Goal: Set the Alarm Setting to “Radio \n" +
				"Precondition: The alarm clock is currently on, all buttons are functional, \n"
				+ "the current alarm setting is not -Radio- and the alarm is not sounding");
		System.out.println("Goal: Set the Alarm Setting to �Radio�");
		System.out.println("Executing Test Case #11...");
		ac.sRadioSel();
		System.out.println();
		
		Thread.sleep(5000);
		
		System.out.println("Use Case #12: Set Alarm Setting to Ringer: ");
		System.out.println("Precondition: The alarm clock is currently on, all buttons are functional,\n"
				+ " the current alarm setting is not -Ringer- and the alarm is not sounding");
		System.out.println("Goal: Set the Alarm Setting to �Ringer�");
		System.out.println("Executing Test Case #12...");
		ac.sRingerSel();
		System.out.println();
		
		Thread.sleep(5000);
		
		System.out.println("Use Case #15:Hold �Alarm�, Alarm Time Incremented by 10 Minutes");
		System.out.println("Precondition: The alarm clock is currently on, all buttons are functional minute value does"
				+ "\nnot equals 59 minutes");
		System.out.println("Goal: Increment the alarm time by ten minutes ");
		System.out.println("Executing Test Case #15...");
		ac.bAlarmPressed();
		ac.b10MinPressed();
		ac.bAlarmReleased();
		System.out.println();
		
		System.out.println("Use Case #16: Hold �Alarm�, Alarm Time Minute Value Set to 00");
		System.out.println("Goal: Attempt to increment minute value of alarm except minute value is at its maximum");
		System.out.println("Precondition: The alarm clock is currently on, all buttons are functional and minute value will equal 59 minutes after incremented");
		System.out.println("Executing Test Case #16...");
		ac.bAlarmPressed();
		ac.b10MinPressed();
		ac.b10MinPressed();
		ac.b10MinPressed();
		ac.b10MinPressed();
		ac.b10MinPressed();
		ac.b10MinPressed();
		ac.bAlarmReleased();
		System.out.println();
		
		Thread.sleep(5000);
		
		System.out.println("Use Case #19: Alarm ringing");
		System.out.println("Goal: Alarm sounds at the desired time");
		System.out.println("Precondition: The alarm clock is currently on, all buttons are functional and"
				+ " sound unit works");
		ac.sRadioSel();
		ac.bSetTimePressed();
		ac.b1MinPressed();
		ac.b10MinPressed();
		ac.b10MinPressed();
		ac.b1HourPressed();
		ac.bSetTimeReleased();
		ac.bAlarmPressed();
		ac.b10MinPressed();
		ac.b1MinPressed();
		ac.b1MinPressed();
		ac.bAlarmReleased();
		System.out.println("Please wait 3 minutes to see the full output...");
		
		Thread.sleep(185000);
		
		System.out.println();
		System.out.println("Use Case #20: Alarm ringing, �Snooze� button pressed");
		System.out.println("Precondition: The alarm clock is currently on, all buttons are functional,\n"
				+ "sound unit works and alarm setting is not �Off\"");
		ac.bAlarmPressed();
		ac.b1MinPressed();
		ac.b1MinPressed();
		ac.b1MinPressed();
		ac.bAlarmReleased();
		ac.sRingerSel();
		Thread.sleep(150000);
		ac.bSnoozePressed();
		System.out.println();
	}
	
}
