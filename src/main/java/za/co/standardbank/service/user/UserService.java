package za.co.standardbank.service.user;

import za.co.standardbank.model.User;

import java.util.List;

public interface UserService {

    void createUser(User user);

    List<User> findAllUser();

    User findById(String id);

    void updateUser(User user);

    void deleteUser(String id);
}
