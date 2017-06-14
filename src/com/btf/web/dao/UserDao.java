package com.btf.web.dao;



import java.sql.SQLException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.btf.web.entity.User;

@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean login(String mobile, String password){		
		User user;
		
		System.out.println("用户"+mobile+"即将登陆");
		
		try{
			String sql = "SELECT password FROM user WHERE mobile=?";
			String pws = jdbcTemplate.queryForObject(sql,String.class,mobile);
			if(pws.equals(password)){
				return true;
			}
		}catch (Exception e) {
			return false;
		}
		
		return false;
	}
	
	public User getUserByMobile(String mobile) {	
		String sql = "SELECT mobile,password,nickname FROM user where mobile=?";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
		User user = jdbcTemplate.queryForObject(sql, rowMapper,mobile);
		return user;
	}
	
	public boolean register(User user)
	{
		 try{
			 String sql = "insert into user(mobile,nickname,password) values(?,?,?)";  
		     Object args[] = {user.getMobile(),user.getNickname(),user.getPassword()};  
		     int temp = jdbcTemplate.update(sql, args);  
		     if (temp > 0) {  
		            System.out.println("注册成功！");  
		            return true;
		     }
		 }catch(DuplicateKeyException e){
			 return false;
		 }
		return false;	
	}
}
