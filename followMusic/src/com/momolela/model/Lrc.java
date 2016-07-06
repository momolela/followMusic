/**   
 * @Title: Lrc.java  
 * @Package com.momolela.model  
 * @Description: TODO  
 * @author momolela   
 * @date 2016-6-17 上午9:52:02  
 * @version V1.0   
 */
package com.momolela.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *  @ClassName: Lrc  @Description:   @author: momolela
 *  @date 2016-6-17 上午9:52:02  
 */
@Entity
@Table(name="lrc")
public class Lrc {
	private Integer id;
	private String lrcurl;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="lrcurl")
	public String getLrcurl() {
		return lrcurl;
	}

	public void setLrcurl(String lrcurl) {
		this.lrcurl = lrcurl;
	}
}
