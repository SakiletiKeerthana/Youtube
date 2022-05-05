package com.youtube.controller;

import java.util.ArrayList;

import com.youtube.entity.YoutubeUser;

public interface YoutubeControllerInterface {

	

	int signup();

	

	YoutubeUser viewProfile();



	YoutubeUser signin();



	ArrayList<YoutubeUser> viewAllProfile();



	int deleteProfile();



	YoutubeUser  updateProfile();



	YoutubeUser searchProfile();



	ArrayList<YoutubeUser> sortProfile();

}
