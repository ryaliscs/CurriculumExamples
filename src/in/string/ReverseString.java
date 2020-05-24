package in.string;

public class ReverseString {
	public static void main(String args[])
	{
		String names[] = {"sidhu", "applppa", "testset"};
		
		for(int i=0;i<names.length;i++)
		{
			StringBuffer sb = new StringBuffer(names[i]);
			String reverse = sb.reverse().toString();
			if(names[i].equals(reverse))
			{
				System.out.println(names[i]+ " is a palidrom");
			}
		}
	}
}
