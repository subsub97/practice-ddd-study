package study.foo.user.controller.request;

import lombok.Builder;
import lombok.Data;
import study.foo.user.domain.Address;
import study.foo.user.domain.User;

@Data
@Builder
public class UserCreate {
    private String email;
    private String nickname;
    private String city;
    private String street;

    public User toDomain() {
        Address address = new Address(city, street);
        return User.builder()
                .email(email)
                .nickname(nickname)
                .address(address)
                .build();
    }
}