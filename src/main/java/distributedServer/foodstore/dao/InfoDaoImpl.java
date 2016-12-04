package distributedServer.foodstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import distributedServer.foodstore.model.Info;

@Repository
public class InfoDaoImpl implements InfoDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public static final class InfoMapper implements RowMapper<Info> {

		@Override
		public Info mapRow(ResultSet arg0, int arg1) throws SQLException {
			Info info = new Info();
			//set函数
			return info;
		}
		
	}

	@Override
	public Info findOne(long id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public List<Info> findAll() {
		// TODO 自动生成的方法存根
		List<Info> infos = this.jdbcTemplate.query("select * from info", new InfoMapper());
		return infos;
	}

	@Override
	public void create(Info entity) {
		// TODO 自动生成的方法存根
		final String INSERT_SQL = "insert into Info (name) values(?)";
		
		KeyHolder keyholder = new GeneratedKeyHolder();
		this.jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
	            PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] {"id"});
	            //ps.setString(1, entity.getName());
	            return ps;
	        }
		}, keyholder);
		
	}

	@Override
	public Info update(Info entity) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public void delete(Info entity) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void deleteById(long entityId) {
		// TODO 自动生成的方法存根
		
	}

}
