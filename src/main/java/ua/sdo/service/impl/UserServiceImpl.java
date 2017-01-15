package ua.sdo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.sdo.model.users.User;
import ua.sdo.repository.UserRepository;
import ua.sdo.service.UserService;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = findByName(s);
        if (user == null) throw new UsernameNotFoundException("User with username " + s + " not found");
        Set<GrantedAuthority> roles = new HashSet();
        roles.add(new SimpleGrantedAuthority(user.getUserType().name()));
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), roles);
        return userDetails;
    }

    @Override
    public void createUser(User user) {
        userRepository.saveAndFlush(user);
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
}
