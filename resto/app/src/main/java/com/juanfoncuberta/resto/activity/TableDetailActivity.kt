package com.juanfoncuberta.resto.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Message
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.juanfoncuberta.resto.adapter.MenuAdapter
import com.juanfoncuberta.resto.R
import com.juanfoncuberta.resto.model.Table
import com.juanfoncuberta.resto.model.Tables

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
        val adapter = MenuAdapter { item, _ ->
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

        supportActionBar?.title = getString(R.string.table_resum_title, id.toString())

        showMenuButton.setOnClickListener {
            showMenu()
        }

        getBillButton.setOnClickListener {
            val billAlertMessage = Tables.getBillByTable(table!!.number)
            val title = getString(R.string.alert_bill_title, table!!.number.toString())
            showAlert(title,billAlertMessage)
        }

    }

    override fun onResume() {
        super.onResume()
        textLabelDishes.text =  Tables.getStringNameDishes(table!!.number)


    }
    private fun showMenu(){
        val intent = MenuActivity.intent(this,table!!.number)

        intent.putExtra(TABLE_NUMBER,table?.number)
        startActivity(intent)
    }

    private fun showAlert(title:String,message: String){
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton(R.string.ok_button){_, _ -> }
        val alert = builder.create()
        alert.show()
    }

}