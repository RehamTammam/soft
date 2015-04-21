package com.FCI.SWE.Services;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.json.simple.JSONObject;

import com.FCI.SWE.ServicesModels.UserEntity;
import com.FCI.SWE.ServicesModels.pagepost;

public class pagebuilder {
	
	
	
	@POST
	@Path("/PagePostService")
	public String PagePost(@FormParam("Owner") String owner, @FormParam("Page") String page ,
			@FormParam("Content") String content, @FormParam("Privacy") String privacy){				
		JSONObject object = new JSONObject();
		pagepost user =new pagepost();
		user.save(owner, page, content, privacy);
		object.put("Status", "OK");
		return object.toString();	
	}
	
	
	
	
	@POST
	@Path("/CreatePageService")
	public String CreatePage(@FormParam("owner") String owner,@FormParam("PageName") String PageName, @FormParam("Category") String Category){
		JSONObject object = new JSONObject();
		pagepost user =new pagepost();
		user.savecreatepage(owner,PageName, Category);
		object.put("Status", "OK");
		return object.toString();	
	}




}
