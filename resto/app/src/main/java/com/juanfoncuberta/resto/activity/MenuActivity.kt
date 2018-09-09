package com.juanfoncuberta.resto.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.juanfoncuberta.resto.*
import com.juanfoncuberta.resto.adapter.MenuAdapter
import com.juanfoncuberta.resto.model.Dish
import com.juanfoncuberta.resto.model.Dishes
import com.juanfoncuberta.resto.model.Tables

class MenuActivity: AppCompatActivity() {

    companion object {
        val TABLE_NAME = "TABLE_NAME"
        val TABLE_NUMBER = "TABLE_NUMBER"
        var tableNumber: Int? = null

        fun intent(context: Context, table:Int): Intent {
            val intent = Intent(context, MenuActivity::class.java)
            tableNumber = table
           intent.putExtra(TABLE_NAME, tableNumber!!)
            return intent
        }
       val dishes:MutableList<Dish> = Dishes.dishes as MutableList<Dish>

    }

    val REQUEST_FOR_DISH = 1
    val dishList:RecyclerView by lazy {
        val dishList:RecyclerView = findViewById(R.id.menuList)
        dishList.layoutManager = LinearLayoutManager(this)
        dishList
    }
    val adapter: MenuAdapter by lazy{
        val adapter = MenuAdapter { item, position ->

            showDish(item.id)
        }
        adapter
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        tableNumber = intent.getIntExtra(TABLE_NUMBER,0)
        supportActionBar?.title = getString(R.string.menu_title)
        adapter.setDishes(dishes)
        dishList.layoutManager = LinearLayoutManager(this)
        dishList.adapter = adapter

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            REQUEST_FOR_DISH->
                    when(resultCode){
                        Activity.RESULT_OK -> {
                            val dishId = data?.getIntExtra(DishDetailActivity.DISH_ID,0)
                            val dishVariants = data?.getStringExtra(DishDetailActivity.DISH_VARIANTS)
                            addDish(dishId!!,dishVariants)

                        }

                    }
        }
    }

    fun addDish(dishId:Int, variants: String?){
        val dish = Dishes.getDish(dishId)
        Tables.addOrder(tableNumber!!,dish,variants)
    }

    fun showDish(idDish:Int){
            val intent = DishDetailActivity.intent(this,idDish)
            startActivityForResult(intent,REQUEST_FOR_DISH)
    }
}