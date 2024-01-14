package com.example.RateMovie.rm.Controller;

import com.example.RateMovie.rm.Entity.UserEntity;
import com.example.RateMovie.rm.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/register")
    public String RegisterPage(Model model){
        model.addAttribute("userForm",new UserEntity());
        return "RegisterPage";
    }

    @PostMapping("/reg")
    public String reg(@ModelAttribute UserEntity user){
        user.setRoles("USER");
        userService.saveUser(user);
        return "redirect:/";
    }


    @RequestMapping("/login")
    public String LoginPage(Model model){
        model.addAttribute("userForm", new UserEntity());
        return "LoginPage";
    }

    @PostMapping("/log")
    public String log(@ModelAttribute UserEntity user){
        if(userService.getLoginUser(user)){
            return "redirect:/";
        }
        return "redirect:/login";
    }
    @RequestMapping("/logout")
    public String logout(){
        userService.Logout();
        return "redirect:/";
    }

}
