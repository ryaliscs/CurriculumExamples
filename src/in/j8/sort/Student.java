package in.j8.sort;

public class Student {

	private int id;
	private String name;
	private String course;
	private double score;
	
	public Student(int id, String name, String course, double score) {
		this.id = id;
		this.name = name;
		this.course = course;
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCourse() {
		return course;
	}

	public double getScore() {
		return score;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", course=" + course + ", score=" + score + "]";
	}

	
}
