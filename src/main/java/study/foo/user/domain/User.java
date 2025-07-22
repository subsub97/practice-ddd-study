package study.foo.user.domain;

import java.util.Optional;
import lombok.Builder;
import lombok.Getter;
import study.foo.user.controller.request.UserCreate;
import study.foo.user.controller.request.UserUpdate;

@Getter
public class User {
    private final Long id;
    private final String email;
    private final String nickname;
    private final Address address;

    @Builder
    public User(Long id, String email, String nickname, Address address) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.address = address;
    }

    public static User from(UserCreate userCreate) {
        return User.builder()
                .email(userCreate.getEmail())
                .nickname(userCreate.getNickname())
                .address(new Address(userCreate.getCity(), userCreate.getStreet()))
                .build();
    }

    public User update(Optional<String> nicknameOpt,
                       Optional<String> cityOpt,
                       Optional<String> streetOpt) {
        return User.builder()
                .id(id)
                .email(email)
                .nickname(nicknameOpt.orElse(nickname))
                .address(new Address(
                        cityOpt.orElse(address.getCity()),
                        streetOpt.orElse(address.getStreet())
                ))
                .build();
    }
}