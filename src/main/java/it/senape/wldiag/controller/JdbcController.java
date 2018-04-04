package it.senape.wldiag.controller;

import it.senape.wldiag.config.UrlMappings;
import it.senape.wldiag.message.JdbcResourceMessage;
import it.senape.wldiag.message.JdbcResourcePoolMessage;
import it.senape.wldiag.service.jpa.JdbcResourcePoolService;
import it.senape.wldiag.service.jpa.JdbcResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by michele.arciprete on 25-Jan-18.
 */
@Controller
@RequestMapping(value= UrlMappings.API_JDBC)
public class JdbcController {

    private static final String ENABLED_PARAM = "enabled";
    private JdbcResourceService jdbcResourceService;
    private JdbcResourcePoolService jdbcResourcePoolService;

    @Autowired
    public JdbcController(JdbcResourceService jdbcResourceService, JdbcResourcePoolService jdbcResourcePoolService) {
        this.jdbcResourceService = jdbcResourceService;
        this.jdbcResourcePoolService = jdbcResourcePoolService;
    }

    @ResponseBody
    @RequestMapping(value = UrlMappings.LIST, method = RequestMethod.GET)
    public Page<JdbcResourcePoolMessage> list(Pageable pageRequest) {
        return jdbcResourcePoolService.findAllWithCounters(pageRequest);
    }

    @ResponseBody
    @RequestMapping(value = "details/{resourcePoolId}", method = RequestMethod.GET)
    public Page<JdbcResourceMessage> getResourceList(@PathVariable Long resourcePoolId,
                                                     @RequestParam Map<String,String> allRequestParams,
                                                     Pageable pageRequest) {
        if(allRequestParams.get(ENABLED_PARAM) != null &&
                !"all".equalsIgnoreCase(allRequestParams.get(ENABLED_PARAM))) {
            return jdbcResourceService.findAllResourcesFiltered(resourcePoolId, pageRequest);
        }
        return jdbcResourceService.findAllByResourcePoolId(resourcePoolId, pageRequest);
    }

    @ResponseBody
    @RequestMapping(value = UrlMappings.SHOW + "/{id}", method = RequestMethod.GET)
    public JdbcResourceMessage get(@PathVariable("id") Long id) {
        return jdbcResourceService.get(id);
    }

}
