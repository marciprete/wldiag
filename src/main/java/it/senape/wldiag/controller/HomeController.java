package it.senape.wldiag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by michele.arciprete on 14-Dec-17.
 */
@Controller
@RequestMapping(value="/api")
public class HomeController {

//    @RequestMapping(value = "/", method = RequestMethod.GET)
    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "index";
    }

}
