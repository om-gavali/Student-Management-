package Main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import Main.entity.users;
import Main.Repository.UserRepository;

@Controller
public class userController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    // Show Registration Page
    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new users());
        return "register";
    }

    // Save User
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") users user) {
        repository.save(user);
        return "redirect:/login";
    }
}
