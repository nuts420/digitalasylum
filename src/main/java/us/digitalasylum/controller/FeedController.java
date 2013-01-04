package us.digitalasylum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import us.digitalasylum.repository.FeedRepository;
import us.digitalasylum.repository.entities.Feed;
import us.digitalasylum.repository.enums.FeedType;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("/feed")
public class FeedController {

    @Autowired
    private FeedRepository feedRepository;

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

        Map<String,String> feedTypeList = new LinkedHashMap<String,String>();
        feedTypeList.put(FeedType.ATOM.toString(), "Atom");
        feedTypeList.put(FeedType.RSS1.toString(), "RSS");
        feedTypeList.put(FeedType.RSS2.toString(), "RSS2");

        mav.addObject("feedTypeList", feedTypeList);

        return mav;
    }

    @RequestMapping("/addFeed")
    public String process(@RequestParam("name") String name, @RequestParam("url") String url, @RequestParam("feedType") FeedType feedType)
    {
        feedRepository.save(new Feed(name, url, feedType));

        return "redirect:/feed";
    }
}
