
package com.social.media;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.social.media.models.Posts;
import com.social.media.models.SocialGroup;
import com.social.media.models.SocialProfile;
import com.social.media.models.SocialUser;
import com.social.media.repository.Postsrepository;
import com.social.media.repository.Socialgrouprepository;
import com.social.media.repository.Socialprofilerepository;
import com.social.media.repository.Socialuserrepository;

@Configuration
public class Datainitializer {
    private final Socialuserrepository userRepository;
    private final Socialgrouprepository groupRepository;
    private final Socialprofilerepository socialProfileRepository;
    private final Postsrepository postRepository;

    public Datainitializer(Socialuserrepository userRepository, Socialgrouprepository groupRepository, Socialprofilerepository socialProfileRepository, Postsrepository postRepository) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
        this.socialProfileRepository = socialProfileRepository;
        this.postRepository = postRepository;
    }

    @Bean
    public CommandLineRunner initializeData() {
        return (args) -> {
            // Create users
            SocialUser user1 = new SocialUser();
            SocialUser user2 = new SocialUser();
            SocialUser user3 = new SocialUser();
            
            userRepository.save(user1);  // Save initial users
            userRepository.save(user2);
            userRepository.save(user3);

            // Create groups
            SocialGroup group1 = new SocialGroup();
            SocialGroup group2 = new SocialGroup();
            
            // Set group members
            group1.getSocialusers().add(user1);  // Add users to group
            group1.getSocialusers().add(user2);
            group2.getSocialusers().add(user2);
            group2.getSocialusers().add(user3);

            // Save groups
            groupRepository.save(group1);  // Save groups after adding users
            groupRepository.save(group2);

            // Add groups to users (JPA should manage this if mappedBy is used correctly)
            user1.getGroup().add(group1);  // Add groups to user
            user2.getGroup().add(group1);
            user2.getGroup().add(group2);
            user3.getGroup().add(group2);

            userRepository.save(user1);  // Save users after assigning groups
            userRepository.save(user2);
            userRepository.save(user3);

            // // Create posts and assign users
            Posts post1 = new Posts();
            Posts post2 = new Posts();
            Posts post3 = new Posts();
            post1.setSocialuser(user1);
            post2.setSocialuser(user2);
            post3.setSocialuser(user3);
            postRepository.save(post1);  // Save posts
            postRepository.save(post2);
            postRepository.save(post3);

            // // Create profiles and assign users
            SocialProfile profile1 = new SocialProfile();
            SocialProfile profile2 = new SocialProfile();
            SocialProfile profile3 = new SocialProfile();
            profile1.setSocialuser(user1);
            profile2.setSocialuser(user2);
            profile3.setSocialuser(user3);
            socialProfileRepository.save(profile1);  // Save profiles
            socialProfileRepository.save(profile2);
            socialProfileRepository.save(profile3);
        };
    }
}
