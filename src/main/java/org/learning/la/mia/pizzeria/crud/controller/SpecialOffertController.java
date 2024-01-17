package org.learning.la.mia.pizzeria.crud.controller;

import jakarta.validation.Valid;
import org.learning.la.mia.pizzeria.crud.interfaccie.PizzeriaRepository;
import org.learning.la.mia.pizzeria.crud.interfaccie.SpecialOffertRepository;
import org.learning.la.mia.pizzeria.crud.model.Pizza;
import org.learning.la.mia.pizzeria.crud.model.SpecialOffert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
        return "redirect:/pizzas/show/" +pizzaOffer.getPizza().getId();
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        Optional<SpecialOffert> result = specialOffertRepository.findById(id);
        if (result.isPresent()){
            model.addAttribute("discount", result.get());
            return "offerte/edit";
        } else  {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Offerta with id " + id
                    + " not found");
        }
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable Integer id,
                         @Valid @ModelAttribute("offer") SpecialOffert formOffer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "offerte/edit";
        }
        SpecialOffert updatedoffer = specialOffertRepository.save(formOffer);
        return "redirect:/pizzas/show/" + updatedoffer.getPizza().getId();
    }





    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        Optional<SpecialOffert> result = specialOffertRepository.findById(id);
        if (result.isPresent()){
            SpecialOffert offerToDelete = result.get();
            specialOffertRepository.delete(offerToDelete);
            return "redirect:/pizzas/show/" + offerToDelete.getPizza().getId();

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Offer whit id" + id + "not found");
        }
    }
}
