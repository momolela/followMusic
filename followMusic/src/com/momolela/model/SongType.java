/**   
 * @Title: Song.java  
 * @Package com.momolela.model  
 * @Description: TODO  
 * @author momolela   
 * @date 2016-5-29 下午10:31:08  
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
 * @ClassName: SongType
 * @Description: 
 * @author: momolela
 * @date 2016-6-7 下午12:38:02
 */
@Entity
@Table(name="songtype")
public class SongType {
	private Integer id;
	private String songtype;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "songtype")
	public String getSongtype() {
		return songtype;
	}
	
	public void setSongtype(String songtype) {
		this.songtype = songtype;
	}
}
