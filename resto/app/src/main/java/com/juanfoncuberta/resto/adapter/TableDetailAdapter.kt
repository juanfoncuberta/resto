package com.juanfoncuberta.resto.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.juanfoncuberta.resto.R
import com.juanfoncuberta.resto.model.Order


class TableDetailAdapter(val orders: List<Order>):RecyclerView.Adapter<TableDetailAdapter.TableDetailViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableDetailViewHolder {

        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_list_dish_table_detail,parent,false)
        return TableDetailViewHolder(view)
    }

    override fun onBindViewHolder(holder: TableDetailViewHolder, position: Int) {
        holder.bindOrder(orders[position])
    }

    override fun getItemCount(): Int = orders.size


    inner class TableDetailViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bindOrder(order:Order){
            itemView.findViewById<TextView>(R.id.dish_name_table_detail).text = order.dish.name
            itemView.findViewById<TextView>(R.id.dish_price_table_detail).text = order.dish.priceToString()
            itemView.findViewById<TextView>(R.id.text_dish_variants).text = "Variant: ${order.variant}"
        }


    }
}

