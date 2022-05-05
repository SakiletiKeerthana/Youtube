package com.youtube.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import com.youtube.entity.YoutubeUser;
import com.youtube.service.YoutubeServiceInterface;
import com.youtube.utiity.ServiceFactory;
import com.youtube.utiity.SortbyAddress;
import com.youtube.utiity.UserFactory;

public class YoutubeController implements YoutubeControllerInterface {
	YoutubeServiceInterface ys=null;
	Logger log=Logger.getLogger("YoutubeController");
	Scanner sc=new Scanner(System.in);
	private String newfirstname;
	static int i;
	
	public YoutubeController() {
		ys=ServiceFactory.ServiceObject();
	}

	public int signup() {
		
		
		
		log.info("Enter your First Name : ");
		String Firstname=sc.next();

		log.info("Enter your Last Name : ");
		String Lastname=sc.next();
		
		log.info("Enter your Password : ");
		String password=sc.next();
		
		log.info("Enter your Email : ");
		String Email=sc.next();
		
		log.info("Enter your Address : ");
		String Address=sc.next();

		log.info("Enter your age : ");
		Integer age=sc.nextInt();
		
		YoutubeUser yu=UserFactory.UserObject();
		
		yu.setFirstname(Firstname);
		yu.setLastname(Lastname);
		yu.setPassword(password);
		yu.setEmail(Email);
		yu.setAddress(Address);
		
		
		 i=ys.createProfile(yu);
		
		
		if(i>0) {
			log.info("Profile created");
		}
		else {
			log.info("profile not created");
		}
		return i;
		

	}

	

	@Override
	public YoutubeUser viewProfile() {
		log.info("To view the wanted profile enter wanted Email to view : ");
		String Email=sc.next();
		
		YoutubeUser yu=UserFactory.UserObject();
		yu.setEmail(Email);
		
		YoutubeUser s1=ys.viewProfile(yu);
		
		if(s1!=null) {
			System.out.println(s1.getFirstname());
			System.out.println(s1.getLastname());
			System.out.println(s1.getPassword());
			System.out.println(s1.getEmail());
			System.out.println(s1.getAddress());
		}
		else {
			System.out.println("Profile not found");
		}
		return s1;
		
		
		
	}

	@Override
	public YoutubeUser signin() {
		System.out.println("Enter your email:");
		String Email = sc.next();
		System.out.println("Enter your password:");
		String password = sc.next();
		
		

		YoutubeUser yu=UserFactory.UserObject();
		
		yu.setPassword(password);
		yu.setEmail(Email);
		
		YoutubeUser s1=ys.signin(yu);

				return s1;
	}

	@Override
	public ArrayList<YoutubeUser> viewAllProfile() {
		ArrayList<YoutubeUser>aa=ys.viewAllProfileService();
		
		
		for(YoutubeUser r:aa) {
				System.out.println("-----------------------------");
				System.out.println("Your First Name is : " + r.getFirstname());
				System.out.println("Your Last Name is : " + r.getLastname());
				System.out.println("Your Password Name is : " + r.getPassword());
				System.out.println("Your Email is : " + r.getEmail());
				System.out.println("Your Address is : " + r.getAddress());
			
		}
		return aa;
		
	}

	

	@Override
	public int deleteProfile() {
		log.info("------------TO DELETE PROFILE-----------" + "\n" + " ------------Enter email which profile you want to delete---------");
		String Email=sc.next();
		
		YoutubeUser yu=UserFactory.UserObject();
		yu.setEmail(Email);
		
		 i=ys.deleteProfileService(yu);
		
		if(i>0) {
			System.out.println("Your profile is deleted");
		}
		else {
			System.out.println("Profile not found");
		}
		return i;
		
		
		
	}


	@Override
	public YoutubeUser updateProfile() {
		log.info("***********UPDATE PROFILE***************");
		log.info("Enter email whose profile u want to update");
		String Email=sc.next();
		

		YoutubeUser yu=new YoutubeUser();
		yu.setEmail(Email);
		
		log.info("Enter your First Name to edit : ");
		String Firstname=sc.next();

		log.info("Enter your Last Name to edit: ");
		String Lastname=sc.next();
		
		log.info("Enter your Password to edit: ");
		String password=sc.next();
		
		
		log.info("Enter your Address to edit : ");
		String Address=sc.next();
		
		YoutubeUser yuu=new YoutubeUser();
		
		yuu.setFirstname(Firstname);
		yuu.setLastname(Lastname);
		yuu.setPassword(password);
		yuu.setAddress(Address);
		
		i=ys.updateProfileService(yu,yuu);
		
		if(i>0) {
			log.info("Profile edited");
		}
		else {
			log.info("Profile not edited");
		
		}
		return yuu;
		
		
		
		
			
					
			
	
	}

	@Override
	public YoutubeUser searchProfile() {
		
		log.info("*********SEARCH PROFILE************");
		log.info("To search your profile please....Enter your Firstname");
		String Firstname=sc.next();
		

		YoutubeUser yu=new YoutubeUser();
		yu.setFirstname(Firstname);
		
	
		
		
		
		YoutubeUser s1=ys.searchProfile(yu);
		
		
		if(s1!=null) {
		
		System.out.println("-----------------------------");
		System.out.println("Your First Name is : " + s1.getFirstname());
		System.out.println("Your Last Name is : " + s1.getLastname());
		System.out.println("Your Password Name is : " + s1.getPassword());
		System.out.println("Your Email is : " + s1.getEmail());
		System.out.println("Your Address is : " + s1.getAddress());
		
		
	}
		else {
			System.out.println("Profile not found!!!!");
		}
		return s1;
		
		
		
	}

	@Override
	public ArrayList<YoutubeUser> sortProfile() {
		ArrayList<YoutubeUser>aa=ys.viewAllProfileService();
		
		
		aa.forEach(r-> {
			System.out.println("*************************************************");
				System.out.println("-------------Before Sorting your data ----------------");
				System.out.println("Your First Name is : " + r.getFirstname());
				System.out.println("Your Last Name is : " + r.getLastname());
				System.out.println("Your Password Name is : " + r.getPassword());
				System.out.println("Your Email is : " + r.getEmail());
				System.out.println("Your Address is : " + r.getAddress());
		});
			
				Collections.sort(aa,new SortbyAddress());
				
			for(YoutubeUser r1:aa) {
				
						System.out.println("*************************************************");
						System.out.println("-----------After sorting your data------------------");
						System.out.println("Your First Name is : " + r1.getFirstname());
						System.out.println("Your Last Name is : " + r1.getLastname());
						System.out.println("Your Password Name is : " + r1.getPassword());
						System.out.println("Your Email is : " + r1.getEmail());
						System.out.println("Your Address is : " + r1.getAddress());
					
				}
			return aa;
				
		}
		
		
	}
	
