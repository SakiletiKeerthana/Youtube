package com.youtube.utiity;


import com.youtube.service.YoutubeService;
import com.youtube.service.YoutubeServiceInterface;

public class ServiceFactory {

	public static YoutubeServiceInterface ServiceObject() {
		
		return new YoutubeService() ;
	}

}
