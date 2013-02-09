package us.digitalasylum.controller;


import java.security.Principal;

import freemarker.template.TemplateModelAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import us.digitalasylum.repository.CategoryRepository;
import us.digitalasylum.repository.entities.Category;

@Controller
public class LoginController {

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(value="/welcome", method = RequestMethod.GET)
    public ModelAndView printWelcome(ModelMap model, Principal principal ) {

        ModelAndView mav = new ModelAndView("hello");
        String name = principal.getName();

        mav.addObject("username", name);
        mav.addObject("message", "this is a test");

        return mav;

    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public ModelAndView login(ModelMap model) {
        ModelAndView mav = new ModelAndView("openid.login");

        Sort sort = new Sort(Sort.Direction.ASC, "ordinal");
        Iterable<Category> categories = categoryRepository.findAll(sort);

        mav.addObject("categories", categories);

        return mav;

    }

    @RequestMapping(value="/loginfailed", method = RequestMethod.GET)
    public String loginerror(ModelMap model) {

        model.addAttribute("error", "true");
        return "openid.login";

    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {

        return "openid.login";

    }

}