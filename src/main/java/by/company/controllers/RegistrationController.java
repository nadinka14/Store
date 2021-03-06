package by.company.controllers;


import by.company.DTOs.UserDto;
import by.company.domains.Role;
import by.company.domains.User;
import by.company.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/register")
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ModelAndView getRegistrationPage(ModelAndView modelAndView) {
        modelAndView.setViewName("registration");
        modelAndView.addObject("user", new UserDto());
        return modelAndView;
    }

    @PostMapping
    public ModelAndView saveToDB(@ModelAttribute("user") UserDto userDTO, ModelAndView modelAndView) {
        modelAndView.setViewName("redirect:/");
        userService.save(new User(userDTO.getUsername(), userDTO.getPassword(), userDTO.getName(), userDTO.getSurname(), Role.USER));
        return modelAndView;
    }
}
