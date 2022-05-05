package com.youtube.dao;

import java.util.ArrayList;

import com.youtube.entity.YoutubeUser;

public interface YoutubeDAOInterface {

	int createProfile(YoutubeUser yu);

	YoutubeUser viewProfile(YoutubeUser yu);

	

	YoutubeUser signin(YoutubeUser yu);

	ArrayList<YoutubeUser> viewAllProfiledao();

	int deleteProfiledao(YoutubeUser yu);

	

	int updateProfiledao(YoutubeUser yu, YoutubeUser yuu);

	YoutubeUser searchProfiledao(YoutubeUser yu);



	

}
