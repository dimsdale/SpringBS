package ua.sdo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.sdo.model.users.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.login = :login")
    User findByName(@Param("login") String login);

    @Query("SELECT u from User u where u.role.id = 1")
    List<User> getAllClients();

    @Modifying
    @Query("update User u  set  u.login = :login  where u.id = :id ")
    void updateLogin(@Param("login") String login, @Param("id") int id);

    @Modifying
    @Query("update  User u set  u.password = :password where u.id = :id")
    void updatePassword(@Param("password") String password, @Param("id") int id);
}