package in.pattern;

/**
 * Output:
 *     1
 *    12
 *   123
 *  1234
 * 12345
 */
public class Pattern2 {
	public static void main(String args[])
	{
		for(int i=1; i<=5;i++) //row
		{
			for(int j=5; (j-i)>0;j--) //spaces
			{
				System.out.print(' ');
			}
			for(int k=1;k<=i;k++) // column
			{
				System.out.print(k);
			}
			System.out.println("");
		}
	}
}
