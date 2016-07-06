/**   
 * @Title: SendList.java  
 * @Package com.momolela.model  
 * @Description: TODO  
 * @author momolela   
 * @date 2016-5-29 下午11:35:47  
 * @version V1.0   
 */
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *  @ClassName: SendList  @author: momolela  @date 2016-5-29 下午11:35:47
 */
@Entity
@Table(name = "sendlist")
public class SendList {

	private Integer id;
	private String title;
	private String content;
	private String picurl;
	private User user;
	private Set<Song> song = new HashSet<Song>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name="content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name="picurl")
	public String getPicurl() {
		return picurl;
	}

	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}
	
	@ManyToOne
	@JoinColumn(name="uid")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "sendsong", joinColumns = @JoinColumn(name = "sendlist_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "sid", referencedColumnName = "id"))
	public Set<Song> getSong() {
		return song;
	}

	public void setSong(Set<Song> song) {
		this.song = song;
	}

}
