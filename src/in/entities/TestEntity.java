package in.entities;

public class TestEntity {
	
	public static void main(String[] args) throws Exception {
		Student studentSid = new Student();
		studentSid.setName("Sid");
		studentSid.setSection("11A");
		studentSid.setMaths(85);
		studentSid.setScience(80);
		studentSid.setGeneral(90);
		studentSid.setGender('P');
		studentSid.print();
		if(studentSid.total()>250.00)
		{
			System.out.println("Wow");
		}
		
		Student studentRavi = new Student();
		studentRavi.setName("Ravi");
		studentRavi.setSection("10A");
		studentRavi.setMaths(66);
		studentRavi.setScience(10);
		studentRavi.setGeneral(80);
		studentRavi.setOptional(23.45);
		studentRavi.setGender('F');
		studentRavi.print();
	}

}
