package pl.qubiak.simplefactorauthorization.Controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.qubiak.simplefactorauthorization.Model.AppUser;
import pl.qubiak.simplefactorauthorization.Repo.AppUserRepo;
import pl.qubiak.simplefactorauthorization.Service.UserService;

import java.security.Principal;
import java.util.Collection;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    // for REST value returned
//    @GetMapping("/hello")
//    @ResponseBody
//    public String hello() {
//        return "hello";
//    }


    @GetMapping("/hello")
    public String hello(Principal principal, Model model) {
        model.addAttribute("name", principal.getName());
        Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        //Object details = SecurityContextHolder.getContext().getAuthentication().getDetails();
        model.addAttribute("authorities", authorities);
        //model.addAttribute("details", details);
        return "hello";
    }

    @GetMapping("/sing-up")
    public String singup(Model model) {
        model.addAttribute("user", new AppUser());
        return "sing-up";
    }

    @PostMapping("/register")
    public String register(AppUser appUser) {
        userService.addUser(appUser);
        return "sing-up";
    }

}
