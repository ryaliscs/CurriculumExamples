package contest.sqlview;

import java.util.ArrayList;
import java.util.List;

/**
 * {@code ParentTable} <b>extends</b> {@link Table} and holds columns for this table
 * and also the children tables {@code ITable} as per the
 * {@code ParentTable#noOfChildren}.
 * 
 * @author saryal
 *
 */
public class ParentTable extends Table implements IParentTable {

	private final int noOfChildren;
	private List<ITable> children;

	public ParentTable(String aName, int noOfChildren) {
		super(aName);
		assert noOfChildren <= NO_OF_CHILDREN_ALLOWED : "no of children cannot be greater than "
				+ NO_OF_CHILDREN_ALLOWED;
		this.noOfChildren = noOfChildren;
	}

	/**
	 * getNoOfChildren: No of children allowed for this parent table
	 * 
	 * @return the noOfChildren allowed for this {@code ParentTable}
	 */
	public int getNoOfChildren() {
		return noOfChildren;
	}

	/**
	 * getChildren: returns all the children for the {@code ParentTable}
	 * 
	 * @return the children the children tables {@code ITable} for the
	 *         {@code ParentTable}. can be {@code null} if no children are defined
	 */
	public List<ITable> getChildren() {
		return children;
	}

	/**
	 * setChildren: adds the children to the {@code IParentTable}
	 * 
	 * <pre>
	 * 	before adding the children the method validates if
	 * 1) the child being added is allowed as per {@link ParentTable#noOfChildren}
	 * 2) the child columns are valid. The child columns should be subset of {@code ParentTable} columns
	 * </pre>
	 * 
	 * @param childTable the child {@code ITable} to be added to {@code ParentTable}
	 */
	public void setChildren(ITable childTable) {

		if (this.children == null) {
			this.children = new ArrayList<ITable>(noOfChildren);
		}

		validateChildrenCount();
		validateChildColumns(childTable.getColumns());

		this.children.add(childTable);
	}

	/**
	 * Validates whether the child being added is allowed as per
	 * {@link ParentTable#noOfChildren}
	 */
	private void validateChildrenCount() {
		int size = this.children.size();
		// size + 1 as the child is not yet added to parent
		if (size + 1 > noOfChildren) {
			throw new RuntimeException("Cannot have more then " + this.noOfChildren + " children");
		}
	}

	/**
	 * validate the given child table columns {@code Table#getColumns()} is subset
	 * of parent table columns {@code ParentTable#getColumns()}
	 * 
	 * @param columns
	 */
	private void validateChildColumns(List<String> columns) {
		for (String column : columns) {
			if (!hasColumn(column)) {
				throw new RuntimeException(column + " column is not allowed as it is not in parent table");
			}
		}
	}

}
