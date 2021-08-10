package ir.maktab.service.impl;

import ir.maktab.base.service.impl.BaseServiceImpl;
import ir.maktab.domain.Activity;
import ir.maktab.domain.User;
import ir.maktab.domain.enumartion.ActivityStatusType;
import ir.maktab.repository.ActivityRepository;
import ir.maktab.service.ActivityService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ActivityServiceImpl extends BaseServiceImpl<Activity, Integer, ActivityRepository> implements ActivityService {

    Scanner scanner = new Scanner(System.in);

    public ActivityServiceImpl(ActivityRepository repository) {
        super(repository);
    }

    @Override
    public List<Activity> getUserActivities(User currentUser) {
        return repository.findUserActivities(currentUser);
    }

    @Override
    public Activity createNewActivity(User currentUser) {
        Activity activity = new Activity();
        System.out.println("Please enter title: ");
        activity.setTitle(scanner.nextLine());
        System.out.println("Please enter description: ");
        activity.setDescription(scanner.nextLine());
        activity.setCreatedDate(LocalDate.now());
        activity.setStatusType(ActivityStatusType.OPEN);
        activity.setDeleted(false);
        activity.setUser(currentUser);
        repository.save(activity);
        return activity;
    }

    @Override
    public Activity editActivityStatus(User currentUser) {
        System.out.println(getUserActivities(currentUser));
        System.out.println("Choose Activity with id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Activity activity = findById(id);
        System.out.println(activity);
        System.out.println("1. OPEN");
        System.out.println("2. IN_PROGRESS");
        System.out.println("3. COMPLETED");
        outerloop:
        while (true) {
            String chosenItem = scanner.nextLine();
            switch (chosenItem) {
                case "1":
                    activity.setStatusType(ActivityStatusType.OPEN);
                    break outerloop;
                case "2":
                    activity.setStatusType(ActivityStatusType.IN_PROGRESS);
                    activity.setStartedDate(LocalDate.now());
                    break outerloop;
                case "3":
                    activity.setStatusType(ActivityStatusType.COMPLETED);
                    activity.setCompleteDate(LocalDate.now());
                    break outerloop;
                default:
                    System.out.println("Wrong!");
                    break;
            }
        }
        repository.save(activity);
        return activity;
    }


}
