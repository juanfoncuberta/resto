package com.juanfoncuberta.resto.model

import java.io.Serializable
import java.util.ArrayList

data class Table(var number:Int):Serializable {
    val orders: MutableList<Order> = mutableListOf()
    //val dishes : MutableList<Dish> = mutableListOf<Dish>()
   //val dishes : ArrayList<Dishes> = ArrayList()
    override fun toString() = "Table ${number}"


}