package org.learning.la.mia.pizzeria.crud.controller;

import org.learning.la.mia.pizzeria.crud.interfaccie.PizzeriaRepository;
import org.learning.la.mia.pizzeria.crud.interfaccie.SpecialOffertRepository;
import org.learning.la.mia.pizzeria.crud.model.Pizza;
import org.learning.la.mia.pizzeria.crud.model.SpecialOffert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Controller
@RequestMapping("/offerte")
public class SpecialOffertController {

    @Autowired
    private PizzeriaRepository pizzeriaRepository;
    @Autowired
    private SpecialOffertRepository specialOffertRepository;


    @GetMapping("/create")
    public String create(@RequestParam Integer pizzaId, Model model){
        Optional<Pizza> result = pizzeriaRepository.findById(pizzaId);
        if (result.isPresent()) {
            Pizza pizzaOff = result.get();
            model.addAttribute("pizzaOff", pizzaOff);
            SpecialOffert newOffer = new SpecialOffert();
            newOffer.setPizza(pizzaOff);
            model.addAttribute("offerta", newOffer);
            return "offerte/create";
        }  else {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Pizza with id " + pizzaId + " not found");
    }

    }

    @PostMapping("/create")
    public String store(SpecialOffert formOffer) {
        SpecialOffert pizzaOffer = specialOffertRepository.save(formOffer);
        return "redirect:/pizzas/show/" + pizzaOffer.getPizza().getId();
    }
}
