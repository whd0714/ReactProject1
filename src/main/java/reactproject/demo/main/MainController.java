package reactproject.demo.main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactproject.demo.member.CurrentUser;
import reactproject.demo.member.Member;

@RestController
public class MainController {

   /* @GetMapping("/api/main")
    public Member main(@CurrentUser Member member) {
        if(member != null) {
            return member;
        }

        return null;
    }*/

}
