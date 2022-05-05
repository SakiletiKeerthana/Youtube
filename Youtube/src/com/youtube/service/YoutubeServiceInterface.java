package com.youtube.service;

import java.util.ArrayList;
import java.util.List;

import com.youtube.entity.YoutubeUser;

public interface YoutubeServiceInterface {

	int createProfile(YoutubeUser yu);

	YoutubeUser viewProfile(YoutubeUser yu);

	

	YoutubeUser signin(YoutubeUser yu);

	ArrayList<YoutubeUser> viewAllProfileService();

	int deleteProfileService(YoutubeUser yu);

	


	int updateProfileService(YoutubeUser yu, YoutubeUser yuu);

	YoutubeUser searchProfile(YoutubeUser yu);

	

	

}
