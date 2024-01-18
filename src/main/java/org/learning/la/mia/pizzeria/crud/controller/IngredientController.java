package org.learning.la.mia.pizzeria.crud.controller;

import jakarta.validation.Valid;
import org.learning.la.mia.pizzeria.crud.interfaccie.IngredientsRepository;
import org.learning.la.mia.pizzeria.crud.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Controller
@RequestMapping("/ingredient")
public class IngredientController {
    @Autowired
    public IngredientsRepository ingredientsRepository;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("ingredientList", ingredientsRepository.findAll());
        return "ingredienti/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("formIngredient", new Ingredient());
        return "ingredienti/form";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("formIngredient") Ingredient formIngredient, BindingResult bindingresult) {
        if (bindingresult.hasErrors()) {
            return "ingredienti/form";
        }
        ingredientsRepository.save(formIngredient);
        return "redirect:/ingredient";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Optional<Ingredient> result = ingredientsRepository.findById(id);
        if (result.isPresent()) {
            model.addAttribute("formIngredient", result.get());
            return "ingredienti/form";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ingredient with id " + id + " not found");

        }
    }
}