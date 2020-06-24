package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    ActivityRepository activityRepo;

    public HomeController(ActivityRepository activityRepo) {

        this.activityRepo = activityRepo;
    }

    @RequestMapping({"","/"})
    public String showHome(Model model) {
        model.addAttribute("activities", activityRepo.findAll());
        return "home-template";
    }

}
