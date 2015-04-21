package com.FCI.SWE.ServicesModels;

import java.util.ArrayList;
import java.util.List;

import com.FCI.SWE.Services.MyMap;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public class userpost{
	
	public  boolean save(String owner,String content,String feeling,String privacy) {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query gaeQuery = new Query("userPost");

		PreparedQuery pq = datastore.prepare(gaeQuery);
		List<Entity> list = pq.asList(FetchOptions.Builder.withDefaults());
	    Entity newPost = new Entity("Post", list.size() + 1);
	    newPost.setProperty("PostID", list.size() + 1);
		newPost.setProperty("Owner", owner);
		newPost.setProperty("Content", content);
		newPost.setProperty("Feeling", feeling);
		newPost.setProperty("Privacy", privacy);
		datastore.put(newPost);
		SearchHashTag(content) ;

		return true;

	}
	
	public boolean SaveHashTagPost(String Content, String hashTag){
		boolean ok = false ;
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query gaeQuery = new Query("PostHashTag");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		List<Entity> list = pq.asList(FetchOptions.Builder.withDefaults());
		
		for (Entity entity : pq.asIterable()){
			if(entity.getProperty("HashTag").toString().equals(hashTag)){
				int hash_count = Integer.parseInt(entity.getProperty("HashTagCount").toString() );
				hash_count ++ ;
				entity.setProperty("HashTagCount", hash_count);
				entity.setProperty("HashTagPost", entity.getProperty("HashTagPost").toString()+"/"+Content);				
				ok = true ;
				break ;
				}

		}
		
		if(!ok){
			Entity newHashTag = new Entity("PostHashTag", list.size() + 1);
			newHashTag.setProperty("HashTag", hashTag);
			newHashTag.setProperty("HashTagCount", 1);
			newHashTag.setProperty("HashTagPost", Content);
			datastore.put(newHashTag) ;
		}
		return true;       
	}
	public void SearchHashTag(String Content){
		if(Content.contains("#")){				
			String hashTag ="";
			int indexstart=Content.indexOf("#");
			for(int i = indexstart+1 ; i < Content.length(); i ++){
				if(Content.charAt(i)==' ') break ;
				hashTag += Content.charAt(i) ;
			}			
			SaveHashTagPost(Content,hashTag) ;	
		}				
	}
	
	

}	