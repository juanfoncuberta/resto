package com.juanfoncuberta.resto.model

import com.juanfoncuberta.resto.R


object Dishes{
    //TODO: Add more dishes and change photos
      val dishes: List<Dish> = mutableListOf(
              Dish(0, "Paella", "Shellfish", R.drawable.paella, "You can ask for 'señorío paella'", 20f,null),
              Dish(1, "Salad", "Vegetables", R.drawable.salad, "Salad dressing to choice", 8f,null)
    )
    /*val countDownLatch
        get() = dishes.size
*/
    //TODO getDishById
    fun getDish(index:Int) = dishes[index]
   // fun toArray() = dishes.toTypedArray()


}