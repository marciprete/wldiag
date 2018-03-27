package it.senape.wldiag.controller;

import it.senape.wldiag.config.UrlMappings;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by michele.arciprete on 14-Dec-17.
 */
@Controller
@RequestMapping(value= UrlMappings.CTX_ROOT)
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "index";
    }

}
