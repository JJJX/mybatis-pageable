package org.buzheng.mybatis.pageable;



public class OracleDialect extends Dialect{

	/**
	 * 分页sql
	 */
	final static String LIMIT_SQL_PATTERN = "select * from ( select row__.*, rownum rownum__ from ( %s ) row__ where rownum <=  %s ) where rownum__ > %s ";
	
	/**
	 * 分页sql首页
	 */
	final static String LIMIT_SQL_PATTERN_FIRST = "select * from ( %s ) where rownum <= %s";
	public boolean supportsLimit() {
		return true;
	}

	public boolean supportsLimitOffset() {
		return true;
	}
	
	public String getLimitString(String sql, int offset, String offsetPlaceholder, int limit, String limitPlaceholder) {
		sql = sql.trim();
		
		// no supports "for update", kill it
		sql.replaceAll("for\\s+update", "");
		
		if (offset == 0) {
			return String.format(LIMIT_SQL_PATTERN_FIRST, sql, limitPlaceholder);
		} 

		return String.format(LIMIT_SQL_PATTERN, sql, offsetPlaceholder + "+" + limitPlaceholder, offsetPlaceholder);
	}

	public static void main(String[] args) {
		String sql = "select * from users";
		
		System.out.println(new OracleDialect().getLimitString(sql, 20, "10", 10, "10"));
		System.out.println(new OracleDialect().getLimitString(sql, 0, "0", 10, "10"));
	}
}

