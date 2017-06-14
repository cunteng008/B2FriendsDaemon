package com.btf.web.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Arrays;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.btf.web.dao.UserDao;
import com.btf.web.entity.User;


public class Testing {
	private ApplicationContext ctx=null;
	JdbcTemplate jdbcTemplate;
	UserDao userDao ;
	
	{
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		userDao = ctx.getBean(UserDao.class);
		jdbcTemplate = ctx.getBean(JdbcTemplate.class);
	}
	
	@Test
	public void testDataSource() throws SQLException  {
//		String sql = "SELECT mobile,password,nickname FROM user where mobile=?";
//		RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
//		User user = jdbcTemplate.queryForObject(sql, rowMapper,"13143122980");
//		System.out.println(user.getPassword());
////		DataSource dataSource = ctx.getBean(DataSource.class);
////		System.out.println(dataSource.getConnection());
		//System.out.println("");
		//userDao.login("13143122980", "cunteng008");
		User user = new User();
		user.setMobile("1234");
		user.setNickname("mingjing");
		user.setPassword("571157");
		System.out.println(user.toString());
	}

}
