package ir.maktab.service.impl;

import ir.maktab.base.service.impl.BaseServiceImpl;
import ir.maktab.domain.User;
import ir.maktab.repository.UserRepository;
import ir.maktab.service.UserService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UserServiceImpl extends BaseServiceImpl<User, Integer, UserRepository> implements UserService {

    Scanner scanner = new Scanner(System.in);

    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }

    @Override
    public User login() {
        System.out.println("Please enter your Username: ");
        String username = scanner.nextLine();
        System.out.println("Please enter your Password: ");
        String password = scanner.nextLine();
        User user = repository.findByUserPass(username, password);
        if (user == null) {
            System.out.println("Incorrect Login credentials!");
        } else if (!user.isStatus()) {
            System.out.println("Your account is not active!");
        }
        return user;
    }

    @Override
    public User register() {
        User user = new User();
        System.out.println("Please enter username: ");
        user.setUsername(scanner.nextLine());
        System.out.println("Please enter national code: ");
        String nationalCode = scanner.nextLine();
        user.setNationalCode(nationalCode);
        user.setPassword(nationalCode);
        System.out.println("Please enter birthday yyyy-mm-dd: ");
        String str = scanner.nextLine();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        user.setBirthday(LocalDate.parse(str, dtf));
        user.setStatus(true);
        user.setDeleted(false);
        repository.save(user);
        System.out.println("Registered successfully.");
        return user;
    }


}
