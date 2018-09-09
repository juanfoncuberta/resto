package com.juanfoncuberta.resto.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.juanfoncuberta.resto.R
import com.juanfoncuberta.resto.adapter.TableDetailAdapter
import com.juanfoncuberta.resto.model.Order
import com.juanfoncuberta.resto.model.Table
import com.juanfoncuberta.resto.model.Tables
import kotlinx.android.synthetic.main.activity_table_detail.*
import kotlinx.android.synthetic.main.recycle_orders.*


class TableDetailActivity: AppCompatActivity(){

    companion object {
        val TABLE_NUMBER = "TABLE_NUMBER"

        fun intent(context:Context,number:Int): Intent {
            val intent = Intent(context, TableDetailActivity::class.java)
            intent.putExtra(TABLE_NUMBER,number)
            return intent
        }
    }
    var table: Table? = null

    val dishList:RecyclerView by lazy {
        val dishList:RecyclerView = findViewById(R.id.order_detail_table_detail)
        dishList.layoutManager = LinearLayoutManager(this)
        dishList
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table_detail)
        val id = intent.getIntExtra(TABLE_NUMBER,0)
        table = Tables.findTableById(id)


        supportActionBar?.title = getString(R.string.table_resum_title, id.toString())
        order_detail_table_detail.layoutManager = GridLayoutManager(this,1)
        order_detail_table_detail.itemAnimator = DefaultItemAnimator()

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
        showOrders(Tables.getOrders(table!!.number))



    }
    private fun showOrders(orders: List<Order>){
        val adapter = TableDetailAdapter(orders)
        order_detail_table_detail.adapter = adapter

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