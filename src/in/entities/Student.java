package in.entities;

public class Student {

	// properties
	private String name;
	private String section;
	private double maths;
	// two subjects
	private double science;
	private double general;
	private double optional = -1;
	private char gender;

	public void setGender(char gender) throws Exception {
		if (gender != 'M' && gender != 'F') {
			this.gender = 'X';
		} else {
			this.gender = gender;
		}
	}

	public void setOptional(double optional) {
		this.optional = optional;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public void setMaths(int maths) {
		this.maths = maths;
	}

	public void setScience(int science) {
		this.science = science;
	}

	public void setGeneral(int general) {
		this.general = general;
	}

	public void setMaths(double maths) {
		this.maths = maths;
	}

	public void setScience(double science) {
		this.science = science;
	}

	public void setGeneral(double general) {
		this.general = general;
	}

	public double total() {
		double total = this.maths + this.science + this.general;
		if (this.optional != -1) {
			total = total + this.optional;
		}
		return total;
	}

	public double average() {
		if (this.optional != -1) {
			return total() / 4;
		}
		return total() / 3;
	}

	public void print() {
		String title = "Mr.";
		if (this.gender == 'F') {
			title = "Mrs.";
		}
		else if (this.gender == 'X') {
			title = "-ns-";
		}

		System.out.println("Name:" + title + this.name);
		System.out.println("Section:" + this.section);
		System.out.println("Maths:" + this.maths);
		System.out.println("Science:" + this.science);
		System.out.println("General:" + this.general);
		if (this.optional != -1) {
			System.out.println("Optional:" + this.optional);
		}
		System.out.println("Total:" + total());
		System.out.println("Average:" + average());
	}
}
