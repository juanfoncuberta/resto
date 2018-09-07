package com.juanfoncuberta.resto.model

import java.io.Serializable

class Order(val dish: Dish,var variant: String?):Serializable {

    fun getResume():String = "${dish.name}: ${variant.toString()}"
}