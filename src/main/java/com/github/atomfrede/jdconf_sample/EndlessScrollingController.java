package com.github.atomfrede.jdconf_sample;

import com.github.atomfrede.jdconf_sample.person.Person;
import com.github.atomfrede.jdconf_sample.person.PersonService;
import io.github.wimdeblauwe.htmx.spring.boot.mvc.HxRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("endless-scrolling")
public class EndlessScrollingController {

    private final PersonService personService;

    public EndlessScrollingController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public String index(Model model, Pageable pageable) {

        Slice<Person> slice = personService.findAll(pageable);
        model.addAttribute("persons", slice);
        return "endless-scrolling/index";
    }

    @GetMapping
    @HxRequest
    public String nextPage(Model model, Pageable pageable) {
        Slice<Person> slice = personService.findAll(pageable);
        model.addAttribute("persons", slice);

        return "endless-scrolling/table";
    }
}
