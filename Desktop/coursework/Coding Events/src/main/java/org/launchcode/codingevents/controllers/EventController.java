package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

//    private static List<String> events = new ArrayList<>();
    private static HashMap<String, String> eventList = new HashMap<>();

    @GetMapping
    public String displayAllEvents(Model model) {
        eventList.put("Spooky Code", "Halloween themed coding.");
        eventList.put("Code and Paint", "Code and then paint later...? idk...");
        eventList.put("Around Town Code", "A coding event near you.");
        model.addAttribute("events", eventList);
        return "events/index";
    }

    @GetMapping("create")
    public String renderCreateEventForm() {
        return "events/create";
    }

    @PostMapping("create")
    public String createEvent(@RequestParam String eventName, String description) {
        eventList.put(eventName, description);
        return "redirect:";
    }
}
