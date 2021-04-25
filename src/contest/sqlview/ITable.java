package contest.sqlview;

import java.util.List;

/**
 * Interface to give all the information about the table
 * 
 * @author saryal
 *
 */
public interface ITable {

	/**
	 * getColumns: Gives a list of columns for the selected table
	 * 
	 * @return columns for this table
	 */
	public List<String> getColumns();

	/**
	 * getTableName: Name of the table
	 * 
	 * @return table name
	 */
	public String getTableName();

	/**
	 * check if the given {@code aColumn} is available in the table
	 * 
	 * @param aColumn column to check
	 * @return true if aColumn exists, false otherwise
	 */
	public boolean hasColumn(String aColumn);

}
