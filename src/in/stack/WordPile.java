package in.stack;

public class WordPile {
	char ch[];
	int capacity;
	int top;

	WordPile(int cap) {
		capacity = cap;
		top = -1;
		ch = new char[cap];
	}

	void pushChar(char v) {
		if (top == (capacity - 1)) {
			System.out.println("wordpile is full");
		} else {
			top++;
			ch[top] = v;
		}
	}

	char popChar() {
		char k;
		if (top == -1) {
			System.out.println("/");
			return ' ';
		} else {
			k = ch[top];
			top--;
			return k;

		}
	}
	
	public static void main(String[] args) {
		WordPile wp = new WordPile(10);
		wp.pushChar('s');
		wp.pushChar('i');
		wp.pushChar('d');
		wp.pushChar('a');
		System.out.println(wp.popChar());//a
		System.out.println(wp.popChar());//d
		System.out.println(wp.popChar());//i
		wp.pushChar('u');
		wp.pushChar('y');
		//y,u,s
		
	}
}
