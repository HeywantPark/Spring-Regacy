package org.example.controller.user;

import lombok.RequiredArgsConstructor;
import org.example.domain.User;
import org.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final String context = "/user";

    @GetMapping("/login")
    public String loginPage() {
        return context + "/login";
    }
    //post : user/login
    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model, HttpSession session
    ) {
        User user = userService.findByUsername(username);

        if (user == null) {
            model.addAttribute("errMSG", "해당 id의 사용자가 없습니다.");
            return context + "/login-failed";
        }
        if (!userService.isPasswordValid(user,password)) {
            model.addAttribute("errMSG","비민번호가 틀립니다.");
            return context + "/login-failed";
        }
        session.setAttribute("loginUser", user);
        model.addAttribute("username", username);
        return context + "/login-success";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return context + "/logout";
    }
}
