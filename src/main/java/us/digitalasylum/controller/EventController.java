package us.digitalasylum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import us.digitalasylum.repository.EventRepository;
import us.digitalasylum.repository.entities.Event;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/event")
public class EventController {

    @Autowired
    EventRepository eventRepository;

    @RequestMapping({"/", ""})
    public ModelAndView index()
    {
        ModelAndView mav = new ModelAndView("event");
        Iterable<Event> eventList = eventRepository.findAll();

        mav.addObject("events", eventList);

        return mav;
    }

    @RequestMapping("/add")
    public ModelAndView add()
    {
        ModelAndView mav = new ModelAndView("event.add");
        return mav;
    }

    @RequestMapping("/addEvent")
    public String addEvent(@RequestParam("title") String title, @RequestParam("date") String date)
    {
        eventRepository.save(new Event(title, new Date(date)));

        //return "event";
        return "redirect:/event";
    }
}
