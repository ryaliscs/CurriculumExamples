package in.queue;

public class ExaminationHall {
	String name[];
	int front;
	int rear;
	int max;

	ExaminationHall(int cap) {
		max = cap;
		front = -1;
		rear = -1;
		name = new String[cap];
	}

	void entry(String n) {
		if (rear + 1 == max) {
			System.out.println("Hall is Full");
		} else {
			rear++;
			name[rear] = n;
		}
	}

	String exit() {
		String n;
		if ((rear == -1 && front == -1) || (rear == front)) {
			return null;
		} else {
			front++;
			n = name[front];
			return n;

		}
	}

	void display() {
		if ((rear == -1 && front == -1) || (rear == front)) {
			System.out.println("Q is empty");
		} else {
			for (int i = front + 1; i <= rear; i++)
				System.out.println(name[i]);
		}
	}
	
	public static void main(String[] args) {
		ExaminationHall eh = new ExaminationHall(10);
		eh.display();
		eh.entry("sid");
		eh.entry("sarat");
		eh.display();
		System.out.println(eh.exit());
		System.out.println(eh.exit());
		System.out.println(eh.exit());
		eh.entry("shiva");
		eh.entry("snigdha");
		eh.entry("vishnu");
		eh.display();
		
		
	}
}
