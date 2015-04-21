package com.FCI.SWE.ServicesModels;

import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

public class friendpost {
	
	public Boolean save(String owner,String friend,String content,String feeling,String privacy) {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query gaeQuery = new Query("userPost");

		PreparedQuery pq = datastore.prepare(gaeQuery);
		List<Entity> list = pq.asList(FetchOptions.Builder.withDefaults());
	    Entity newPost = new Entity("Post", list.size() + 1);
	    newPost.setProperty("PostID", list.size() + 1);
	    newPost.setProperty("Owner", owner);
		friend = "Friend/" + friend ;
		newPost.setProperty("Type", friend);
		newPost.setProperty("Content", content);
		newPost.setProperty("Feeling", feeling);
		newPost.setProperty("Privacy", privacy);
		datastore.put(newPost);
		userpost user =new userpost();
		user.SearchHashTag(content) ;

		return true;

	}
	

}

