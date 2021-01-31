package in.enums;

public class EnumWithVariables {
	
	public static void main(String[] args) {
		WeekDays weekDay = WeekDays.SATURDAY;
		if(weekDay.isHoliday()) {
			System.out.println(weekDay.getDayGreeting() + " Enjoy your day");
		} else {
			System.out.println(weekDay.getDayGreeting()+" Have a good day");
		}
	}

}
