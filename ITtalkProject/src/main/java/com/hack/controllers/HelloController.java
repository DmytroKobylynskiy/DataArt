package com.hack.controllers;

import com.hack.dto.FormData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.text.resources.FormatData;

/**
 * Created by kobyl on 04.07.2016.
 */

@Controller
public class HelloController {
    @RequestMapping("/")
    public String helloPage(){
        return  "hello";
    }

    @RequestMapping("/info")
    public String infoPage(Model model){
        String message = "some message";
        model.addAttribute("msg", message);
        return "info";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST )
    public String postSomeData(FormData formData, Model model){
        String response = formData.getName() + ", " + formData.getPassword();
        model.addAttribute("msg",response);
        return "info";
    }

}
