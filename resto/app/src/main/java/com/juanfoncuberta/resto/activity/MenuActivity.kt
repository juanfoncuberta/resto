package com.juanfoncuberta.resto.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.juanfoncuberta.resto.*
import com.juanfoncuberta.resto.adapter.MenuAdapter
import com.juanfoncuberta.resto.model.Dish
import com.juanfoncuberta.resto.model.Dishes
import com.juanfoncuberta.resto.model.Tables

class MenuActivity: AppCompatActivity() {

    companion object {
        val DISH_NAME = "DISH_NAME"
        val TABLE_NAME = "TABLE_NAME"

        val TABLE_NUMBER = "TABLE_NUMBER"
            var tableNumber: Int? = null

        fun intent(context: Context, table:Int): Intent {
            val intent = Intent(context, MenuActivity::class.java)
           // intent.putExtra(MenuActivity.DISH_NAME, name

            tableNumber = table
           intent.putExtra(TABLE_NAME, tableNumber!!)
            return intent
        }

       val dishes:MutableList<Dish> = Dishes.dishes as MutableList<Dish>
        fun addButonClicked(name:Int){
            val currentDish = Dishes.getDish(name)

            Tables.addDish(tableNumber!!, currentDish)
        }
    }


    val dishList:RecyclerView by lazy {
        val dishList:RecyclerView = findViewById(R.id.menuList)
        dishList.layoutManager = LinearLayoutManager(this)
        dishList
    }
    val adapter: MenuAdapter by lazy{
        val adapter = MenuAdapter { item, position ->

            // showDish(item.name)
        }
        adapter
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        //val dishes:MutableList<Dish> = Dishes.dishes as MutableList<Dish>

        tableNumber = intent.getIntExtra(TABLE_NUMBER,0)

        adapter.setDishes(dishes)
        dishList.layoutManager = LinearLayoutManager(this)
        dishList.adapter = adapter

    }



    fun showDish(name:String){
           //  TODO

    }
}