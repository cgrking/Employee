package com.hybrid.mapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.hybrid.model.Member;

public class MemberMapperTest {

	static Log log = LogFactory.getLog(MemberMapperTest.class);

	public static void main(String[] args) throws Exception {
		String driverClassName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/world";
		String username = "root";
		String password = "mysql";
		/*
		 * DataSorce
		 */
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		/*
		 * SqlSessionFactoryBean
		 */
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource);

		ClassPathResource memberMapper = new ClassPathResource("com/hybrid/mapper/MemberMapper.xml");
		Resource[] mapperLocations = { memberMapper };
		sqlSessionFactory.setMapperLocations(mapperLocations);

		SqlSessionTemplate sqlSession = new SqlSessionTemplate(sqlSessionFactory.getObject());
		
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		List<Member> list = mapper.selectAll();

		//List<Member> list = sqlSession.selectList("com.hybrid.mapper.MemberMapper.selectAll");
		
		for (Member m : list) {
			log.info("id = " + m.getId());
			log.info("email = " + m.getEmail());
		}

		// printMembers(dataSource.getConnection());

		log.info("Program exit...");

	}

	static void printMembers(Connection con) throws SQLException {
		String sql = "select * from member";

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		List<Member> list = new ArrayList<>();

		while (rs.next()) {
			Member m = new Member();
			m.setId(rs.getLong("id"));
			m.setName(rs.getString("name"));
			m.setEmail(rs.getString("email"));
			m.setRegisterDate(rs.getDate("register_date"));

			list.add(m);
		}

		for (Member m : list) {
			log.info("id = " + m.getId());
			log.info("email = " + m.getEmail());
		}
	}

}
