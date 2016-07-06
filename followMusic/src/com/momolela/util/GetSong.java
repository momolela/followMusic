package com.momolela.util;

import java.util.List;

import com.momolela.dao.impl.SongDaoImpl;
import com.momolela.model.Song;

public class GetSong{
	public String getSong(){
		String result_min = "";
		String result_max = "";
		List<Song> allsonglist= (new SongDaoImpl()).getAllSong();
		for(Song s:allsonglist){
			String songname = s.getSongname();
			String singer = s.getSinger();
			/*String url = s.getUrl();
			String id = s.getId().toString();*/
			result_min = singer+"-"+songname+".mp3";
			result_max = result_max+result_min;
		}
		return result_max;
	}
}

