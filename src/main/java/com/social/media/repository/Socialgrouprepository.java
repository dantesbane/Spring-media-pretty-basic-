package com.social.media.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.social.media.models.SocialGroup;
@Repository

public interface Socialgrouprepository extends JpaRepository<SocialGroup, Long> {

}
