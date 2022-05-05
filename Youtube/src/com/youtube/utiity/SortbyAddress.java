package com.youtube.utiity;

import java.util.Comparator;

import com.youtube.entity.YoutubeUser;

public class SortbyAddress implements Comparator <YoutubeUser>{

	

	@Override
	public int compare(YoutubeUser o1, YoutubeUser o2) {
		return o1.getAddress().compareTo(o2.getAddress());
	}}
