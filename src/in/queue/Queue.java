package in.queue;

public class Queue {
	int f;
	int r;
	int arr[];
	int capacity;

	public Queue(int cap) {
		capacity = cap;
		f = -1;
		r = -1;
		arr = new int[capacity];
	}

	void add(int ele) {
		if (r + 1 == capacity) {
			System.out.println("Q is full");
		} else {
			r++;
			arr[r] = ele;
		}
	}

	int remove() {
		if ((r == -1 && f == -1) || (f == r)) {
			return -1;
		} else {
			f++;
			int k = arr[f];
			return k;
		}
	}

	void display() {
		if ((r == -1 && f == -1) || r == f) {
			System.out.println("Q empty");
		} else {
			for(int i = f+1; i<=r; i++){
				System.out.println(arr[i]);
			}
		}
	}

	public static void main(String[] args) {
		Queue qu = new Queue(5);
		qu.add(10);
		qu.add(20);
		qu.remove();
		qu.add(30);
		qu.display();
	}
}
