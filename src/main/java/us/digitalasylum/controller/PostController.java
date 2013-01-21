package us.digitalasylum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import us.digitalasylum.repository.PostRepository;
import us.digitalasylum.repository.entities.Post;

import java.util.Date;

@Controller
@RequestMapping("/admin/post")
public class PostController {

    @Autowired
    private PostRepository postRepository;


    @RequestMapping({"/", ""})
    public ModelAndView index()
    {
        ModelAndView mav = new ModelAndView("post");
        Iterable<Post> postList = postRepository.findAll();

        mav.addObject("posts", postList);

        return mav;
    }

    @RequestMapping("/add")
    public ModelAndView add()
    {
        ModelAndView mav = new ModelAndView("post.add", "command", new Post());

        return mav;
    }

    @RequestMapping("/addPost")
    public String addEvent(@RequestParam("title") String title, @RequestParam("body") String body)
    {
        postRepository.save(new Post(title, body, new Date()));

        return "redirect:/admin/post";
    }
}
