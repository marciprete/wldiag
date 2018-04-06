package it.senape.wldiag.controller;

import it.senape.wldiag.config.UrlMappings;
import it.senape.wldiag.message.JtaMessage;
import it.senape.wldiag.service.jpa.JtaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by michele.arciprete on 19-Dec-17.
 */
@Controller
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = UrlMappings.API_JTA)
public class JtaController {

    private final static Logger logger = LoggerFactory.getLogger(JtaController.class);

    private JtaService jtaService;

    @Autowired
    public JtaController(JtaService jtaService) {
        this.jtaService = jtaService;
    }

    @ResponseBody
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public Page<JtaMessage> list(Pageable pageRequest) {
        logger.info("Request JTA List");
        return jtaService.findAll(pageRequest);
    }

}
