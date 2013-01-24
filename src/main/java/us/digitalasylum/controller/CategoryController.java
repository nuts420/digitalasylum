package us.digitalasylum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
    public ModelAndView addForm()
    {
        ModelAndView mav = new ModelAndView("category.add", "command", new Category());

        return mav;
    }

    @RequestMapping(value= "/add", method= RequestMethod.POST)
    public String add(@RequestParam("name") String name)
    {
        Category category = new Category(name);
        category  = categoryRepository.save(category);


        return "redirect:/admin/category";
    }

    @RequestMapping("/edit/{categoryId}")
    public ModelAndView editForm(@PathVariable("categoryId") Long categoryId)
    {
        ModelAndView mav = new ModelAndView("category.edit");
        Category category = categoryRepository.findOne(categoryId);
        mav.addObject("category", category);

        return mav;
    }

    @RequestMapping(value = "/edit/{categoryId}", method=RequestMethod.POST)
    public String edit(@ModelAttribute("category") Category category, BindingResult result )
    {
        categoryRepository.save(category);
        return "redirect:/admin/category";
    }

    @RequestMapping(value = "/delete/{categoryId}")
    public String delete(@PathVariable("categoryId") Long categoryId )
    {
        categoryRepository.delete(categoryId);
        return "redirect:/admin/category";
    }

}
