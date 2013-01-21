package us.digitalasylum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import us.digitalasylum.repository.CategoryRepository;
import us.digitalasylum.repository.entities.Category;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping({"/", ""})
    public ModelAndView index()
    {
        ModelAndView mav = new ModelAndView("category");
        Iterable<Category> categories = categoryRepository.findAll();

        mav.addObject("categories", categories);

        return mav;
    }

    @RequestMapping("/add")
    public ModelAndView add()
    {
        ModelAndView mav = new ModelAndView("category.add", "command", new Category());

        return mav;
    }

    @RequestMapping("/addCategory")
    public String process(@RequestParam("name") String name)
    {
        Category category = new Category(name);
        category  = categoryRepository.save(category);


        return "redirect:/admin/category";
    }

    @RequestMapping(value = "/delete/{categoryId}")
    public String delete(@PathVariable("categoryId") Long categoryId )
    {
        categoryRepository.delete(categoryId);
        return "redirect:/admin/category";
    }

/*    @RequestMapping(value = "/edit/{categoryId}")
    public ModelAndView edit(@PathVariable("categoryId") Long categoryId )
    {
        Category category = categoryRepository.findOne(categoryId);


        //categoryRepository.delete(categoryId);
        //return "redirect:/category";
    }*/
}
