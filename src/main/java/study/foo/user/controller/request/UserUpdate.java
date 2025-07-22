package study.foo.user.controller.request;

import java.util.Optional;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserUpdate {
    private String nickname;
    private String city;
    private String street;


    // 이렇게 DTO에서 Optional을 사용해서 수정 값을 검증하는 방식이 괜찮을까?
    public Optional<String> nicknameOpt() {
        return Optional.ofNullable(nickname)
                .filter(n -> !n.isBlank());
    }

    public Optional<String> cityOpt() {
        return Optional.ofNullable(city)
                .filter(c -> !c.isBlank());
    }

    public Optional<String> streetOpt() {
        return Optional.ofNullable(street)
                .filter(s -> !s.isBlank());
    }
}