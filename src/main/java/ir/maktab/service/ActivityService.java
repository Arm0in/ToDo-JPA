package ir.maktab.service;

import ir.maktab.base.service.BaseService;
import ir.maktab.domain.Activity;
import ir.maktab.domain.User;

import java.util.List;

public interface ActivityService extends BaseService<Activity, Integer> {
    List<Activity> getUserActivities(User currentUser);

    Activity createNewActivity(User currentUser);

    Activity editActivityStatus(User currentUser);
}
