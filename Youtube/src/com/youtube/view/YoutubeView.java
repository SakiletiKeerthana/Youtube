package com.youtube.view;

import java.util.Scanner;


import com.youtube.controller.YoutubeControllerInterface;
import com.youtube.entity.YoutubeUser;
import com.youtube.utiity.ControllerFactory;

public class YoutubeView {
	static Scanner sc=new Scanner(System.in);
	static int ch;

	public static void main(String[] args) {
		YoutubeControllerInterface yc=ControllerFactory.ControllerObject();
		YoutubeUser s1;
		String s="y";
		
		while(s.equals("y")) {
			System.out.println("press 1 to signup");
			System.out.println("press 2 to signin");
			
			
			System.out.println("Enter your choice");
			ch=sc.nextInt();
			
			
			
			switch(ch) {
			case 1: yc.signup();
				break;
			case 2:s1=yc.signin();
					if(s1!=null) {
						while(s.equals("y")) {
							System.out.println("************MAIN MENU***********");
							System.out.println("Press 1 to view profile");
							System.out.println("Press 2 to view All profile");
							System.out.println("Press 3 to delete profile");
							System.out.println("Press 4 to update profile");
							System.out.println("Press 5 to search profile");
							System.out.println("Press 6 to sort the profile");
							System.out.println("Enter your choice");
							ch=sc.nextInt();
						
							switch(ch) {
							case 1:yc.viewProfile();
								break;
							case 2:yc.viewAllProfile();
								break;
							case 3:yc.deleteProfile();
								break;
							case 4:yc.updateProfile();
								break;
							case 5:yc.searchProfile();
								break;
							case 6:yc.sortProfile();
								break;
							
							
						}
							System.out.println("To be continue enter y/n");
							s=sc.next();
							
						
					}
						
				}
					else {
						System.out.println("Oops!!! Your record is not registered.....Signup to register");
					}
			break;
			}
			
		
		System.out.println("To be continue enter y/n");
		s=sc.next();
		}

	}
}




