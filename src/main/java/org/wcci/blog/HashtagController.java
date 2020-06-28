package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HashtagController {
    HashtagStorage hashtagStorage;

    public HashtagController(HashtagStorage hashtagStorage) {
        this.hashtagStorage = hashtagStorage;
    }

    @GetMapping("hashtags/{hashtag}")
    public String showSingleHashtag(@PathVariable String hashtag, Model model) {
        model.addAttribute("hashtag", hashtagStorage.findHashtagByName(hashtag));
        model.addAttribute("hashtags", hashtagStorage.getAllHashtags());
        return "hashtag-template";
    }

    @GetMapping("hashtags")
    public String showAllHashtags(Model model) {
        model.addAttribute("hashtags", hashtagStorage.getAllHashtags());
        return "hashtags-template";
    }


    @PostMapping("/hashtags/add")
    public String addHashtag(String hashtag) {
        if (hashtagStorage.findHashtagByName(hashtag) != null) {
            return "redirect:/hashtags";
        }
        Hashtag hashtagsToAdd = new Hashtag(hashtag);
        hashtagStorage.addHashtags(hashtagsToAdd);
        return "redirect:/hashtags";
    }


}
