package us.digitalasylum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import us.digitalasylum.repository.CategoryRepository;
import us.digitalasylum.repository.FeedRepository;
import us.digitalasylum.repository.entities.Category;
import us.digitalasylum.repository.entities.Feed;
import us.digitalasylum.repository.enums.FeedType;
import us.digitalasylum.service.FeedService;

import java.util.LinkedHashMap;
import java.util.Map;

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
    public ModelAndView add()
    {
        ModelAndView mav = new ModelAndView("feed.add", "command", new Feed());
        mav.addObject("categories", categoryRepository.findAll());

        return mav;
    }

    @RequestMapping("/addFeed")
    public String process(@RequestParam("name") String name, @RequestParam("url") String url, @RequestParam("category") Long categoryId)
    {
        Category category = categoryRepository.findOne(categoryId);
        Feed feed = new Feed(name, url, category);
        feed  = feedRepository.save(feed);

        feedService.updateFeed(feed.getId());

        return "redirect:/admin/feed";
    }

    @RequestMapping(value = "/update/{feedId}")
    public String update(@PathVariable("feedId") Long feedId )
    {
        feedService.updateFeed(feedId);

        return "redirect:/admin/feed";

    }

    @RequestMapping(value = "/delete/{feedId}")
    public String delete(@PathVariable("feedId") Long feedId )
    {
        feedService.delete(feedId);
        return "redirect:/admin/feed";
    }

}
