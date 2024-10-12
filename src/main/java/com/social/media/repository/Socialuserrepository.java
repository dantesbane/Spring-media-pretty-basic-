package com.social.media.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.social.media.models.SocialUser;
@Repository

public interface Socialuserrepository extends JpaRepository<SocialUser, Long>{

}
