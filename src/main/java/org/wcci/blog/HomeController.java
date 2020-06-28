package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    ActivityRepository activityRepo;
    HashtagRepository hashtagRepo;

    public HomeController(ActivityRepository activityRepo, HashtagRepository hashtagRepo) {
        this.activityRepo = activityRepo;
        this.hashtagRepo = hashtagRepo;
    }

    @RequestMapping({"", "/"})
    public String showHome(Model model) {
        model.addAttribute("activities", activityRepo.findAll());
        model.addAttribute("hashtags", hashtagRepo.findAll());
        return "home-template";
    }


}
