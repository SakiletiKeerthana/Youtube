package com.youtube.utiity;

import com.youtube.controller.YoutubeController;
import com.youtube.controller.YoutubeControllerInterface;

public class ControllerFactory {


	public static YoutubeControllerInterface ControllerObject() {
		
		return new YoutubeController();
	}

}
