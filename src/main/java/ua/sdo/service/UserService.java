package ua.sdo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ua.sdo.model.users.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    void createUser(User user);
    User findByName(String login);
    void updateLogin(String login, int id);
    void updatePassword(String password, int id );
    List<User> getAll();
}
