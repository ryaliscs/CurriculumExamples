package in.sort;

import java.util.Comparator;
import java.util.Objects;

public class Student implements Comparable<Student> {

	private String code;
	private String firstName;
	private String lastName;
	private double score;
	
	public static final Comparator<Student> NATURAL_COMPARATOR = Comparator.comparing(Student::getCode);

	public Student(String code, String firstName, String lastName, double score) {
		this.code = code;
		this.firstName = firstName;
		this.lastName = lastName;
		this.score = score;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the score
	 */
	public double getScore() {
		return score;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.code, this.firstName, this.lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		Student student = (Student) obj;

		return Objects.equals(this.code, student.code) //
				&& Objects.equals(this.firstName, student.firstName) //
				&& Objects.equals(this.lastName, student.lastName) //
				&& Objects.equals(this.score, student.score);
	}

	@Override
	public String toString() {
		return "Student [code=" + code + ", firstName=" + firstName + ", lastName=" + lastName + ", score=" + score
				+ "]";
	}

	@Override
	public int compareTo(Student o) {
		// default sorting is code
		return NATURAL_COMPARATOR.compare(this, o);		
	}

}
