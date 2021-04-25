package contest.sqlview;

import java.util.List;

public interface IParentTable extends ITable {

	/**
	 * MAX DEFAULT CHILDREN ALLOWED FOR A {@code IParentTable}
	 */
	public int NO_OF_CHILDREN_ALLOWED = 3;

	/**
	 * Returns the children {@code ITable} for the {@code IParentTable}
	 * 
	 * @return children {@code ITable}
	 */
	public List<ITable> getChildren();
}
