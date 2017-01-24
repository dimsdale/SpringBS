package ua.sdo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.sdo.constants.Constant;
import ua.sdo.model.users.User;
import ua.sdo.repository.RoleRepository;
import ua.sdo.repository.UserRepository;
import ua.sdo.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(roleRepository.getOne(Constant.ROLE_USER_ID));
        userRepository.save(user);
    }

    @Override
    public User findByName(String login) {
        return  userRepository.findByName(login);
    }

    @Override
    public void updateLogin(String login, int id) {
        userRepository.updateLogin(login, id);
    }

    @Override
    public void updatePassword(String password, int id) {
        userRepository.updatePassword(password, id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getByIdUser(int id) {
        return userRepository.getOne(id);
    }

    @Override
    public List<User> getAllClients() {
        return userRepository.getAllClients();
    }
}
