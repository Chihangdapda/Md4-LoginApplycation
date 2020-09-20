package com.codegym.controller;

import com.codegym.dao.UserDAO;
import com.codegym.model.Login;
import com.codegym.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import sun.rmi.runtime.Log;

@Controller
public class UserController {
    @GetMapping("/home")
        public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("home","login",new Login());
        return modelAndView;
    }
    @PostMapping("login")
    public ModelAndView login(@ModelAttribute("login")Login login){
        User user = UserDAO.checkLogin(login);
        if (user==null){
            ModelAndView modelAndView = new ModelAndView("error");
            return modelAndView;
        }else {
            ModelAndView modelAndView= new ModelAndView("user");
            modelAndView.addObject("user",user);
            return modelAndView;
        }
    }

}
