package com.juanfoncuberta.resto

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout

class TablesActivity : AppCompatActivity() {

    val tableList:RecyclerView by lazy{
        val tableList:RecyclerView = findViewById(R.id.tableList)
        tableList.layoutManager = LinearLayoutManager(this)
        tableList
    }
    val dises by lazy {


    }

    val adapter:TablesAdapter by lazy{
        val adapter = TablesAdapter{
            item, position ->
            showTable(item.number)
        }
        adapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tables)
        val tables: MutableList<Table> = Tables.tables

        adapter.setTables(tables)
        tableList.layoutManager = LinearLayoutManager(this)
        tableList.adapter = adapter

    }

    fun showTable(tableNumber:Int)
    {
        val intent = TableDetailActivity.intent(this,tableNumber)
       //
        startActivity(intent)
    }}


