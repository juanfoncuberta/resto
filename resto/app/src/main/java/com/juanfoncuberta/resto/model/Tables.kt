package com.juanfoncuberta.resto.model

import android.util.Log

object Tables {

   var tables: MutableList<Table> = mutableListOf()
    get(){
        if(field.isEmpty())
            field.addAll(tablesList())
        return  field
    }
    private fun tablesList(): MutableList<Table> {
        return (1..10).map {
            createTable(it)
        }.toMutableList()
    }
    private  fun createTable(number:Int): Table {
        return Table(number = number)
    }
    fun findTableById(number: Int): Table?{
        return  tables.find{
            table ->
            table.number == number
        }
    }

    fun addOrder(tableId:Int,dish: Dish,variant:String?){

        val table = tables.get(tableId)
        val order = Order(dish,variant)
        table.orders.add(order)
    }

    fun getNumDishesByTable(tableId:Int):Int{
        val table = tables.get(tableId)
        return table.orders.size
    }

    fun getStringNameDishes(tableId: Int): String? {
        val table = tables.get(tableId)
        var str: String? = null

        table.orders.forEach {
            if(str == null){
                str = it.getResume()
            }else{
                str = str + " " + it.getResume()
            }

        }
        return  str
    }




    fun getBillByTable(tableId:Int):String{
        val table = tables.get(tableId)
        var amount: Float = 0f
        table.orders.forEach {
            amount = amount + it.dish.price
        }

        return "The client has to pay: ${amount} €"
    }
}