package in.arrays;

public class ArraySortEvenOdd {

	// refer problem 8
	public static void main(String[] args) {

		int a[] = { 40, 25, 61, 15, 35, 59, 91, 82, 46, 64 };
		int evenCount = getEventCount(a);
		int e[] = new int[evenCount];
		copyEvenNumbers(a, e);
		printArray(e);
		//sortNumbers();
//		int oddCount = a.length-evenCount;
//		int o[] = new int[oddCount];
//		copyolddNumbers(a, o);
//		soryNumbers();
//		printArray(o);
//		merge(e,o);
	}

	private static void copyEvenNumbers(int[] a, int[] b) {
		int j=0;
		for(int i=0;i<a.length;i++)
		{
			if(a[i]%2==0)
			{
				b[j++]=a[i];
			}
		}
		
	}

	private static int getEventCount(int[] a) {
		int c = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 == 0) {
				c++;
			}
		}
		return c;
	}

	private static void printArray(int[] c) {

		for (int i = 0; i < c.length; i++) {
			System.out.print(c[i] + " ");
		}
		System.out.println("");
	}

}
