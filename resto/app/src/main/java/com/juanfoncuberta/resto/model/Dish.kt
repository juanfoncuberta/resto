package com.juanfoncuberta.resto.model

import java.io.Serializable


//TODO Que allergens sea un array
data class Dish(var id:Int ,var name:String, var allergens: String, var image: Int,var detail:String,var price: Float): Serializable {

     fun priceToString() = "${price} €"
}