package reactproject.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/api/hello")
    public String hello() {
        return "hello~ world!";
    }

    @PostMapping("/api/user/login")
    public String loginEx(@RequestBody LoginExDto loginExDto) {

        System.out.println(loginExDto);

        return "로그인완료";
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class LoginExDto {
        private String email;
        private String password;
    }
}


