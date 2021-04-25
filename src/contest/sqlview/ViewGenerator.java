package contest.sqlview;

public class ViewGenerator {
	
	public static void main(String[] args) {
		
		ParentTable pt = new ParentTable("Parent_Table", 2);
		pt.addColumn("column_1");
		pt.addColumn("column_2");
		pt.addColumn("column_3");
		pt.addColumn("column_4");
		pt.addColumn("column_5");
		
		Table ct1 = new Table("child1");
		ct1.addColumn("column_2");
		ct1.addColumn("column_4");
		ct1.addColumn("column_5");
		
		Table ct2 = new Table("child2");
		ct2.addColumn("column_1");
		ct2.addColumn("column_3");
//		ct2.addColumn("column_6"); // not valid column test
				
		
		pt.setChildren(ct1);
		pt.setChildren(ct2);
//		 pt.setChildren(ct2); // check adding 3rd child fails
		
		SQLQyertBuilder queryBuilder = new SQLQyertBuilder();
		String sql = queryBuilder.generateQuery(pt);
		System.out.println(sql);
	}
}
