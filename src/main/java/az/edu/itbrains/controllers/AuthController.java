package az.edu.itbrains.controllers;


import az.edu.itbrains.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/register")
    public String register()
    {
        return "/admin/register";
    }

}
