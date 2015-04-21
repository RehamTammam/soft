package com.FCI.SWE.Services;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.json.simple.JSONObject;

import com.FCI.SWE.ServicesModels.userpost;

public class userbuilder {
	@POST
	@Path("/UserPostService")
	public String UserPost(@FormParam("Owner") String owner, @FormParam("Content") String content,
			@FormParam("Feeling") String feeling, @FormParam("Privacy") String privacy){
		
		JSONObject object = new JSONObject();
		userpost user =new userpost();
		user.save(owner,content,feeling,privacy);
		object.put("Status", "OK");
		return object.toString();	
	}

	
	
	@POST
	@Path("/SaveHashTagPostService")
	public String SaveHashTagPost(@FormParam("Content") String Content, @FormParam("hashTag") String hashTag){
		
		JSONObject object = new JSONObject();
		userpost user =new userpost();
		user.SaveHashTagPost(Content, hashTag);
		object.put("Status", "OK");
		return object.toString();	
	}
}
