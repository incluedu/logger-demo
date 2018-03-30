package net.lustenauer.sb.demo.loggerdemo.view;

import net.lustenauer.sb.demo.loggerdemo.host.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @Autowired HostService hostService;

    @GetMapping("/")
    public String indexPage(Model model) {
        model.addAttribute("hosts",hostService.getAllHosts());
        return "index";
    }
}
