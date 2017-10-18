package com.lss.test.interfaceTest;

import java.util.List;

public class Result {
	public List<Topic> topics;
	
	//下面的静态类只会在Topics这个类中使用，故用static
	public static class Topic{
		//用Integer不用int是因为，当没有值时，用int会默认赋值等于0，用Integer则默认赋值为null
		//用Boolean不用boolean的原因是因为，boolean默认赋值为false，Boolean默认赋值为null
		//用public是因为如果不加，则只能在com.lss.test.interfaceTest访问，Response无法访问，加了之后，则可以访问
		public Integer id;
		public String title;
		public String created_at;
		public String updated_at;
		public String replied_at;
		public Integer replies_count;
		public String node_name;
		public Integer node_id;
		public Integer last_reply_user_id;
		public String last_reply_user_login;
		public Integer excellent;
		public Integer likes_count;
		public String suggested_at;
		public String closed_at;
		public Boolean deleted;
		public User user;
		public Integer hits;
		public Abilities abilities;
	}
	
	public static class User{
		public Integer id;
		public String login;
		public String name;
		public String avatar_url;
		public Abilities abilities;
	}
	
	public static class Abilities{
		public Boolean update;
		public Boolean destroy;
		public Boolean ban;
		public Boolean excellent;
		public Boolean unexcellent;
		public Boolean close;
		public Boolean open;
	}
	

}
