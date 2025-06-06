package com.github.atomfrede.spring_io_25_samples.modals;

import io.github.wimdeblauwe.htmx.spring.boot.mvc.HtmxRedirectView;
import io.github.wimdeblauwe.htmx.spring.boot.mvc.HtmxResponse;
import io.github.wimdeblauwe.htmx.spring.boot.mvc.HxRequest;
import net.datafaker.Faker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("modal-dialogs")
public class ModalDialogController {

    private final Faker faker = new Faker();

    @GetMapping
    public String index(Model model){
        return "modal-dialogs/index";
    }

    @GetMapping
    @HxRequest
    public String modalContent(Model model){
        model.addAttribute("fact", faker.chuckNorris().fact());
        return "modal-dialogs/modal";
    }

    @GetMapping("/client-side-event")
    @HxRequest
    public String clientSideEvent(){
        return "modal-dialogs/client-side-event";
    }

    @GetMapping("/confirm")
    @HxRequest
    public HtmxRedirectView confirmModal(Model model, HtmxResponse htmxResponse, RedirectAttributes redirectAttributes){

        redirectAttributes.addFlashAttribute("modalConfirmed", "Modal confirmed! \uD83C\uDF89");
        htmxResponse.addTriggerAfterSwap("modal-confirmed");
        return new HtmxRedirectView("/modal-dialogs");
    }

}
