package org.learning.la.mia.pizzeria.crud.interfaccie;

import org.learning.la.mia.pizzeria.crud.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientsRepository extends JpaRepository <Ingredient, Integer>{
}
