package mrvaltiel.project;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class demoController
{
    @RequestMapping(value = "/demo")
    public String demo()
    {
        return "[DEMO] It's working!";
    }
}
