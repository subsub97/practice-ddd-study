package study.foo.user.controller;

import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import study.foo.user.controller.request.UserUpdate;
import study.foo.user.controller.response.MyProfileResponse;
import study.foo.user.domain.User;
import study.foo.user.controller.request.UserCreate;
import study.foo.user.service.UserService;

@RestController
@RequiredArgsConstructor

public class UserController {

    private final UserService userService;

    @GetMapping("/api/users/{id}")
    public ResponseEntity<MyProfileResponse> getMyProfile(@PathVariable("id") Long id) {
        return ResponseEntity.ok()
                .body(MyProfileResponse.from(userService.getById(id)));
    }

    @PostMapping("/api/signup")
    public ResponseEntity<MyProfileResponse> createNewUser(@RequestBody UserCreate userCreate) {
        User user = userService.create(userCreate);
        URI location = URI.create("/api/users/" + user.getId());
        return ResponseEntity.created(location)
                .body(MyProfileResponse.from(user));
    }

    @PutMapping("/api/users/{id}")
    public ResponseEntity<MyProfileResponse> updateMyProfile(@PathVariable("id") Long id,
            @RequestBody UserUpdate userUpdate) {
        User user = userService.update(id, userUpdate);
        return ResponseEntity.ok()
                .body(MyProfileResponse.from(user));
    }

    //TODO : 삭제기능 추가
}