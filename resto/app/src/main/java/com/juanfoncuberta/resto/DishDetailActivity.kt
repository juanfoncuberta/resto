package com.juanfoncuberta.resto

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_dish_detail.*

class DishDetailActivity: AppCompatActivity() {


    companion object {
        val DISH_ID = "DISH_ID"
        fun intent(context: Context, id:Int): Intent {
            val intent = Intent(context, DishDetailActivity::class.java)
                intent.putExtra(DISH_ID,id)
            return intent
        }

    }

    var dish: Dish? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dish_detail)
        val dishDish = intent.getIntExtra(DISH_ID,0)
        dish = Dishes.getDish(dishDish)

        dish?.let {
            with(dish){
                labelDishName.text = dish?.name
                labelDishVariants.text = dish?.detail
                labelDishImage.setImageResource(dish!!.image)
            }
        }


    }

}