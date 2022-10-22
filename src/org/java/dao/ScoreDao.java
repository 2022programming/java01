package org.java.dao;

import org.java.util.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 成绩的数据访问层，包含对成绩表操作的所有方法
 * 
 * @author FanShengSheng
 * @version
 */
public class ScoreDao {
	private JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
	//添加考试成绩
	public void updateScore(int id, int course, int grade) {

		String sql = "insert into score values(null,?,?,?)";
		jt.update(sql, grade, course, id);
	}

}
