package com.youtube.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.youtube.entity.YoutubeUser;

public class YoutubeDao implements YoutubeDAOInterface {
	Connection con=null;
	int i=0;
	
	public YoutubeDao() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","keerthana");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public int createProfile(YoutubeUser yu) {
		int i=0;
		try {
			if(yu.getFirstname().equals("Government")) {
				throw new UserDefinedException();}
			
			/*PreparedStatement ps=con.prepareStatement("insert into youtubeuser2 values(?,?,?,?,?)");*/
			CallableStatement ps=con.prepareCall("{call miprocedure(?,?,?,?,?)}");
			ps.setString(1, yu.getFirstname());
			ps.setString(2, yu.getLastname());
			ps.setString(3, yu.getPassword());
			ps.setString(4, yu.getEmail());
			ps.setString(5, yu.getAddress());
			i=ps.executeUpdate();	
		}
		catch(UserDefinedException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return i;
	}

	@Override
	public YoutubeUser viewProfile(YoutubeUser yu) {
		YoutubeUser s1=null;
	
		try {
			
			PreparedStatement ps=con.prepareStatement("select *from youtubeuser2 where email=?");
			ps.setString(1, yu.getEmail());
			
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				String firstname=res.getString(1);
				String lastname=res.getString(2);
				String password=res.getString(3);
				String email=res.getString(4);
				String address=res.getString(5);
				
				s1=new YoutubeUser();
				s1.setFirstname(firstname);
				s1.setLastname(lastname);
				s1.setPassword(password);
				s1.setEmail(email);
				s1.setAddress(address);
						
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return s1;

}

	@Override
	public YoutubeUser signin(YoutubeUser yu) {
		YoutubeUser s1=null;
		
		try {
			
			PreparedStatement ps=con.prepareStatement("select *from youtubeuser2 where email=?");
			ps.setString(1, yu.getEmail());
			
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				
				String email=res.getString(4);
				String password=res.getString(2);
				
				
				
				s1=new YoutubeUser();
				
				s1.setEmail(email);
				s1.setPassword(password);
				
				
						
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return s1;
	}

	@Override
	public ArrayList<YoutubeUser> viewAllProfiledao() {
		YoutubeUser s2=null;
		ArrayList<YoutubeUser> ll=new ArrayList<YoutubeUser>();
		
		try {
			
			PreparedStatement ps=con.prepareStatement("select *from youtubeuser2");
			
			
			ResultSet res=ps.executeQuery();
			while(res.next()) {
				String firstname=res.getString(1);
				String lastname=res.getString(2);
				String password=res.getString(3);
				String email=res.getString(4);
				String address=res.getString(5);
				
				s2=new YoutubeUser();
				s2.setFirstname(firstname);
				s2.setLastname(lastname);
				s2.setPassword(password);
				s2.setEmail(email);
				s2.setAddress(address);
				
				ll.add(s2);
				
				
						
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ll;

}

	@Override
	public int deleteProfiledao(YoutubeUser yu) {
		int i=0;
		try {
			
			PreparedStatement ps=con.prepareStatement("delete from youtubeuser2 where email = ?");
			
			ps.setString(1, yu.getEmail());
			
			i=ps.executeUpdate();	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return i;
	}

	@Override
	public int updateProfiledao(YoutubeUser yu, YoutubeUser yuu) {
		YoutubeUser s2=null;
		ArrayList<YoutubeUser> ll=new ArrayList<YoutubeUser>();
		
		try {
			
			PreparedStatement ps=con.prepareStatement("update youtubeuser2 set firstname=?\n,lastname=?\n,password=?\n,address=?\n where email=?");
			ps.setString(1, yuu.getFirstname());
			ps.setString(2, yuu.getLastname());
			ps.setString(3, yuu.getPassword());
			ps.setString(4, yuu.getAddress());
			ps.setString(5, yu.getEmail());
			
			i=ps.executeUpdate();
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	
}

	@Override
	public YoutubeUser searchProfiledao(YoutubeUser yu) {
		YoutubeUser s1=null;
		
		try {
			
			PreparedStatement ps=con.prepareStatement("select *from youtubeuser2 where firstname=?");
			ps.setString(1, yu.getFirstname());
			
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				String firstname=res.getString(1);
				String lastname=res.getString(2);
				String password=res.getString(3);
				String email=res.getString(4);
				String address=res.getString(5);
				
				s1=new YoutubeUser();
				s1.setFirstname(firstname);
				s1.setLastname(lastname);
				s1.setPassword(password);
				s1.setEmail(email);
				s1.setAddress(address);
						
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return s1;

}

	}

		
	


