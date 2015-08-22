package com.wxisme.idb1;

import java.util.HashMap;
import java.util.Map;

/**
 * ���࣬���������Ϣ������������������Լ�ʵ������صĹ��߷���
 * @author wxisme
 *
 */

public class Table {
	public String tableName;
	public String headInfoLine;
	public Map<String, String> tableMap;
	public int rowCount; //����
	public int colCount; //����
	
	public Table() {}

	public Table(String tableName) {
		this.tableName = tableName;
		this.tableMap = new HashMap<String, String>();
		
	}
	public Table(String tableName, String headInfoLine, int rowCount,
			int colCount) {
		super();
		this.tableName = tableName;
		this.headInfoLine = headInfoLine;
		this.rowCount = rowCount;
		this.colCount = colCount;
	}
	
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getHeadInfoLine() {
		return headInfoLine;
	}

	public void setHeadInfoLine(String headInfoLine) {
		this.headInfoLine = headInfoLine;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getColCount(String path) {
		String headLine = DataLoader.tableHeadLine(path);
        String[] res = headLine.split(",");
		return res.length;
	}

	public void setColCount(int colCount) {
		this.colCount = colCount;
	}

	public Map<String, String> getTableMap() {
		return tableMap;
	}

	public void setTableMap(Map<String, String> tableMap) {
		this.tableMap = tableMap;
	}
	
	
	
	
}
