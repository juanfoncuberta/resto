package com.juanfoncuberta.resto

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_table_detail.*


class TableDetailActivity: AppCompatActivity(){


    var table: Table? = null
    companion object {
        val TABLE_NUMBER = "TABLE_NUMBER"

        fun intent(context:Context,number:Int): Intent {
            val intent = Intent(context, TableDetailActivity::class.java)
            intent.putExtra(TABLE_NUMBER,number)
            return intent
        }
    }
    val dishList:RecyclerView by lazy {
        val dishList:RecyclerView = findViewById(R.id.tableList)
        dishList.layoutManager = LinearLayoutManager(this)
        dishList
    }

    val adapter: MenuAdapter by lazy{
        val adapter = MenuAdapter{
            item,_ ->
            showDishDetail(item.name)
        }
        adapter
    }

    private fun showDishDetail(name: String) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table_detail)
        val id = intent.getIntExtra(TABLE_NUMBER,0)
        table = Tables.findTableById(id)


        table?.let {
            with(table){
                textLabelNumber.text = table.toString()
            }
        }
        showMenuButton.setOnClickListener {
            showMenu()
        }

        getBillButton.setOnClickListener {
            val amountText = Tables.getBillByTable(table!!.number)
            Toast.makeText(this,amountText,Toast.LENGTH_LONG).show()
        }

    }

    override fun onResume() {
        super.onResume()
        textLabelDishes.text = Tables.getStringNameDishes(table!!.number)


    }
    private fun showMenu(){
        val intent = MenuActivity.intent(this,table!!.number)

        intent.putExtra(TABLE_NUMBER,table?.number)
        startActivity(intent)
    }

}