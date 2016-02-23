package org.buzheng.mybatis.pageable;

public class MySQLDialect extends Dialect {
	
	@Override
	public String getLimitString(String sql, int offset, int limit) {
		if (offset > 0) {
			return sql + " limit " + offset + "," + limit;
		} else {
			return sql + " limit " + limit;
		}
	}

}
