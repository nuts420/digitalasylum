package us.digitalasylum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import us.digitalasylum.repository.ChannelRepository;
import us.digitalasylum.repository.entities.Channel;

@Controller
@RequestMapping("/admin/channel")
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

    @RequestMapping(value = "/delete/{channelId}")
    public String delete(@PathVariable("channelId") Long channelId )
    {
        //channelRepository.delete(channelId);
        Channel channel = channelRepository.findOne(channelId);

        channelRepository.delete(channel);
        return "redirect:/admin/channel";
    }
}
