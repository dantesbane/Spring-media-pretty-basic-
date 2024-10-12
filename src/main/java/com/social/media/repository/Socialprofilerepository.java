package com.social.media.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.social.media.models.SocialProfile;
@Repository

public interface Socialprofilerepository extends JpaRepository<SocialProfile, Long> {

}
