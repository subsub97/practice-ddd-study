package study.foo.user.service.port;

import java.util.Optional;
import study.foo.user.domain.User;

public interface UserRepository {

    Optional<User> findById(long id);

    Optional<User> findByEmail(String email);

    User save(User user);

}