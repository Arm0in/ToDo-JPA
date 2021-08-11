package ir.maktab.repository;

import ir.maktab.base.repository.BaseRepository;
import ir.maktab.domain.User;

public interface UserRepository extends BaseRepository<User, Integer> {
    User findByUserPass(String username, String password);
}
