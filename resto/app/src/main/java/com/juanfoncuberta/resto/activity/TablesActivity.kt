package com.juanfoncuberta.resto.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.juanfoncuberta.resto.R
import com.juanfoncuberta.resto.model.Table
import com.juanfoncuberta.resto.model.Tables
import com.juanfoncuberta.resto.adapter.TablesAdapter

class TablesActivity : AppCompatActivity() {

    val tableList:RecyclerView by lazy{
        val tableList:RecyclerView = findViewById(R.id.table_list)
        tableList.layoutManager = LinearLayoutManager(this)
        tableList
    }

    val adapter: TablesAdapter by lazy{
        val adapter = TablesAdapter { item, position ->
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
        startActivity(intent)
    }}


