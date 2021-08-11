package ir.maktab.service;

import ir.maktab.base.service.BaseService;
import ir.maktab.domain.User;

public interface UserService extends BaseService<User, Integer> {
    User login();
    User register();
}
