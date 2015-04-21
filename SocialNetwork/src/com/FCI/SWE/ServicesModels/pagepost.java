package com.FCI.SWE.ServicesModels;

import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

public class pagepost   {
	
public Boolean save(String owner,String page,String content,String privacy) {
	DatastoreService datastore = DatastoreServiceFactory
			.getDatastoreService();
	Query gaeQuery = new Query("pagePost");

	PreparedQuery pq = datastore.prepare(gaeQuery);
	List<Entity> list = pq.asList(FetchOptions.Builder.withDefaults());
    Entity newPost = new Entity("Post", list.size() + 1);
    newPost.setProperty("PostID", list.size() + 1);
    newPost.setProperty("Owner", owner);
	newPost.setProperty("Page", page);
	newPost.setProperty("Content", content);
	newPost.setProperty("Privacy", privacy);
	datastore.put(newPost);
	userpost user =new userpost();
	user.SearchHashTag(content) ;
	return true;

}


public Boolean savecreatepage(String owner,String PageName,String Category) {
	DatastoreService datastore = DatastoreServiceFactory
			.getDatastoreService();
	Query gaeQuery = new Query("Page");
	PreparedQuery pq = datastore.prepare(gaeQuery);
	List<Entity> list = pq.asList(FetchOptions.Builder.withDefaults());
    Entity newPost = new Entity("Page", list.size() + 1);
    newPost.setProperty("owner", owner);
	newPost.setProperty("PageName", PageName);
	newPost.setProperty("Category", Category);
	
	datastore.put(newPost);

	return true;


}



}