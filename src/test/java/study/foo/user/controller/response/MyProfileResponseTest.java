package study.foo.user.controller.response;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import study.foo.user.domain.Address;
import study.foo.user.domain.User;

class MyProfileResponseTest {

    @Test
    public void canMakeResponseFromUser() throws Exception {
        // given
        User user = User.builder()
                .id(1L)
                .email("test01@gmail.com")
                .address(new Address("LA", "1가"))
                .nickname("김구글")
                .build();

        // when
        MyProfileResponse myProfileResponse = MyProfileResponse.from(user);

        // then
        assertThat(myProfileResponse.getId()).isEqualTo(1L);
        assertThat(myProfileResponse.getEmail()).isEqualTo("test01@gmail.com");
        assertThat(myProfileResponse.getAddress().getCity()).isEqualTo("LA");
        assertThat(myProfileResponse.getNickname()).isEqualTo("김구글");
    }

}