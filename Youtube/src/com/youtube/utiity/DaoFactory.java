package com.youtube.utiity;

import com.youtube.dao.YoutubeDAOInterface;
import com.youtube.dao.YoutubeDao;

public class DaoFactory {

	public static YoutubeDAOInterface DaoObject() {
		
		return new YoutubeDao();
	}

}
