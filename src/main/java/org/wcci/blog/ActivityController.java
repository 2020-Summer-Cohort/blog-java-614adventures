package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ActivityController {

    ActivityStorage activityStorage;

    public ActivityController(ActivityStorage activityStorage) {
        this.activityStorage = activityStorage;
    }

    @GetMapping("activities/{activity}")
    public String showSingleActivity(@PathVariable String activity, Model model) {
        model.addAttribute("activity", activityStorage.findActivityByName(activity));
        model.addAttribute("activities", activityStorage.getAllActivities());
        return "activity-template";
    }

    @GetMapping("activities")
    public String showAllActivities(Model model) {
        model.addAttribute("activities", activityStorage.getAllActivities());
        return "activities-template";
    }

    @PostMapping("activities/add")
    public String addActivity(String activity) {
        if (activityStorage.findActivityByName(activity) != null) {
            return "redirect:/activities";
        }
        Activity activityToAdd = new Activity(activity);
        activityStorage.addActivity(activityToAdd);
        return "redirect:/activities";
    }

}
