package com.social.media.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.media.models.SocialUser;
import com.social.media.repository.Socialuserrepository;
@Service
public class Socialservice {
    @Autowired
    private Socialuserrepository userrepo;

    public List<SocialUser> getallusers(){
        return userrepo.findAll();
    }

    public SocialUser adduser(SocialUser socio){
        userrepo.save(socio);
        return socio;
    }

}
