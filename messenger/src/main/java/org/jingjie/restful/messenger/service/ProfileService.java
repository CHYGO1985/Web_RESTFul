package org.jingjie.restful.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jingjie.restful.messenger.database.DatabaseClass;
import org.jingjie.restful.messenger.exception.DataNotFoundException;
import org.jingjie.restful.messenger.model.Profile;

/**
*
* The services for get and editing profiles.
* 
* @author jingjiejiang
* @history
* 1. Jun 29, 2017
*/
public class ProfileService {

	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService(){
		profiles.put("jingjie",  new Profile(1, "jingjie", "Jingjie", "Jiang"));
	}

	// get all profiles and return as a list
	public List<Profile> getAllProfiles() {
		
		return new ArrayList<Profile>(profiles.values());
	}
	
	// get a particular profile with a given profile name
	public Profile getProfile(String profileName) {
		
		Profile profile = profiles.get(profileName);
		if (profile == null) 
			throw new DataNotFoundException("The profile with profile name " + 
					profileName + " not found");
		return profiles.get(profileName);
	}
	
	// add a profile
	public Profile addProfile(Profile profile) {
		
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	// update a profile
	public Profile updateProfile(Profile profile) {
		if (profile.getProfileName() == null 
				|| profile.getProfileName().isEmpty() == true) return null;
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	// remove a profile
	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}
}
