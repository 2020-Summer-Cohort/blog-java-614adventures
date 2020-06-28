package org.wcci.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JpaWiringTest {
    @Autowired
    private PostRepository postRepo;
    @Autowired
    private ActivityRepository activityRepo;
    @Autowired
    private HashtagRepository hashtagRepo;
    @Autowired
    private AuthorRepository authorRepo;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void activityCanHaveMultiplePosts() {
        Activity activity1 = new Activity("Theater");
        activityRepo.save(activity1);
        Hashtag hashtag1 = new Hashtag("Show");
        hashtagRepo.save(hashtag1);
        Author author1 = new Author("Kendyl Hull");
        authorRepo.save(author1);
        Post post1 = new Post("Ohio Theater", "Check out the \"Official Theatre of the State of Ohio\"" +
                "by visiting Capitol Square and catching a performance at the Ohio Theatre.The Ohio Theatre " +
                "hosts more than 100 performances each year and is one of Ohio's busiest performing arts facilities. " +
                "It is known for its Spanish-Baroque architectural design and decoration. Whether you are in the mood for " +
                "a Broadway tour, classical music, movies, popular artists, or modern dance, the Ohio Theater is an excellent " +
                "date spot for any occasion. ", LocalDate.now(), LocalTime.now(), author1, activity1, hashtag1);
        Post post2 = new Post("Shadowbox Live", "For those who are interested in taking a walk on the wilder side of theater, then Shadowbox Live is for you. " +
                "Shadowbox Live is a constantly evolving mix of original productions, dance, sketch comedies, rock 'n' roll revues, and rockumentaries. " +
                "This theater company continues to grow as it focuses on projects that grow its roots in the Columbus community. You will always be in for a " +
                "treat where no show is quite like the last.", LocalDate.now(), LocalTime.now(), author1, activity1, hashtag1);
        postRepo.save(post1);
        postRepo.save(post2);
        entityManager.flush();
        entityManager.clear();

        Activity retrievedActivity = activityRepo.findById(activity1.getId()).get();
        assertThat(retrievedActivity).isEqualTo(activity1);
        assertThat(retrievedActivity.getPosts()).containsExactlyInAnyOrder(post1, post2);
    }

    @Test
    public void hashtagsCanHaveMultiplePosts() {
        Activity activity1 = new Activity("Theater");
        activityRepo.save(activity1);
        Hashtag hashtag1 = new Hashtag("Show");
        hashtagRepo.save(hashtag1);
        Author author1 = new Author("Kendyl Hull");
        authorRepo.save(author1);
        Post post1 = new Post("Ohio Theater", "Check out the \"Official Theatre of the State of Ohio\"" +
                "by visiting Capitol Square and catching a performance at the Ohio Theatre.The Ohio Theatre " +
                "hosts more than 100 performances each year and is one of Ohio's busiest performing arts facilities. " +
                "It is known for its Spanish-Baroque architectural design and decoration. Whether you are in the mood for " +
                "a Broadway tour, classical music, movies, popular artists, or modern dance, the Ohio Theater is an excellent " +
                "date spot for any occasion. ", LocalDate.now(), LocalTime.now(), author1, activity1, hashtag1);
        Post post2 = new Post("Shadowbox Live", "For those who are interested in taking a walk on the wilder side of theater, then Shadowbox Live is for you. " +
                "Shadowbox Live is a constantly evolving mix of original productions, dance, sketch comedies, rock 'n' roll revues, and rockumentaries. " +
                "This theater company continues to grow as it focuses on projects that grow its roots in the Columbus community. You will always be in for a " +
                "treat where no show is quite like the last.", LocalDate.now(), LocalTime.now(), author1, activity1, hashtag1);
        postRepo.save(post1);
        postRepo.save(post2);
        entityManager.flush();
        entityManager.clear();

        Hashtag retrievedHashtag = hashtagRepo.findById(hashtag1.getId()).get();
        assertThat(retrievedHashtag).isEqualTo(hashtag1);
        assertThat(retrievedHashtag.getPosts()).containsExactlyInAnyOrder(post1, post2);
    }

    @Test
    public void authorsCanHaveMultiplePosts() {
        Activity activity1 = new Activity("Theater");
        activityRepo.save(activity1);
        Hashtag hashtag1 = new Hashtag("Show");
        hashtagRepo.save(hashtag1);
        Author author1 = new Author("Kendyl Hull");
        authorRepo.save(author1);
        Post post1 = new Post("Ohio Theater", "Check out the \"Official Theatre of the State of Ohio\"" +
                "by visiting Capitol Square and catching a performance at the Ohio Theatre.The Ohio Theatre " +
                "hosts more than 100 performances each year and is one of Ohio's busiest performing arts facilities. " +
                "It is known for its Spanish-Baroque architectural design and decoration. Whether you are in the mood for " +
                "a Broadway tour, classical music, movies, popular artists, or modern dance, the Ohio Theater is an excellent " +
                "date spot for any occasion. ", LocalDate.now(), LocalTime.now(), author1, activity1, hashtag1);
        Post post2 = new Post("Shadowbox Live", "For those who are interested in taking a walk on the wilder side of theater, then Shadowbox Live is for you. " +
                "Shadowbox Live is a constantly evolving mix of original productions, dance, sketch comedies, rock 'n' roll revues, and rockumentaries. " +
                "This theater company continues to grow as it focuses on projects that grow its roots in the Columbus community. You will always be in for a " +
                "treat where no show is quite like the last.", LocalDate.now(), LocalTime.now(), author1, activity1, hashtag1);
        postRepo.save(post1);
        postRepo.save(post2);
        entityManager.flush();
        entityManager.clear();

        Author retrievedAuthor = authorRepo.findById(author1.getId()).get();
        assertThat(retrievedAuthor).isEqualTo(author1);
        assertThat(retrievedAuthor.getPosts()).containsExactlyInAnyOrder(post1, post2);
    }

    @Test
    public void postsCanHaveMultipleHashtags() {
        Activity activity1 = new Activity("Theater");
        activityRepo.save(activity1);
        Hashtag hashtag1 = new Hashtag("Show");
        Hashtag hashtag2 = new Hashtag("Entertainment");
        hashtagRepo.save(hashtag1);
        hashtagRepo.save(hashtag2);
        Author author1 = new Author("Kendyl Hull");
        authorRepo.save(author1);
        Post post1 = new Post("Ohio Theater", "Check out the \"Official Theatre of the State of Ohio\"" +
                "by visiting Capitol Square and catching a performance at the Ohio Theatre.The Ohio Theatre " +
                "hosts more than 100 performances each year and is one of Ohio's busiest performing arts facilities. " +
                "It is known for its Spanish-Baroque architectural design and decoration. Whether you are in the mood for " +
                "a Broadway tour, classical music, movies, popular artists, or modern dance, the Ohio Theater is an excellent " +
                "date spot for any occasion. ", LocalDate.now(), LocalTime.now(), author1, activity1, hashtag1, hashtag2);
        postRepo.save(post1);
        entityManager.flush();
        entityManager.clear();
        Post retrievedPost = postRepo.findById(post1.getId()).get();
        assertThat(retrievedPost).isEqualTo(post1);
        assertThat(retrievedPost.getHashtags()).containsExactlyInAnyOrder(hashtag1, hashtag2);
    }

}
