package jdbc;

import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Types;

/**
 * @author: shiminghui
 * @create: 2020年05月
 **/
public class JdbcTemplateTest {
	public static void main(String[] args) {
		/**
		 *
		 * 主要是 模板方法 + 回调
		 *
		 */
		JdbcTemplate jdbcTemplate = null;

		jdbcTemplate.update("UPDATE student SET name = 'ssss'");
		/**
		 *	1. ArgumentTypePreparedStatementSetter 封装 参数和参数类型 ---》 为PreparedStatement设值
		 *	2. SimplePreparedStatementCreator 封装 SQL --》 创建 PreparedStatement
		 */
		jdbcTemplate.update("UPDATE student SET name = ?", new String[]{"ssss"}, new int[] {Types.VARCHAR});

		/**
		 * 0.RowCallbackHandler 一行数据一行数据的处理
		 * 1. RowCallbackHandlerResultSetExtractor 封装 RowCallbackHandler
		 * 2. RowCallbackHandlerResultSetExtractor 遍历 ResultSet 并循环 RowCallbackHandler
		 */
		jdbcTemplate.query("select * from student", resultSet -> {

		});
	}

}
