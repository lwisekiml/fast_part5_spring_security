package me.benny.practice.spring.security.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 회원가입 Controller
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/signup")
public class SignUpController {

    private final UserService userService;

    /**
     * @return 회원가입 페이지 리소스
     */
    @GetMapping
    public String signup() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return "signup"; // break point를 걸고  회원가입 화면에 접속하여 securityContext안에 principal, authorities 확인
    }

    @PostMapping
    public String signup(
            @ModelAttribute UserRegisterDto userDto
    ) {
        userService.signup(userDto.getUsername(), userDto.getPassword());
        // 회원가입 후 로그인 페이지로 이동
        return "redirect:login";
    }
}
