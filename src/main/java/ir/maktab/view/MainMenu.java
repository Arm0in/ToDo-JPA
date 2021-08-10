package ir.maktab.view;


import ir.maktab.domain.User;
import ir.maktab.repository.impl.UserRepositoryImpl;
import ir.maktab.service.UserService;
import ir.maktab.service.impl.UserServiceImpl;
import ir.maktab.util.Helper;

public class MainMenu extends Menu {

    UserService userService = new UserServiceImpl(new UserRepositoryImpl());

    public MainMenu() {
        super(new String[]{
                "Login",
                "Register",
                "Exit"
        });
    }

    public void run() {
        while (true) {
            showMenu();
            String chosenItem = scanner.nextLine();
            switch (chosenItem) {
                case "1":
                    User currentUser = userService.login();
                    break;
                case "2":
                    userService.register();
                    break;
                case "3":
                    if (Helper.check("Are you sure you want to Exit?"))
                        System.exit(0);
                default:
                    System.out.println("Wrong!");
                    break;
            }
        }
    }
}
