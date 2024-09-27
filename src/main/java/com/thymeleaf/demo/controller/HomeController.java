package com.thymeleaf.demo.controller;

import com.thymeleaf.demo.dto.ContactForm;
import com.thymeleaf.demo.dto.Human;
import jakarta.websocket.server.PathParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping("")
    public String home() {
        return "HomePage";
    }

    @GetMapping("/contact")
    public String contact(ContactForm form, Model model) {

        Long a = null;
        a++;

        form = new ContactForm();
        form.init();

        model.addAttribute("form", form);
        return "ContactPage";
    }

    @PostMapping("/contact/submit")
    public String contactSubmit(ContactForm form, Model model) {
        form.init();
        model.addAttribute("message", "Male".equals(form.getSex()) ? "1" : "0");
        model.addAttribute("form", form);
        return "ContactPage";
    }

    @GetMapping("/bill/{id}")
    public String bill(Model model, @PathParam("id") Integer id) {

        model.addAttribute("time", "27-7-1997");
        String[] names = new String[]{"John", "Alex", "Kwan"};
        String[] names2 = new String[]{"A", "B", "C"};
        model.addAttribute("time", "27-7-1997");
        model.addAttribute("names", names);
        model.addAttribute("names2", names2);


        List<Human> people = new ArrayList<>();
        people.add(new Human("Alex", 15, "113", 50000.100));
        people.add(new Human("Roma", 12, "113", 10000.100));
        people.add(new Human("MeoMeo", 5, "113", 90000.100));
        people.add(new Human("Adam", 9, "113", 10000.100));
        people.add(new Human("Alex sander", 44, "113", 10000.100));
        people.add(new Human("CR7", 25, "113", 10000.100));

        model.addAttribute("people", people);

        return "BillPage";
    }
}
