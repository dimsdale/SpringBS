package ukr.dsa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ukr.dsa.model.User;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.login = :login")
    User findByName(@Param("login") String login);

    @Query("select count(u) from  User u where u.login = :login")
    int countUserByLogin(@Param("login") String login);

}
