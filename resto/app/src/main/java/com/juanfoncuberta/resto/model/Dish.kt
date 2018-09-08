package com.juanfoncuberta.resto.model

import com.juanfoncuberta.resto.R
import kotlinx.android.synthetic.main.item_list_dish.view.*
import java.io.Serializable


enum class Allergens(val allergenId:Int){
     PEANUT(R.id.allergen_peaunut_icon),
     SEAFOOD(R.id.allergen_seafood_icon),
     DAIRY(R.id.allergen_dairy_icon),
     GLUTEN(R.id.allergen_glutten_icon)
}


data class Dish(var id:Int ,
                var name:String,
                var allergens: List<Allergens> = listOf(),
                var image: Int,
                var detail:String,
                var price: Float): Serializable {
     fun priceToString() = "${price} €"
}