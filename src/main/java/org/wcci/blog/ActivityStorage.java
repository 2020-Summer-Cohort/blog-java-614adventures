package org.wcci.blog;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ActivityStorage {
    ActivityRepository activityRepo;

    public ActivityStorage(ActivityRepository activityRepo) {
        this.activityRepo = activityRepo;
    }

    public Activity findActivityByName(String name) {
        return activityRepo.findByName(name);
    }

    public Iterable<Activity> getAllActivities() {
        return activityRepo.findAll();
    }

    public void addActivity(Activity activity) {
        activityRepo.save(activity);
    }

    public Optional<Activity> findActivityByID(Long id) {
        return activityRepo.findById(id);
    }
}
