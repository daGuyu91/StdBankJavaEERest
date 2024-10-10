package za.co.standardbank.service.user;

import za.co.standardbank.model.User;
import za.co.standardbank.repository.UserRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class UserServiceImpl  implements UserService{

    private final UserRepository userRepository;

    @Inject
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(User user) {
        user.setId(UUID.randomUUID().toString());
        userRepository.save(user);
    }

    @Override
    public List<User> findAllUser() {
        return  userRepository.findAll();
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public void updateUser(User user) {
        userRepository.update(user);
    }

    @Override
    public void deleteUser(String id) {
        userRepository.delete(id);
    }
}
