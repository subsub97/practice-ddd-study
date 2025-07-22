package study.foo.user.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.foo.mock.FakeUserRepository;
import study.foo.user.domain.User;
import study.foo.user.controller.request.UserCreate;
import study.foo.user.service.port.UserRepository;

class UserServiceTest {

    private UserService userService;

    @BeforeEach
    void init() {
        UserRepository fakeUserRepository = new FakeUserRepository();
        userService = new UserService(fakeUserRepository);
    }

    @Test
    public void createNewUser() throws Exception {
        // given
        UserCreate userCreate = UserCreate.builder()
                .email("test01@gmail.com")
                .city("LA")
                .street("1가")
                .nickname("김구글")
                .build();

        // when
        User newUser = userService.create(userCreate);

        // then
        assertThat(newUser.getId()).isNotNull();
        assertThat(newUser.getEmail()).isEqualTo("test01@gmail.com");
        assertThat(newUser.getNickname()).isEqualTo("김구글");
        assertThat(newUser.getAddress().getCity()).isEqualTo("LA");
    }

}