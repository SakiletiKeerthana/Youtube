package com.youtube.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.youtube.entity.YoutubeUser;

public class YoutubeControllerTesting {
	YoutubeController yc=null;
	YoutubeUser yu;

	@Before
	public void setUp() throws Exception {
		yc=new YoutubeController();
	}

	@After
	public void tearDown() throws Exception {
		yc=null;
	}

	@Test
	public void testsignup() {
		int i=yc.signup();
		assert i>0: "Test failed to signup";
	}
	@Test
	public void testsignin() {
		YoutubeUser s1=yc.signin();
		assert s1!=null: "Test failed to signin"; 
	}
	@Test
	public void testviewProfile() {
		YoutubeUser s1=yc.viewProfile();
		assert s1!=null: "Test failed to view Profile";
	}
	@Test
	public void testviewAllProfile() {
		ArrayList<YoutubeUser> aa=yc.viewAllProfile();
		assert aa!=null: "Test failed to view all profile";
	}
	@Test
	public void testdeleteProfile() {
		int i=yc.deleteProfile();
		assert i>0: "Test failed to delete profile";
	}
	@Test
	public void testupdateProfile() {
		YoutubeUser s1=yc.updateProfile();
		assert s1!=null: "Test failed to update profile";
	}
	@Test
	public void testsearchProfile() {
		YoutubeUser s1=yc.searchProfile();
		assert s1!=null: "Test failed to search profile";
	}
	@Test
	public void testsortProfile() {
		ArrayList<YoutubeUser> s1=yc.sortProfile();
		assert s1!=null: "Test failed to sort profile";
	}
	
	
	
	}



