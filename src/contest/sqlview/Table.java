package contest.sqlview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Table implements ITable {

	private List<String> columns;

	private final String name;

	/**
	 * Creates a Table instance
	 * 
	 * @param aName Table name
	 */
	public Table(String aName) {
		this.name = Objects.requireNonNull(aName);
	}

	/**
	 * 
	 * @param aColumnName
	 */
	public void addColumn(String aColumnName) {
		if (this.columns == null) {
			this.columns = new ArrayList<String>();
		}
		this.columns.add(aColumnName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<String> getColumns() {
		assert this.columns != null : "No Columns defined";
		Collections.sort(this.columns);
		return Collections.unmodifiableList(this.columns);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getTableName() {
		return this.name;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasColumn(String aColumn) {
	
		return this.columns.indexOf(aColumn)>0;
	}

}
