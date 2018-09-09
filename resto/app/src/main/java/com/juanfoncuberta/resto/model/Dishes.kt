package com.juanfoncuberta.resto.model

import com.juanfoncuberta.resto.R


object Dishes{
      val dishes: List<Dish> = mutableListOf(
        Dish(0, "Paella", listOf(Allergens.GLUTEN,Allergens.SEAFOOD), R.drawable.paella, "You can ask for 'señorío paella'", 12f),
        Dish(1, "Salad",  listOf(Allergens.DAIRY), R.drawable.salad, "Salad dressing to choice", 8f),
        Dish(3, "Risotto", listOf(Allergens.DAIRY), R.drawable.risotto, "Best risotto funghi porcini in town", 12f),
        Dish(4, "Fabada", listOf(), R.drawable.fabada, "Tipical fabada asturian", 10f),
        Dish(5, "Lamb", listOf(Allergens.GLUTEN), R.drawable.cordero, "Baked lamb with potatoes and onion", 18f),
        Dish(6, "BBQ Ribs", listOf(), R.drawable.costillas, "Ribs with the authentic Kentucky barbecue sauce", 13f),
        Dish(7, "Squid", listOf(Allergens.SEAFOOD), R.drawable.calamar, "squid with garlic and parsley", 8f),
        Dish(8, "Tuna takaki", listOf(Allergens.SEAFOOD,Allergens.DAIRY), R.drawable.atun, "the specialty of the chef", 17.5f)
    )

    fun getDish(index:Int) = dishes.filter { it.id == index }.first()



}