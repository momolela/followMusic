/**   
 * @Title: UploadMusicAction.java  
 * @Package com.momolela.web.user  
 * @Description: TODO  
 * @author momolela   
 * @date 2016-6-7 下午2:19:33  
 * @version V1.0   
 */
package com.momolela.web.user;

import java.io.File;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.momolela.model.Song;
import com.momolela.model.User;
import com.momolela.service.ISongService;
import com.momolela.service.ISongTypeService;
import com.momolela.service.IUserService;
import com.momolela.util.TzConstanst;
import com.opensymphony.xwork2.ActionSupport;

/**
 *  @ClassName: UploadMusicAction  @Description:   @author: momolela
 *  @date 2016-6-7 下午2:19:33  
 */
@Controller("uploadMusicAction")
@Scope("prototype")
public class UploadMusicAction extends ActionSupport implements ServletRequestAware {
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;

	@Autowired
	private IUserService UserService;
	
	@Autowired
	private ISongService SongService;
	
	@Autowired
	private ISongTypeService SongTypeService;

	private File music;
	private String musicFileName; // xxxFileName
	private String musicContentType; // xxxContentType
	private String songname;
	private String singer;
	private String album;
	private String songtype;

	public File getMusic() {
		return music;
	}

	public void setMusic(File music) {
		this.music = music;
	}

	public String getMusicFileName() {
		return musicFileName;
	}

	public void setMusicFileName(String musicFileName) {
		this.musicFileName = musicFileName;
	}

	public String getMusicContentType() {
		return musicContentType;
	}

	public void setMusicContentType(String musicContentType) {
		this.musicContentType = musicContentType;
	}

	public String getSongname() {
		return songname;
	}

	public void setSongname(String songname) {
		this.songname = songname;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getSongtype() {
		return songtype;
	}

	public void setSongtype(String songtype) {
		this.songtype = songtype;
	}

	public String upload() {
		// 先判断在服务器端是否有属于该用户的存储歌曲的文件夹
		String dir = ServletActionContext.getServletContext().getRealPath("/music");
		User u = (User) request.getSession().getAttribute(TzConstanst.SESSION_USERKEY);
		if (new java.io.File(dir).isDirectory()) // 如果文件夹存在
		{
			new java.io.File(dir + "/" + u.getId().toString()).mkdir();
		}
		
		// 将文件写入到 /music/用户id 的文件夹中
		File newFile = new File(dir+"/"+u.getId().toString(), singer+"-"+songname + ".mp3");
		music.renameTo(newFile);	// 将上传的文件重命名
		
		//获取日期并转换
		Date date = new Date();
		// java.sql.Date d=new java.sql.Date (date.getTime());
		
		// 音乐上传成功后往数据库里song表添加数据
		Song song = new Song();
		song.setSongname(songname);
		song.setSinger(singer);
		song.setAlbum(album);
		song.setSongtype(SongTypeService.findSongtypeByName(songtype));
		song.setUptime(date);
		song.setUploaduser(u);
		song.setUrl("music"+"/"+u.getId().toString()+"/"+singer+"-"+songname + ".mp3");
		SongService.addSong(song);
		
		// 音乐上传成功后往用户收藏歌曲表里添加数据。
		Set<Song> songset= new HashSet<Song>();
		songset = UserService.getUserlike(u.getId());
		songset.add(song);
		UserService.addUserlike(u.getId(), songset);
		
		return "tomusicbox";
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}
