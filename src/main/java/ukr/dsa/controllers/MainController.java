package ukr.dsa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String start(Model model){
        return "main";
    }

    @RequestMapping(value = "/train", method = RequestMethod.GET)
    public String train(Model model){
        return "train";
    }

}