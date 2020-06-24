package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

}
