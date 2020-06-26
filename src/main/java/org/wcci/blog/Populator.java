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
        Hashtag hashtag10 = new Hashtag("YummyInMyTummy");
        Hashtag hashtag11 = new Hashtag("Drool");
        Hashtag hashtag12 = new Hashtag("Waterfall");
        Hashtag hashtag13 = new Hashtag("Woods");
        Hashtag hashtag14 = new Hashtag("Date");
        Hashtag hashtag15 = new Hashtag("InstaPicDestination");
        Hashtag hashtag16 = new Hashtag("Eagles");
        Hashtag hashtag17 = new Hashtag("DogFriendly");
        Hashtag hashtag18 = new Hashtag("Trails");
        Hashtag hashtag19 = new Hashtag("PokemonGo");
        Hashtag hashtag20 = new Hashtag("Fishing");
        Hashtag hashtag21 = new Hashtag("Volleyball");
        Hashtag hashtag22 = new Hashtag("LiveMusic");
        Hashtag hashtag23 = new Hashtag("Food&Drink");
        Hashtag hashtag24 = new Hashtag("Brewery");
        hashtagRepo.save(hashtag1);
        hashtagRepo.save(hashtag2);
        hashtagRepo.save(hashtag3);
        hashtagRepo.save(hashtag4);
        hashtagRepo.save(hashtag5);
        hashtagRepo.save(hashtag6);
        hashtagRepo.save(hashtag7);
        hashtagRepo.save(hashtag8);
        hashtagRepo.save(hashtag9);
        hashtagRepo.save(hashtag10);
        hashtagRepo.save(hashtag11);
        hashtagRepo.save(hashtag12);
        hashtagRepo.save(hashtag13);
        hashtagRepo.save(hashtag14);
        hashtagRepo.save(hashtag15);
        hashtagRepo.save(hashtag16);
        hashtagRepo.save(hashtag17);
        hashtagRepo.save(hashtag18);
        hashtagRepo.save(hashtag19);
        hashtagRepo.save(hashtag20);
        hashtagRepo.save(hashtag21);
        hashtagRepo.save(hashtag22);
        hashtagRepo.save(hashtag23);
        hashtagRepo.save(hashtag24);
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
        Post post7 = new Post("Shake Shack", "This modern day roadside burger stand serves up the most delicious burgers, hot dogs, frozen custard, shakes, beer, wine and more. An instant neighborhood fixture, Shake Shack welcomed people from all over the city, " +
                "country and world who gathered together to enjoy fresh, simple, high-quality versions of the classics in a majestic setting.", LocalDate.now(), LocalTime.now(), author2, food, hashtag10, hashtag11);
        Post post8 = new Post("Indian Run Falls", "Indian Run Falls is a beautiful secluded spot near Historic Dublin. Nestled in a small wooded area, you come across a bridge with an overlook to the first fall and then nature trails leading to different views  of the second " +
                "larger fall and the gorge. This is a great spot to get close with nature without having to travel far.", LocalDate.now(), LocalTime.now(), author1, nature, hashtag12, hashtag13, hashtag14);
        Post post9 = new Post("Hayden Run Falls", "Hayden Run Falls has everything you are looking for in a fun waterfall location. From the long trail leading down to the waterfall basin, to surrounding tall trees, songbirds, the Scioto River glistening between tree trunks, and the sounds of " +
                "the rushing water. Great date spot to hang out and explore.", LocalDate.now(), LocalTime.now(), author1, nature, hashtag12, hashtag14, hashtag15);
        Post post10 = new Post("Gogi Korean BBQ", "Gogi Korean BBQ offers a wide variety of Korean cuisine with a specialization in barbecue meats that are not found in most Korean restaurants. They utilize beef & pork that are fed natural ingredients in a free range.",
                LocalDate.now(), LocalTime.now(), author2, food, hashtag10, hashtag11);
        Post post11 = new Post("Highbanks Metro Park", "Highbanks Metro Park is a fun place to explore. They have many nature trails that lead to great views. A nice spot where wildlife is abundant. While visiting be sure to have a picnic under a tree or use one of their shelters. The guest visitor center " +
                "has many education displays which is great for any avid environmental learner.", LocalDate.now(), LocalTime.now(), author1, nature, hashtag16, hashtag17, hashtag18, hashtag19, hashtag20);
        Post post12 = new Post("Columbus Crew", "The Columbus Crew are an American professional soccer club based in Columbus, Ohio. The Crew competes in Major League Soccer and play at Mapfre Stadium. Go sit in the Nordecke Section and join a rabid fan base that beats drums, sings songs, " +
                "and lights up smoke bombs when the Crew score goals.  Additionally, you can hang out with the Columbus Crew mascot Crew Cat.  You'll leave the event a passionate fan of soccer as well as the Columbus Crew", LocalDate.now(), LocalTime.now(), author2, professionalSports, hashtag6);
        Post post13 = new Post("The Big Bang Columbus", "The Big Bang combines music, comedy and audience participation into a fast-paced, high-energy show that’s unlike anything you’ve ever experienced. With two pianos and two performers, it’s non-stop, totally wild fun. The music is based entirely on audience " +
                "requests, so every night is different—but no matter what, an amazing sing-along, laugh-along, dance-along night is always guaranteed.", LocalDate.now(), LocalTime.now(), author2, theater, hashtag1, hashtag4, hashtag5);
        Post post14 = new Post("The Goat", "This is a fun and relaxed restaurant that strives to create a unique environment where people go to be together and disconnect. Their delicious menu never stops impressing patrons. If you aren't in the mood for food, take your friend or your \"friend\" and try a few crafted cocktails " +
                "or local bourbons & brews while watching a live music performance.", LocalDate.now(), LocalTime.now(), author1, food, hashtag21, hashtag22, hashtag23, hashtag24);
        Post post15 = new Post("Columbus Museum of Art", "The Columbus Museum of Art is an art museum in downtown Columbus, Ohio.  The museum is a nice place to come and enjoy the beauty that others have created. There is much diversity with the types of art on display.  The food is tremendous, the staff is so kind and the grounds make for exceptional photos.",
                LocalDate.now(), LocalTime.now(), author2, science, hashtag9, hashtag14);
        postRepo.save(post1);
        postRepo.save(post2);
        postRepo.save(post3);
        postRepo.save(post4);
        postRepo.save(post5);
        postRepo.save(post6);
        postRepo.save(post7);
        postRepo.save(post8);
        postRepo.save(post9);
        postRepo.save(post10);
        postRepo.save(post11);
        postRepo.save(post12);
        postRepo.save(post13);
        postRepo.save(post14);
        postRepo.save(post15);
    }
}
