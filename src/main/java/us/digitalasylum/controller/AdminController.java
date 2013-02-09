package us.digitalasylum.controller;


import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.openid.OpenIDAttribute;
import org.springframework.security.openid.OpenIDAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {
    private static final Logger logger = Logger.getLogger(IndexController.class);

    @RequestMapping({"/", ""})
    public ModelAndView index()
    {
        ModelAndView mav = new ModelAndView("admin.index");
        logger.debug("entering admin index.");

        OpenIDAuthenticationToken token = (OpenIDAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        List<OpenIDAttribute> attributes = token.getAttributes();

        mav.addObject("attributes", attributes);

        return mav;
        //return "admin.index";
    }
}

