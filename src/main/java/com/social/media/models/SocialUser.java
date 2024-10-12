package com.social.media.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SocialUser {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    @OneToOne(cascade=CascadeType.ALL)
    @ToString.Exclude 
    private SocialProfile socialprofile;



   

    @OneToMany(mappedBy="socialuser",cascade=CascadeType.ALL)
    @ToString.Exclude 
    private List<Posts> post=new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name="user_group1",
        joinColumns=@JoinColumn(name="userid"),
        inverseJoinColumns=@JoinColumn(name="groupid")     //nomrally for many to many you use join table to list all the groups
    )
    
    private Set<SocialGroup> group=new HashSet<>();
    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
    public void setSocialprofile(SocialProfile socialprofile) {
        socialprofile.setSocialuser(this);
        this.socialprofile = socialprofile;
    }

  
}
