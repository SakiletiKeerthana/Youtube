package com.youtube.service;

import java.util.ArrayList;
import java.util.List;

import com.youtube.dao.YoutubeDAOInterface;
import com.youtube.entity.YoutubeUser;
import com.youtube.utiity.DaoFactory;

public class YoutubeService implements YoutubeServiceInterface {
	YoutubeDAOInterface dao=null;
	
	public YoutubeService() {
		dao=DaoFactory.DaoObject();
	}

	@Override
	public int createProfile(YoutubeUser yu) {
		int i=dao.createProfile(yu);
		return i;
	}

	@Override
	public YoutubeUser viewProfile(YoutubeUser yu) {
		YoutubeUser s1=dao.viewProfile(yu);
		return s1;
	}



	@Override
	public YoutubeUser signin(YoutubeUser yu) {
		YoutubeUser s1=dao.signin(yu);
		return s1;
	}

	@Override
	public ArrayList<YoutubeUser> viewAllProfileService() {
		ArrayList<YoutubeUser> s1=dao.viewAllProfiledao();
		return s1;
	}

	@Override
	public int deleteProfileService(YoutubeUser yu) {
		int i=dao.deleteProfiledao(yu);
		return i;
	}

	

	@Override
	public int updateProfileService(YoutubeUser yu, YoutubeUser yuu) {
		int i=dao.updateProfiledao(yu,yuu);
		return i;
		
	}

	@Override
	public YoutubeUser searchProfile(YoutubeUser yu) {
		YoutubeUser s1=dao.searchProfiledao(yu);
		return s1;
		
	}


}
