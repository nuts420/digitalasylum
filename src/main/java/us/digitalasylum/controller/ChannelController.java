package us.digitalasylum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import us.digitalasylum.repository.ChannelRepository;
import us.digitalasylum.repository.entities.Channel;

@Controller
@RequestMapping("/channel")
public class ChannelController {

    @Autowired
    private ChannelRepository channelRepository;

    @RequestMapping({"/", ""})
    public ModelAndView index()
    {
        ModelAndView mav = new ModelAndView("channel");
        Iterable<Channel> channels = channelRepository.findAll();

        mav.addObject("channels", channels);

        return mav;
    }
}
