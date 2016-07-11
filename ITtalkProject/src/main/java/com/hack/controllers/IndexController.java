package com.hack.controllers;

import com.hack.dto.FormData;
import com.hack.entities.User;
import com.hack.repo.PictureRepository;
import com.hack.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sun.text.resources.FormatData;

@Controller
public class IndexController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PictureRepository pictureRepository;

    @RequestMapping("/")
    public String helloPage(Model model) {
        User adminUser = userRepository.findOne(1L);
        model.addAttribute("username", adminUser.getName());
        model.addAttribute("photos", pictureRepository.findByUserId(adminUser.getId())); //TODO fixme later
        return "index";
    }

    @RequestMapping("/info")
    public String infoPage(Model model) {
        String message = "For students...";
        model.addAttribute("msg", message);
        return "info";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String postSomeData(FormData formData, Model model){
        String response = formData.getName() + ", " + formData.getPassword();
        model.addAttribute("msg", response);
        return "info";
    }


}
