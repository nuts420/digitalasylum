package us.digitalasylum.controller;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import sun.print.PageableDoc;
import us.digitalasylum.repository.CategoryRepository;
import us.digitalasylum.repository.ItemRepository;
import us.digitalasylum.repository.entities.Category;
import us.digitalasylum.repository.entities.Item;
import us.digitalasylum.service.FeedService;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


@Controller
@RequestMapping("/")
public class IndexController {
    private static final Logger logger = Logger.getLogger(IndexController.class);

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private FeedService feedService;

    @RequestMapping("")
    public ModelAndView index()
    {
        logger.debug("entering index.");

        ModelAndView mav = new ModelAndView("redirect:/category/1");

        return mav;
    }

    @RequestMapping("category/{categoryId}")
    public ModelAndView index(@PathVariable("categoryId") Long categoryId)
    {
        ModelAndView mav = new ModelAndView("public.item");

        Sort sort = new Sort(Sort.Direction.ASC, "ordinal");
        Iterable<Category> categories = categoryRepository.findAll(sort);

        mav.addObject("categories", categories);

        //Sort itemSort = new Sort(Sort.Direction.DESC, "pubDate");
        //Iterable<Item> itemList = itemRepository.findByChannel_Feed_Category_Id(categoryId, itemSort);
        //Iterable<Item> itemList = itemRepository.findByChannel_Feed_Category_IdOrderByPubDateDesc(categoryId);

        Pageable page = new PageRequest(0, 40, new Sort(Sort.Direction.DESC, "createDate"));
        Iterable<Item> itemList = itemRepository.findByChannel_Feed_Category_Id(categoryId, page);


        mav.addObject("items", itemList);

        return mav;
    }

    @RequestMapping("category/{categoryId}/date/{date}")
    public ModelAndView index(@PathVariable("categoryId") Long categoryId, @PathVariable("date") String date)
    {
        ModelAndView mav = new ModelAndView("public.item");

        Sort sort = new Sort(Sort.Direction.ASC, "ordinal");
        Iterable<Category> categories = categoryRepository.findAll(sort);
        mav.addObject("categories", categories);
        mav.addObject("date", date);

        DateTimeFormatter formatter = DateTimeFormat.forPattern("MM-dd-yyyy");
        DateTime dt = formatter.parseDateTime(date);

        DateTime startDate = new DateTime(dt).toDateMidnight().toDateTime();
        DateTime endDate = startDate.plusDays(1);

        Sort itemSort = new Sort(Sort.Direction.DESC, "pubDate");
        Iterable<Item> itemList = itemRepository.findByChannel_Feed_Category_IdAndCreateDateBetween(categoryId, startDate.toDate(), endDate.toDate(), itemSort);
        mav.addObject("items", itemList);

        return mav;
    }

    @RequestMapping("feed/fetchAll")
    public String fetchFeeds(){
        feedService.fetchAllItems();
        return "redirect:/category/1";
    }
}
