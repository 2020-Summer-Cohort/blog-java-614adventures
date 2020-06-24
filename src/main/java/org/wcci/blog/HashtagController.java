package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HashtagController {
    HashtagStorage hashtagStorage;
    PostStorage postStorage;

    public HashtagController(HashtagStorage hashtagStorage){
        this.hashtagStorage=hashtagStorage;
    }

    @GetMapping("hashtags/{hashtag}")
    public String showSingleHashtag(@PathVariable String hashtag, Model model) {
        model.addAttribute("hashtag", hashtagStorage.findHashtagByName(hashtag));
        model.addAttribute("hashtags", hashtagStorage.getAllHashtags());
        return "hashtag-template";
    }

    @PostMapping("hashtag/add")
    public String addHashtag(String hashtag, String postTitle){
        Post postToAddHashtag = postStorage.findPostByName(postTitle);
        Hashtag hashtagToAdd = new Hashtag(hashtag);
        hashtagStorage.addHashtags(hashtagToAdd);
        postStorage.addPost(postToAddHashtag);
        return "redirect:/posts/"+postTitle;
    }


}
