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

    PostStorage postStorage;
    ActivityStorage activityStorage;
    HashtagStorage hashtagsStorage;

    public PostController(PostStorage postStorage) {
        this.postStorage = postStorage;
    }

    @GetMapping("posts/{post}")
    public String showSinglePost(@PathVariable String post, Model model) {
        model.addAttribute("post", postStorage.findPostByTitle(post));
        return "post-template";
    }

    @PostMapping("posts/add")
    public String addPost(String title, String body, LocalDate date, LocalTime time,
                          Author author, long activityId) {
        Activity postActivity = activityStorage.findActivityByID(activityId).get();
        postStorage.addPost(new Post(title, body, date, time, author, postActivity));
        return "redirect:/activities/" + postActivity.getName();
    }

    @PostMapping("/posts/hashtag/add")
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
