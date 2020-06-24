package org.wcci.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Populator implements CommandLineRunner {
    @Autowired
    ActivityRepository activityRepo;
    @Autowired
    HashtagRepository hashtagRepo;
    @Autowired
    PostRepository postRepo;

    @Override
    public void run(String... args) throws Exception {
    Activity theater = new Activity("Theater");
    Activity science = new Activity("Science");
    Activity nature = new Activity("Nature");
    Activity food = new Activity ("Food");
    Activity professionalSports = new Activity ("Professional Sports");
    activityRepo.save(theater);
    activityRepo.save(science);
    activityRepo.save(nature);
    activityRepo.save(food);
    activityRepo.save(professionalSports);
    Hashtag hashtag1 = new Hashtag("PerformingArts");
    hashtagRepo.save(hashtag1);
//    Post post1 = new Post(1,"Ohio Theater", "Check out the \"Official Theatre of the State of Ohio\"" +
//            "by visiting Capitol Square and catching a performance at the Ohio Theatre.The Ohio Theatre " +
//            "hosts more than 100 performances each year and is one of Ohio's busiest performing arts facilities. " +
//            "It is known for its Spanish-Baroque architectural design and decoration. Whether you are in the mood for " +
//            "a Broadway tour, classical music, movies, popular artists, or modern dance, the Ohio Theater is an excellent " +
//            "date spot for any occasion. ", 06/23/2020, 20:20, "Kendyl Hull", theater, hashtag1, #performingarts #singing #play # artist);
//    Post post2 = new Post("For those who are interested in taking a walk on the wilder side of theater, then Shadowbox Live is for you. " +
//            "Shadowbox Live is a constantly evolving mix of original productions, dance, sketch comedies, rock 'n' roll revues, and rockumentaries. " +
//            "This theater company continues to grow as it focuses on projects that grow its roots in the Columbus community. You will always be in for a " +
//            "treat where no show is quite like the last.", #artist # performingarts #rocknroll)

    }
}
