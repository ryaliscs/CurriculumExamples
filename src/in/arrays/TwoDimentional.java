package in.arrays;

public class TwoDimentional {

	public static void main(String[] args) {

		int a[][] = new int [2][3];
		int num=10;
		for(int i=0;i<2;i++)
		{
			for(int j=0;j<3;j++)
			{
				a[i][j]=num++;
			}
		}
		
		for(int i=0;i<2;i++)
		{
			for(int j=0;j<3;j++)
			{
				System.out.print(a[i][j]+" ");
			}
			System.out.println("");
		}
	}

}
