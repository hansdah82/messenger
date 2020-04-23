package com.myapp.messenger.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.RootLogger;

import com.myapp.messenger.dao.ProfileRepository;
import com.myapp.messenger.exceptions.ProfileNotFoundException;
import com.myapp.messenger.model.entity.Profile;

public class ProfileService {

	private static final Logger LOGGER = RootLogger.getLogger(ProfileService.class);
	
	private ProfileRepository repository;

	public ProfileService() {
		repository = new ProfileRepository();
	}

	public List<Profile> getAllProfile() {
		return repository.findAll();
	}

	public Profile getProfile(String username) {
		Profile profile = null;
		try {
			profile = repository.findOne(username);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return Optional.ofNullable(profile).orElseThrow(()-> new ProfileNotFoundException("Profile not found with username : "+username));
	}

	public Profile createProfile(Profile profile) {
		profile.setCreatedOn(new Date());
		return repository.save(profile);
	}

}
