package sec.project.controller;

/**
 *
 * @author exeiya
 */

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerMapping;
import sec.project.domain.Signup;
import sec.project.domain.Topic;
import sec.project.repository.SignupRepository;
import sec.project.repository.TopicRepository;

@Controller
public class EventController {
    
    @Autowired
    private SignupRepository signupRepository;
    
    @Autowired
    private TopicRepository topicRepository;

    @RequestMapping(value = "/event", method = RequestMethod.GET)
    public String loadEvent(Model model) {
        List<Signup> participants = signupRepository.findAll();
        List<Topic> topics = topicRepository.findAll();
        
        model.addAttribute("participants", participants);
        model.addAttribute("topics", topics);
        
        return "event";
    }
    
    @RequestMapping(value = "/event", method = RequestMethod.POST)
    public String submitForm(@RequestParam String topic) {
        topicRepository.save(new Topic(topic));
        return "redirect:/event";
    }
    
    @RequestMapping(value = "/redirect/**", method = RequestMethod.GET)
    public String redirect(HttpServletRequest request) {
        String url = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        url = url.replaceFirst("/redirect/", "");
        
        return "redirect:" + "http://"+url;
    }
    
}
