package in.enums;

/**
 * Enum with variables
 * @author saryal
 *
 */
public enum WeekDays {

	SUNDAY("Relaxing time", true), MONDAY("Working day starts"), TUESDAY("Recharged battries"),
	WEDNESDAY("Settling time"), THURSDAY("Get in control"), FRIDAY("Wrapping up time"),
	SATURDAY("Weekend Time!!!", true);

	private String dayGreeting;
	private boolean isHoliday;


	private WeekDays(String dayGreeting) {
		this.dayGreeting = dayGreeting;
	}

	private WeekDays(String dayGreeting, boolean isWeekEnd) {
		this.dayGreeting = dayGreeting;
		this.isHoliday = isWeekEnd;
	}
	
	public String getDayGreeting() {
		return dayGreeting;
	}

	public boolean isHoliday() {
		return isHoliday;
	}


}
