package ir.maktab.repository;

import ir.maktab.base.repository.BaseRepository;
import ir.maktab.domain.Activity;
import ir.maktab.domain.User;

import java.util.List;

public interface ActivityRepository extends BaseRepository<Activity, Integer> {
    List<Activity> findUserActivities(User user);

}
