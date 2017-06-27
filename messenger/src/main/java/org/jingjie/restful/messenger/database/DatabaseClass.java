package org.jingjie.restful.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.jingjie.restful.messenger.model.Message;
import org.jingjie.restful.messenger.model.Profile;

public class DatabaseClass {
	
	private static Map<Long, Message> messages = new HashMap<>();
	// profile name and profile
	private static Map<String, Profile> profiles = new HashMap<>();
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
}
