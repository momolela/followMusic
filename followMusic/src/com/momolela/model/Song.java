/**   
 * @Title: Song.java  
 * @Package com.momolela.model  
 * @Description: TODO  
 * @author momolela   
 * @date 2016-5-29 下午10:31:08  
 * @version V1.0   
 */
package com.momolela.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @ClassName: Song  
 * @author: momolela  
 * @date 2016-5-29 下午10:31:08
 */
@Entity(name = "song")
public class Song {
	private Integer id;
	private String songname;
	private String singer;
	private String album;
	private Date uptime;
	private String url;
	private Integer uploaduserid;
	private Integer songtypeid;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "songname")
	public String getSongname() {
		return songname;
	}

	public void setSongname(String songname) {
		this.songname = songname;
	}

	@Column(name = "singer")
	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	@Column(name = "album")
	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "uptime")
	public Date getUptime() {
		return uptime;
	}

	public void setUptime(Date uptime) {
		this.uptime = uptime;
	}

	@Column(name = "url")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "songtypeid")
	public Integer getSongtypeid() {
		return songtypeid;
	}

	public void setSongtypeid(Integer songtypeid) {
		this.songtypeid = songtypeid;
	}

	@Column(name = "uploaduserid")
	public Integer getUploaduserid() {
		return uploaduserid;
	}

	public void setUploaduserid(Integer uploaduserid) {
		this.uploaduserid = uploaduserid;
	}
}
