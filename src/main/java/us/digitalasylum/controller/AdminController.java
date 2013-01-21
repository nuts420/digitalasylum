package us.digitalasylum.controller;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/admin")
public class AdminController {
    private static final Logger logger = Logger.getLogger(IndexController.class);

    @RequestMapping({"/", ""})
    public String index()
    {
        logger.debug("entering admin index.");
        return "admin.index";
    }
}

