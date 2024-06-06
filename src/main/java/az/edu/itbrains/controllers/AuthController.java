package az.edu.itbrains.controllers;


import az.edu.itbrains.dtos.UserDtos.UserRegisterDto;
import az.edu.itbrains.repositories.UserRepository;
import az.edu.itbrains.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;


    @GetMapping("/login")
    public String login()
    {
        return "/auth/login";
    }

    @GetMapping("/register")
    public String register()
    {
        return "/auth/register";
    }


    @PostMapping("/register")
    public String register(UserRegisterDto registerDto)
    {
        userService.registerUser(registerDto);
        return "redirect:/login";
    }
}
