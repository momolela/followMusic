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
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @ClassName: Song  
 * @author: momolela  
 * @date 2016-5-29 下午10:31:08
 */
@Entity
@Table(name = "song")
public class Song {
	private Integer id;
	private String songname;
	private String singer;
	private String album;
	private Date uptime;
	private String url;
	private User uploaduser;
	private SongType songtype;
	private Lrc lrc;

	private Set<CommentsList> commentsList = new HashSet<CommentsList>();

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

	@ManyToOne
	@JoinColumn(name = "songtypeid")
	public SongType getSongtype() {
		return songtype;
	}

	public void setSongtype(SongType songtype) {
		this.songtype = songtype;
	}

	@ManyToOne
	@JoinColumn(name = "uploaduserid")
	public User getUploaduser() {
		return uploaduser;
	}

	public void setUploaduser(User uploaduser) {
		this.uploaduser = uploaduser;
	}

	@OneToOne
	@JoinColumn(name="lrcid")
	public Lrc getLrc() {
		return lrc;
	}

	public void setLrc(Lrc lrc) {
		this.lrc = lrc;
	}

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "sid")
	public Set<CommentsList> getCommentsList() {
		return commentsList;
	}

	public void setCommentsList(Set<CommentsList> commentsList) {
		this.commentsList = commentsList;
	}
}
