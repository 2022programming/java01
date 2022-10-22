package org.java.dao;

import java.util.List;
import java.util.Map;

import org.java.util.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 学生的数据访问层，包含对学生表操作的所有方法
 * 
 * @author FanShengSheng
 * @version
 */
public class StuDao {
	private JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());

	// 添加学生
	public void updateStu(String name, String gender, String birthday) {
		String sql = "insert into stu values(null,?,?,?)";
		jt.update(sql, name, gender, birthday);
	}

	// 查询所有学员信息
	public List<Map<String, Object>> showAll() {
		String sql = "select stuId,stuName,stuGender,TIMESTAMPDIFF(YEAR,stuBirthday,CURDATE()) stuAge from stu";
		return jt.queryForList(sql);
	}

	// 参加考试的学员信息
	public List<Map<String, Object>> showTakeExamInfo() {
		String sql = "select * from takeExam_view";
		return jt.queryForList(sql);
	}

	// 查询缺考学员信息
	public List<Map<String, Object>> showMissExamInfo() {
		String sql = "select * from missExam_view";
		return jt.queryForList(sql);
	}

}
