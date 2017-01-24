package ua.sdo.service;

import ua.sdo.model.users.User;

import java.util.List;

public interface UserService{

    void createUser(User user);
    User findByName(String login);
    void updateLogin(String login, int id);
    void updatePassword(String password, int id );
    List<User> getAll();
    User getByIdUser(int id);
    List<User> getAllClients();
}
