package contest.sqlview;

import java.util.List;

public class SQLQyertBuilder {

	private static final String FROM = "FROM";
	private static final String AS_SELECT = "AS SELECT";
	private static final String SELECT = "SELECT";
	private static final String UNION_ALL = "UNION ALL";
	private static final String NULL_AS = "NULL AS";
	private static final String SPACE = " ";
	private static final String NEW_LINE = "\n";
	private static final String SEPARATOR = ",";
	private static final String TAB = "\t";
	private final StringBuilder query;

	public SQLQyertBuilder() {
		this.query = new StringBuilder();
	}

	/**
	 * 
	 * @param aTable
	 * @return
	 */
	public String generateQuery(ITable aTable) {

		addParent(aTable);

		List<ITable> childrens = ((IParentTable) aTable).getChildren();
		if (childrens != null) {
			for (int i = 0; i < childrens.size(); i++) {
				addChild(aTable, childrens.get(i), i > 0);
			}
		}
		return this.query.toString();
	}

	/**
	 * 
	 * @param parent
	 * @param children
	 * @param addUnion
	 */
	private void addChild(ITable parent, ITable children, boolean addUnion) {
		if (addUnion) {
			this.query.append(NEW_LINE).append(UNION_ALL).append(NEW_LINE);
			this.query.append(SELECT).append(SPACE).append(NEW_LINE);
		} else {
			this.query.append(AS_SELECT).append(SPACE).append(NEW_LINE);
		}
		addChildColumns(parent.getColumns(), children);
	}

	/**
	 * 
	 * @param parentColumns
	 * @param child
	 */
	private void addChildColumns(List<String> parentColumns, ITable child) {
		for (String column : parentColumns) {
			if (child.getColumns().contains(column)) {
				this.query.append(TAB).append(column).append(SEPARATOR).append(NEW_LINE);
			} else {
				this.query.append(TAB).append(NULL_AS).append(SPACE).append(column).append(SEPARATOR).append(NEW_LINE);
			}
		}
		this.query.append(FROM).append(SPACE).append(child.getTableName());
	}

	/**
	 * 
	 * @param columns
	 */
	private void addColumns(List<String> columns) {
		this.query.append(NEW_LINE);
		for (String column : columns) {
			this.query.append(TAB).append(column).append(SEPARATOR).append(NEW_LINE);
		}
		this.query.append("}");
	}

	/**
	 * 
	 * @param aTable
	 */
	private void addParent(ITable aTable) {
		this.query.append("CREATE OR REPLACE VIEW");
		this.query.append(SPACE).append(aTable.getTableName()).append(SPACE).append("{");
		addColumns(aTable.getColumns());
	}

}
