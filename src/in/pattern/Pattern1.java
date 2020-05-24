package in.pattern;

/**
 * 12345
 *  1234
 *   123
 *    12
 *     1
 */
public class Pattern1 {
	
	public static void main(String args[])
	{
		for(int i=5; i>0;i--) //row
		{
			for(int j=5; (j-i)> 0; j--) //spaces
			{
				System.out.print(" ");
			}
			for(int k=1;k<=i;k++) // column
			{
				System.out.print(k);
			}
			System.out.println("");
		}
	}

}
