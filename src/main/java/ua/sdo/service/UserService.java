package ua.sdo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ua.sdo.model.users.User;

public interface UserService extends UserDetailsService {

    void createUser(User user);
    User findByName(String login);
    void updateLogin(String login, int id);
    void updatePassword(String password, int id );
}
