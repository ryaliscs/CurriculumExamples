package in.j8.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Sorting of an object with Java 8 {@link Comparator}, using
 * {@link Comparator#thenComparing(Comparator)}
 * 
 * @author saryal
 *
 */
public class SortingExp {

	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		students.add(new Student(10, "sarat", "Computer", 9.5));
		students.add(new Student(11, "krishna", "Law", 8.5));
		students.add(new Student(12, "rama", "Music", 7.5));
		students.add(new Student(13, "anupama", "Literature", 8.2));
		students.add(new Student(14, "hema", "Math", 6.5));
		students.add(new Student(10, "sarat", "Math", 4.5));

		System.out.println("Original List:");
		printStudents(students);

		System.out.println("Sorting.......");
		System.out.println("By Name:");
 		List<Student> ex0 = new ArrayList<Student>(students);
 		ex0.sort(Comparator.comparing(Student::getName));
		printStudents(ex0);

		System.out.println("By course, score and name:");
		List<Student> ex1 = new ArrayList<Student>(students);
		Comparator<Student> sorting1 = Comparator.comparing(Student::getCourse).thenComparing(Student::getScore);
		sorting1.thenComparing(Student::getName);
		ex1.sort(sorting1);

		printStudents(ex1);

		System.out.println("By Score, Name:");
		List<Student> ex2 = new ArrayList<Student>(students);
		Comparator<Student> comparator = Comparator.comparing(Student::getScore).thenComparing(Student::getName);
		ex2.sort(comparator);
		printStudents(ex2);

		System.out.println("By Score, Name in reverse order:");
		List<Student> ex3 = new ArrayList<Student>(students);
		ex3.sort(comparator.reversed());
		printStudents(ex3);
	}

	private static void printStudents(List<Student> students) {

		students.forEach(System.out::println);
		System.out.println("\n\n");

	}
}
