package com.FCI.SWE.Services;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.json.simple.JSONObject;

import com.FCI.SWE.ServicesModels.friendpost;

public class friendbuilder {
	@POST
	@Path("/FriendPostService")	
	public String FriendPost(@FormParam("Owner") String owner, @FormParam("Friend") String friend ,
			@FormParam("Content") String content, @FormParam("Feeling") String feeling,
			@FormParam("Privacy") String privacy)
	{				
		JSONObject object = new JSONObject();
		friendpost user =new friendpost();
		user.save(owner, friend, content, feeling, privacy);
		object.put("Status", "OK");
		return object.toString();	
		
	}



}
