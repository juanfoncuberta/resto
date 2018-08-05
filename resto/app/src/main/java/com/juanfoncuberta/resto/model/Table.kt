package com.juanfoncuberta.resto.model

import java.io.Serializable
import java.util.ArrayList

data class Table(var number:Int):Serializable {

    val dishes : MutableList<Dish> = ArrayList()
    override fun toString() = "Table ${number}"


}