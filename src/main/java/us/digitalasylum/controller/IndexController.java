package us.digitalasylum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import us.digitalasylum.repository.CategoryRepository;
import us.digitalasylum.repository.entities.Category;


@Controller
@RequestMapping("/")
public class IndexController {
    private static final Logger logger = Logger.getLogger(IndexController.class);

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping("")
    public ModelAndView index()
    {
        logger.debug("entering index.");

        ModelAndView mav = new ModelAndView("index");
        Iterable<Category> categories = categoryRepository.findAll();

        mav.addObject("categories", categories);

        return mav;
    }
}
