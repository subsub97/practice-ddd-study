package study.foo.user.controller.response;

import lombok.Builder;
import lombok.Data;
import study.foo.user.domain.Address;
import study.foo.user.domain.User;

@Data
@Builder
public class MyProfileResponse {

    private final Long id;
    private final String email;
    private final String nickname;
    private final Address address;

    public static MyProfileResponse from(User user) {
        return MyProfileResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .address(user.getAddress())
                .nickname(user.getNickname())
                .build();
    }

}