package com.social.media.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.social.media.models.SocialUser;
import com.social.media.service.Socialservice;

@RestController
public class Socialcontroller {
    @Autowired
    private Socialservice socialservice;
    
    @GetMapping("/social/users")
    public ResponseEntity<List<SocialUser>> getusers(){
        return new ResponseEntity<>(socialservice.getallusers(),HttpStatus.OK);
    }

    @PostMapping("/social/users")
    public ResponseEntity<SocialUser> postusers(@RequestBody SocialUser socialuser){
        return new ResponseEntity<>(socialservice.adduser(socialuser),HttpStatus.OK); 
    }
}
