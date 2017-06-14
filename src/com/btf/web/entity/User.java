package com.btf.web.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity  
@Table(name="USER") 
public class User {
	
	@Id    
	@Column(name="mobile",length=11)  
	private String  mobile;
	
	@Column(name="password",length=10,nullable = false)  
	private String password;
	
	@Column(name="nickname",length=32)  
	private String nickname;
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
		
}
