package in.arrays;

public class MergeArrays {
	
	public static void main(String args[])
	{
		int a[]={1,3,5,7,9};
		int b[]={2,4,6,8,10,12};
		
		printArray(a);
		printArray(b);
		
		int c[]=mergeAndSort(a, b);
		
		printArray(c);
	}
	
	private static int[] mergeAndSort(int a[], int b[])
	{
		int c[]=mergeArray(a, b);
		//c = sortyArray(c);
		return c;
	}
	
	private static int[] mergeArray(int a[], int b[])
	{
		int c[] = new int [a.length + b.length];
		
		c = copyArray(a, c, 0);
		c = copyArray(b, c, a.length);
		return c;
	}
	
	private static int[] copyArray(int original[], int tocopy[], int startIndex)
	{
		for(int i=0;i<original.length;i++)
		{
			tocopy[startIndex++]=original[i];
		}
		return tocopy;
	}

	private static void printArray(int[] c) {
		
		for(int i=0;i<c.length;i++)
		{
			System.out.print(c[i]+" ");
		}
		System.out.println("");
	}

}

