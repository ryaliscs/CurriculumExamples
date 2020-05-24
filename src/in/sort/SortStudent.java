package in.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortStudent {

	public static void main(String[] args) {
		List<Student> students = Arrays.asList(
		new Student("A_001","Manoj","Vutukuri",9.8),
		new Student("B_001","Sarat","Ryali",7.8),
		new Student("A_002","Sarat","Ryali",8.7),
		new Student("A_003","Manoj","Desai",4.8),
		new Student("C_001","Sunil","Vennum",6.6),
		new Student("B_002","Sunil","Vennum",9.8),
		new Student("B_003","Manoj","Vutukuri",6.4));
				
		System.out.println("Original List");
		students.stream().forEach(System.out::println);
		
		System.out.println("Default sorting by code");
		students.sort(null);
		students.stream().forEach(System.out::println);
		
		System.out.println("Default sorting by code in reverse order");
		students.sort(Student.NATURAL_COMPARATOR.reversed());
		students.stream().forEach(System.out::println);
		
		System.out.println("Default sorting by code and first name");
		students.sort(Student.NATURAL_COMPARATOR.thenComparing(Student::getFirstName));
		students.stream().forEach(System.out::println);
		
		
		System.out.println("Sorted By Score and Last Name");
		students.sort(Comparator.comparing(Student::getScore)//				
				.thenComparing(Student::getLastName));				
		students.stream().forEach(System.out::println);
		
		System.out.println("Sorted by score in desending");
		Comparator<Student> compareByScore = new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return Double.compare(o1.getScore(), o2.getScore());
			}
		};
		students.sort(compareByScore.reversed());
		students.stream().forEach(System.out::println);
		
	}
}
