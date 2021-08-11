package ir.maktab.view;

import ir.maktab.domain.Activity;
import ir.maktab.domain.User;
import ir.maktab.repository.impl.ActivityRepositoryImpl;
import ir.maktab.service.ActivityService;
import ir.maktab.service.impl.ActivityServiceImpl;
import ir.maktab.util.Helper;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrderMenu extends Menu {

    ActivityService service = new ActivityServiceImpl(new ActivityRepositoryImpl());


    public OrderMenu() {
        super(new String[]{
                "Order By createDate",
                "Order By title",
                "Order By Status",
                "Back"
        });
    }

    public void run(User currentUser) {
        while (true) {
            showMenu();
            String chosenItem = scanner.nextLine();
            switch (chosenItem) {
                case "1":
                    Comparator<Activity> compareByCreateDate = new Comparator<Activity>() {
                        @Override
                        public int compare(Activity o1, Activity o2) {
                            return o1.getCreatedDate().compareTo(o2.getCreatedDate());
                        }
                    };
                    compareAscOrDesc(compareByCreateDate, currentUser);
                    break;
                case "2":
                    Comparator<Activity> compareByTitle = new Comparator<Activity>() {
                        @Override
                        public int compare(Activity o1, Activity o2) {
                            return o1.getTitle().compareTo(o2.getTitle());
                        }
                    };
                    compareAscOrDesc(compareByTitle, currentUser);
                    break;
                case "3":
                    Comparator<Activity> compareByStatus = new Comparator<Activity>() {
                        @Override
                        public int compare(Activity o1, Activity o2) {
                            return o1.getStatusType().compareTo(o2.getStatusType());
                        }
                    };
                    compareAscOrDesc(compareByStatus, currentUser);
                    break;
                case "4":
                    new UserMenu().run(currentUser);
                default:
                    System.out.println("Wrong!");
                    break;
            }
        }
    }

    public void compareAscOrDesc(Comparator comparator, User currentUser) {
        List<Activity> activities = service.getUserActivities(currentUser);
        System.out.println("1. Ascending");
        System.out.println("2. Descending");
        String choice = scanner.nextLine();
        if (choice.charAt(0) == '1') {
            Collections.sort(activities, comparator);
        } else if (choice.charAt(0) == '2')
            Collections.sort(activities, Collections.reverseOrder(comparator));
        System.out.println(activities);
    }

}
