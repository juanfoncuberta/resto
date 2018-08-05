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

    fun addDish(tableId:Int,dish: Dish){

        val table = tables.get(tableId)
        Log.v("tableTables",table.toString())
        Log.v("dishTables",dish.name)
        table.dishes.add(dish)
    }

    fun getNumDishesByTable(tableId:Int):Int{
        val table = tables.get(tableId)
        return table.dishes.size
    }

    fun getStringNameDishes(tableId: Int): String? {
        val table = tables.get(tableId)
        var str: String? = null
        table.dishes.forEach {
            if(str == null){
                str = it.name
            }else{
                str = str + " " + it.name
            }

        }
        return  str
    }

    fun getBillByTable(tableId:Int):String{
        val table = tables.get(tableId)
        var amount: Float = 0f
        table.dishes.forEach {
            amount = amount + it.price
        }

        return "The client has to pay: ${amount} €"
    }
}