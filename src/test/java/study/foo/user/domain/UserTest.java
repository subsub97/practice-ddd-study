package study.foo.user.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.foo.user.controller.request.UserCreate;
import study.foo.user.controller.request.UserUpdate;

class UserTest {

    @DisplayName("User는 userCreate로 객체를 생성할 수 있다.")
    @Test
    public void userCanMakeUserObjectUsingUserCreate() throws Exception {
        // given
        UserCreate userCreate = UserCreate.builder()
                .email("test01@gmail.com")
                .city(("LA"))
                .street("1번지")
                .nickname("김구글")
                .build();

        // when
        User user = User.from(userCreate);

        // then
        assertThat(user.getId()).isNull();
        assertThat(user.getEmail()).isEqualTo("test01@gmail.com");
        assertThat(user.getAddress().getCity()).isEqualTo("LA");
        assertThat(user.getNickname()).isEqualTo("김구글");
    }

    @Test
    public void canUpdateUsingUserUpdateObject() throws Exception {
        // given
        User user = User.builder()
                .id(1L)
                .email("test01@gmail.com")
                .address(new Address("LA","1가"))
                .nickname("김구글")
                .build();

        UserUpdate userUpdate = UserUpdate.builder()
                .nickname("김네이버")
                .build();

        // when
        user = user.update(userUpdate.nicknameOpt(),userUpdate.cityOpt(), userUpdate.streetOpt());

        // then
        assertThat(user.getId()).isEqualTo(1L);
        assertThat(user.getNickname()).isEqualTo("김네이버");
        assertThat(user.getEmail()).isEqualTo("test01@gmail.com");
        assertThat(user.getAddress().getCity()).isEqualTo("LA");
    }

}