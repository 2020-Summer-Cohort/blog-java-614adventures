package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    ActivityStorage activityStorage;

    public HomeController(ActivityStorage activityStorage) {
        this.activityStorage = activityStorage;
    }

    @RequestMapping({"", "/"})

    public String showHome(Model model) {
        model.addAttribute("activities", activityStorage.getAllActivities());
        return "home-template";
    }

}
