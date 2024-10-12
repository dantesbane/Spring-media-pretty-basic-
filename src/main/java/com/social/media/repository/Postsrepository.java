package com.social.media.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.social.media.models.Posts;
@Repository
public interface Postsrepository extends JpaRepository<Posts, Long> {

}
