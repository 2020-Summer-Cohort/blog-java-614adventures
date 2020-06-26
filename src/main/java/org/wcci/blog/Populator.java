package org.wcci.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class Populator implements CommandLineRunner {
    @Autowired
    ActivityRepository activityRepo;
    @Autowired
    HashtagRepository hashtagRepo;
    @Autowired
    PostRepository postRepo;
    @Autowired
    AuthorRepository authorRepo;

    @Override
    public void run(String... args) throws Exception {
        Activity theater = new Activity("Theater");
        Activity science = new Activity("Science");
        Activity nature = new Activity("Nature");
        Activity food = new Activity("Food");
        Activity professionalSports = new Activity("Professional Sports");
        activityRepo.save(theater);
        activityRepo.save(science);
        activityRepo.save(nature);
        activityRepo.save(food);
        activityRepo.save(professionalSports);
        Hashtag hashtag1 = new Hashtag("PerformingArts");
        Hashtag hashtag2 = new Hashtag("Artist");
        Hashtag hashtag3 = new Hashtag("RocknRoll");
        Hashtag hashtag4 = new Hashtag("Singing");
        Hashtag hashtag5 = new Hashtag("Play");
        Hashtag hashtag6 = new Hashtag("Sports");
        Hashtag hashtag7 = new Hashtag("Animals");
        Hashtag hashtag8 = new Hashtag("Nature");
        Hashtag hashtag9 = new Hashtag("Science Rules");
        hashtagRepo.save(hashtag1);
        hashtagRepo.save(hashtag2);
        hashtagRepo.save(hashtag3);
        hashtagRepo.save(hashtag4);
        hashtagRepo.save(hashtag5);
        hashtagRepo.save(hashtag6);
        hashtagRepo.save(hashtag7);
        hashtagRepo.save(hashtag8);
        hashtagRepo.save(hashtag9);
        Author author1 = new Author("Kendyl Hull");
        Author author2 = new Author("Kyle Wang");
        authorRepo.save(author1);
        authorRepo.save(author2);
        Post post1 = new Post("Ohio Theater", "Check out the \"Official Theatre of the State of Ohio\"" +
                "by visiting Capitol Square and catching a performance at the Ohio Theatre.The Ohio Theatre " +
                "hosts more than 100 performances each year and is one of Ohio's busiest performing arts facilities. " +
                "It is known for its Spanish-Baroque architectural design and decoration. Whether you are in the mood for " +
                "a Broadway tour, classical music, movies, popular artists, or modern dance, the Ohio Theater is an excellent " +
                "date spot for any occasion. ", LocalDate.now(), LocalTime.now(), author1, theater, hashtag1, hashtag2, hashtag4, hashtag5);
        Post post2 = new Post("Shadowbox Live", "For those who are interested in taking a walk on the wilder side of theater, then Shadowbox Live is for you. " +
                "Shadowbox Live is a constantly evolving mix of original productions, dance, sketch comedies, rock 'n' roll revues, and rockumentaries. " +
                "This theater company continues to grow as it focuses on projects that grow its roots in the Columbus community. You will always be in for a " +
                "treat where no show is quite like the last.", LocalDate.now(), LocalTime.now(), author1, theater, hashtag1, hashtag2, hashtag3);
        Post post3 = new Post("Columbus Blue Jackets", "The Columbus Blue Jackets are a professional ice hockey team based in Columbus, Ohio. They " +
                "compete in the National Hockey League and currently play at Nationwide Arena.  Games are a festivity of events starting with the high intensity " +
                "game, to free giveaways, to getting to meet Stinger, a 6-foot 9-inch bright green bug that acts as the mascot for the Blue Jackets, and there's no better " +
                "sensation than when the Cannon, which replicates a 1857 Napoleon cannon fires off whenever the Blue Jackets score.", LocalDate.now(), LocalTime.now(), author2, professionalSports, hashtag6);
        Post post4 = new Post("Columbus Clippers", "The Columbus Clippers are a professional Minor League Baseball team based in Columbus, Ohio. The team plays in the " +
                "International League and is the Triple-A affiliate of the Cleveland Indians and currently play at Huntington Stadium.  Games are a great ball of fun starting with a " +
                "view that overlooks the entire Columbus skyline, fun events such as dime-a-dog night, the always eventful hotdog race when actors dress up as your favorite food items and race to home plate" +
                "and of course cheering on your favorite Clippers team who are annually one of the best in the league. ", LocalDate.now(), LocalTime.now(), author2, professionalSports, hashtag6);
        Post post5 = new Post("Columbus Zoo and Aquarium", "With 10,000 animals in six distinct regions the Columbus Zoo and Aquarium is an education and recreational complex that provides a journey for your " +
                "body and your imagination.  Go meet the famous Zoo Director, Jack Hanna, or go see your favorite animals such as the lion in the zoo or the manatee in the aquarium.  Additionally, there's a water park " +
                "and a golf course right next door that you can spend a whole weekend with the family.", LocalDate.now(), LocalTime.now(), author2, science, hashtag7, hashtag8);
        Post post6 = new Post("COSI", "COSI is a nationally esteemed science center that has delighted Central Ohio with all things science for 55 years, inspiring interest in science, technology, engineering, and math (STEM)" +
                " topics and delivering our experiential, hands-on fun brand of learning. Go visit the Dinosaur and DC Superheroes exhibits and make sure to save time for the famous Planetarium.", LocalDate.now(), LocalTime.now(), author2, science, hashtag9);
        postRepo.save(post1);
        postRepo.save(post2);
        postRepo.save(post3);
        postRepo.save(post4);
        postRepo.save(post5);
        postRepo.save(post6);
    }
}
