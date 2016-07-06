package com.momolela.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.opensymphony.xwork2.validator.annotations.EmailValidator;

/**
 *  @ClassName: User  @author: momolela  @date 2016-5-29 下午10:32:57
 */
@Entity
@Table(name = "user")
public class User {
	private Integer id;
	private String username;
	private String password;
	private String sex;
	private String email;
	private String userpicurl;
	private Set<SendList> sendlist = new HashSet<SendList>();
	private Set<Song> userlike = new HashSet<Song>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "username", length = 20)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", length = 20)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "sex")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "email")
	@EmailValidator(message = "输入的邮箱不符合格式")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "userpicurl")
	public String getUserpicurl() {
		return userpicurl;
	}

	public void setUserpicurl(String userpicurl) {
		this.userpicurl = userpicurl;
	}

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "uid")
	public Set<SendList> getSendlist() {
		return sendlist;
	}

	public void setSendlist(Set<SendList> sendlist) {
		this.sendlist = sendlist;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "userlike", joinColumns = @JoinColumn(name = "uid", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "sid", referencedColumnName = "id"))
	public Set<Song> getUserlike() {
		return userlike;
	}

	public void setUserlike(Set<Song> userlike) {
		this.userlike = userlike;
	}
}
