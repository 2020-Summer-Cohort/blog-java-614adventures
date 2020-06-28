package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.LocalTime;

@Controller
public class PostController {

    private PostStorage postStorage;
    private ActivityStorage activityStorage;
    private HashtagStorage hashtagsStorage;
    private AuthorStorage authorStorage;

    public PostController(PostStorage postStorage, ActivityStorage activityStorage, HashtagStorage hashtagsStorage, AuthorStorage authorStorage) {
        this.postStorage = postStorage;
        this.activityStorage = activityStorage;
        this.hashtagsStorage = hashtagsStorage;
        this.authorStorage = authorStorage;
    }

    @GetMapping("posts/{post}")
    public String showSinglePost(@PathVariable String post, Model model) {
        model.addAttribute("post", postStorage.findPostByTitle(post));
        return "post-template";
    }

    @PostMapping("/activities/posts/add")
    public String addPost(String title, String body, String author, long activity, String hashtag) {
        Author newAuthor = new Author(author);
        authorStorage.addAuthors(newAuthor);
        if (hashtagsStorage.findHashtagByName(hashtag) != null) {
            Hashtag newHashtag = hashtagsStorage.findHashtagByName(hashtag);
            Activity activityToAdd = activityStorage.findActivityByID(activity).get();
            Post newPost = new Post(title, body, LocalDate.now(), LocalTime.now(), newAuthor, activityToAdd, newHashtag);
            postStorage.addPost(newPost);
            return "redirect:/activities/" + activityToAdd.getName();
        }
        Hashtag newHashtag = new Hashtag(hashtag);
        hashtagsStorage.addHashtags(newHashtag);
        Activity activityToAdd = activityStorage.findActivityByID(activity).get();
        Post newPost = new Post(title, body, LocalDate.now(), LocalTime.now(), newAuthor, activityToAdd, newHashtag);
        postStorage.addPost(newPost);
        return "redirect:/activities/" + activityToAdd.getName();
    }

    @PostMapping("/hashtags/posts/add")
    public String addPost(String title, String body, String author, String activity, long hashtag) {
        Author newAuthor = new Author(author);
        authorStorage.addAuthors(newAuthor);
        if (activityStorage.findActivityByName(activity) != null) {
            Activity newActivity = activityStorage.findActivityByName(activity);
            Hashtag hashtagToAdd = hashtagsStorage.findByID(hashtag);
            Post newPost = new Post(title, body, LocalDate.now(), LocalTime.now(), newAuthor, newActivity, hashtagToAdd);
            postStorage.addPost(newPost);
            return "redirect:/hashtags/" + hashtagToAdd.getName();
        }
        Activity newActivity = new Activity(activity);
        activityStorage.addActivity(newActivity);
        Hashtag hashtagToAdd = hashtagsStorage.findByID(hashtag);
        Post newPost = new Post(title, body, LocalDate.now(), LocalTime.now(), newAuthor, newActivity, hashtagToAdd);
        postStorage.addPost(newPost);
        return "redirect:/hashtags/" + hashtagToAdd.getName();
    }

    @PostMapping("/posts/hashtags/add")
    public String addHashtag(long id, String hashtag) {
        Post post = postStorage.findByID(id);
        if (hashtagsStorage.findHashtagByName(hashtag) != null) {
            Hashtag hashtagToAdd = hashtagsStorage.findHashtagByName(hashtag);
            post.addHashtags(hashtagToAdd);
            postStorage.addPost(post);
            return "redirect:/posts/" + post.getTitle();
        }
        Hashtag hashtagsToAdd = new Hashtag(hashtag);
        hashtagsStorage.addHashtags(hashtagsToAdd);
        post.addHashtags(hashtagsToAdd);
        postStorage.addPost(post);
        return "redirect:/posts/" + post.getTitle();
    }
}
