package us.digitalasylum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.apache.log4j.Logger;


@Controller
@RequestMapping("/")
public class IndexController {
    private static final Logger logger = Logger.getLogger(IndexController.class);

    @RequestMapping("")
    public String index()
    {
        logger.debug("entering index.");
        return "index";
    }
}
