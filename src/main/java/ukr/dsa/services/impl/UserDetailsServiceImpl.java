package ukr.dsa.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ukr.dsa.model.Roles;
import ukr.dsa.model.User;
import ukr.dsa.repositories.UserRepository;
import ukr.dsa.services.UserService;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService, UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = getUser(s);
        Set<GrantedAuthority> roles = new HashSet();
        roles.add(new SimpleGrantedAuthority(Roles.USER.name()));
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), roles);
        return userDetails;
    }

    @Override
    public User getUser(String login) {
        return userRepository.findByName(login);
    }

    @Override
    public void createUser(User user) {
        userRepository.saveAndFlush(user);
    }
}
