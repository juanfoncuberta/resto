package com.juanfoncuberta.resto.model

import com.juanfoncuberta.resto.R


object Dishes{
    //TODO: Add more dishes and change photos
      val dishes: List<Dish> = mutableListOf(
              Dish(0, "Paella", listOf(Allergens.GLUTEN,Allergens.SEAFOOD), R.drawable.paella, "You can ask for 'señorío paella'", 20f),
              Dish(1, "Salad",  listOf(Allergens.DAIRY), R.drawable.salad, "Salad dressing to choice", 8f)
             /* Dish(2, "Risotto", "Vegetables", R.drawable.risotto, "Salad dressing to choice", 8f),
              Dish(1, "Salad", "Vegetables", R.drawable.salad, "Salad dressing to choice", 8f),
              Dish(1, "Salad", "Vegetables", R.drawable.salad, "Salad dressing to choice", 8f),
              Dish(1, "Salad", "Vegetables", R.drawable.salad, "Salad dressing to choice", 8f),
              Dish(1, "Salad", "Vegetables", R.drawable.salad, "Salad dressing to choice", 8f),
              Dish(1, "Salad", "Vegetables", R.drawable.salad, "Salad dressing to choice", 8f),*/
    )

    fun getDish(index:Int) = dishes.filter { it.id == index }.first()



}