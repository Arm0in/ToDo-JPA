package ir.maktab.view;

import ir.maktab.domain.Activity;
import ir.maktab.domain.User;
import ir.maktab.repository.impl.ActivityRepositoryImpl;
import ir.maktab.service.ActivityService;
import ir.maktab.service.impl.ActivityServiceImpl;
import ir.maktab.util.Helper;

import java.util.Comparator;

public class UserMenu extends Menu {

    ActivityService service = new ActivityServiceImpl(new ActivityRepositoryImpl());

    public UserMenu() {
        super(new String[]{
                "View All Activities",
                "Create New Activity",
                "Edit Activity Status",
                "Logout"
        });
    }

    public void run(User currentUser) {
        while (true) {
            showMenu();
            String chosenItem = scanner.nextLine();
            switch (chosenItem) {
                case "1":
                    System.out.println(service.getUserActivities(currentUser));
                    new OrderMenu().run(currentUser);
                    break;
                case "2":
                    service.createNewActivity(currentUser);
                    break;
                case "3":
                    service.editActivityStatus(currentUser);
                    break;
                case "4":
                    if (Helper.check("Are you sure you want to Logout?"))
                        new MainMenu().run();
                default:
                    System.out.println("Wrong!");
                    break;
            }
        }
    }
}
