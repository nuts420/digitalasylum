package us.digitalasylum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import us.digitalasylum.repository.CategoryRepository;
import us.digitalasylum.repository.FeedRepository;
import us.digitalasylum.repository.entities.Category;
import us.digitalasylum.repository.entities.Feed;
import us.digitalasylum.service.FeedService;

@Controller
@RequestMapping("/admin/feed")
public class FeedController {

    @Autowired
    private FeedRepository feedRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private FeedService feedService;

    @RequestMapping({"/", ""})
    public ModelAndView index()
    {
        ModelAndView mav = new ModelAndView("feed");
        Iterable<Feed> feedList = feedRepository.findAll();

        mav.addObject("feeds", feedList);

        return mav;
    }

    @RequestMapping("/add")
    public ModelAndView addForm()
    {
        ModelAndView mav = new ModelAndView("feed.add", "command", new Feed());
        mav.addObject("categories", categoryRepository.findAll());

        return mav;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestParam("name") String name, @RequestParam("url") String url, @RequestParam("category") Long categoryId)
    {
        Category category = categoryRepository.findOne(categoryId);
        Feed feed = new Feed(name, url, category);
        feed  = feedRepository.save(feed);

        feedService.fetchItems(feed.getId());

        return "redirect:/admin/feed";
    }

    @RequestMapping(value = "/update/{feedId}")
    public String update(@PathVariable("feedId") Long feedId )
    {
        feedService.fetchItems(feedId);

        return "redirect:/admin/feed";

    }

    @RequestMapping("/edit/{feedId}")
    public ModelAndView editForm(@PathVariable("feedId") Long feedId)
    {
        ModelAndView mav = new ModelAndView("feed.edit");
        Feed feed = feedRepository.findOne(feedId);
        mav.addObject("feed", feed);
        //mav.addObject("categoryId", feed.getCategory().getId());
        mav.addObject("categories", categoryRepository.findAll());
        //mav.addAttribute("visit", visit);

        return mav;
    }

    @RequestMapping(value = "/editSubmit", method=RequestMethod.POST)
    public String edit(@ModelAttribute("feed") Feed feed, BindingResult result )
    {
        feedRepository.save(feed);
        feedService.fetchItems(feed.getId());
        return "redirect:/admin/feed";
    }

    @RequestMapping(value = "/delete/{feedId}")
    public String delete(@PathVariable("feedId") Long feedId )
    {
        feedService.delete(feedId);
        return "redirect:/admin/feed";
    }

}
