package ukr.dsa.services;

import ukr.dsa.model.User;

/**
 * Created by Surger on 03.05.2016.
 */
public interface UserService {

    public User getUser(String login);

    public void createUser(User user);
}
