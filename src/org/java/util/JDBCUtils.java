package org.java.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * JDBC工具类，用于产生数据源
 * 
 * @author FanShengSheng
 * @version
 */
public class JDBCUtils {
	// 数据源
	private static DataSource ds;
	// 静态代码块，类被加载时就会自动创建数据库连接池
	static {
		try {
//			使用相对路径读取文件
//			InputStream is = new FileInputStream("java01/conf/druid.properties");
			// 创建输入流，加载指定配置文件
			InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
			// 创建属性类
			Properties prop = new Properties();
			// 加载输入流中的配置信息
			prop.load(is);
			// 关闭流资源
			is.close();
			// 产生数据源
			ds = DruidDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 调用静态方法，获得数据源
	public static DataSource getDataSource() {
		return ds;
	}
}
