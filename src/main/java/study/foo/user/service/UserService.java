package study.foo.user.service;

import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.foo.user.domain.User;
import study.foo.user.controller.request.UserCreate;
import study.foo.user.controller.request.UserUpdate;
import study.foo.user.service.port.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Not found user with id: " + id));
    }

    @Transactional
    public User create(UserCreate userCreate) {
        // User user = User.from(userCreate); 이게 좋은지
        User user = userCreate.toDomain(); // 도메인이 DTO를 알 필요가 없으므로 더 좋을것 같음
        return userRepository.save(user);
    }

    @Transactional
    public User update(long id, UserUpdate userUpdate) {
        User user = getById(id);

        // 현재는 user 도메인이 update()를 사용해서 dto를 받아서 처리하는 from 방식으로 구현
        user = user.update(
                userUpdate.nicknameOpt(),
                userUpdate.cityOpt(),
                userUpdate.streetOpt()
        );
        user = userRepository.save(user);
        return user;
    }

}