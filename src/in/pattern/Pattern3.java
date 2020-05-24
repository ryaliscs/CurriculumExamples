package in.pattern;

/**
 *     1
 *    121
 *   12321
 *  1234321
*  123454321
 * @author saryal
 */
public class Pattern3 {
	public static void main(String args[])
	{
		for(int i=1;i<=5;i++) //rows
		{
			for(int j=i;j<5;j++)// space
			{
				System.out.print(' ');
			}
			int k=1;
			for(;k<=i;k++) //left
			{
				System.out.print(k);
			}
			for(int l=k-1, j=l-1;l>1;l--)
			{
				System.out.print(j--);
			}
			System.out.println("");
		}
	}
}
