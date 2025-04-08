package com.github.atomfrede.jdconf_sample;

import io.github.wimdeblauwe.htmx.spring.boot.mvc.HxRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {


    @GetMapping("")
    public String index(Model model){
        model.addAttribute("formModel", new FormModel());
        model.addAttribute("validationResult", null);
        return "index";
    }

    @HxRequest
    @PostMapping("")
    public String htmxPost(@Valid FormModel formModel, BindingResult bindingResult, Model model){
        model.addAttribute("formModel", formModel);
        model.addAttribute("validationResult", bindingResult);
        return "form";
    }

    @PostMapping("")
    public String postIndex(@Valid FormModel formModel, BindingResult bindingResult, Model model){
        model.addAttribute("formModel", formModel);
        model.addAttribute("validationResult", bindingResult);
        if (bindingResult.hasErrors()) {
            return "index";
        }

        return "redirect:/";
    }

}
