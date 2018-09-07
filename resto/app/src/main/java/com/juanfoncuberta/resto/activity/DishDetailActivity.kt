package com.juanfoncuberta.resto.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.juanfoncuberta.resto.model.Dish
import com.juanfoncuberta.resto.model.Dishes
import com.juanfoncuberta.resto.R
import kotlinx.android.synthetic.main.activity_dish_detail.*

class DishDetailActivity: AppCompatActivity() {


    companion object {
        val DISH_ID = "DISH_ID"
        val DISH_VARIANTS = "DISH_VARIANTS"
        fun intent(context: Context, id:Int): Intent {
            val intent = Intent(context, DishDetailActivity::class.java)
                intent.putExtra(DISH_ID,id)
            return intent
        }

    }
    //TODO: Init dishId by lazy
    var dish: Dish? = null
    set(value){
        field = value
        if(value != null){
            label_dish_name.text = dish?.name
            label_dish_detail.text = dish?.detail
            label_dish_image.setImageResource(dish!!.image)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dish_detail)
        val dishId = intent.getIntExtra(DISH_ID,0)
        dish = Dishes.getDish(dishId)

        button_dish_ok.setOnClickListener {
            val returnIntent = Intent()
            returnIntent.putExtra(DISH_ID,dishId)
            val textDishVariants = text_dish_variants.text.toString()
            returnIntent.putExtra(DISH_VARIANTS,textDishVariants)
            setResult(Activity.RESULT_OK,returnIntent)
            finish()

        }

        button_dish_cancel.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }

    }

}