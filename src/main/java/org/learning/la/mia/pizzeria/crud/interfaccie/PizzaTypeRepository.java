package org.learning.la.mia.pizzeria.crud.interfaccie;

import org.learning.la.mia.pizzeria.crud.model.PizzaType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaTypeRepository extends JpaRepository<PizzaType, Integer> {
    int a= 0;
}
