package com.juanfoncuberta.resto

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class TablesAdapter:RecyclerView.Adapter<TablesAdapter.TablesViewHolder> {


   /* constructor():super(){
        itemClickListener= null
    }*/

    constructor(itemClickListener: ((Table,Int)->Unit)):super(){
        this.itemClickListener = itemClickListener
    }
    private  val items: MutableList<Table> = mutableListOf()
    private val itemClickListener:((Table,Int)->Unit)?



    override fun getItemCount(): Int {
        return items.size
    }


    fun setTables(tables:MutableList<Table>){
        items.clear()
        items.addAll(tables)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TablesViewHolder {

        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_list_table,parent,false)
        return TablesViewHolder(view) }

    override fun onBindViewHolder(holder: TablesViewHolder, position: Int) {
        val item = items[position]
        holder.table = item   }
    inner class TablesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var table:Table? = null
            set(value){
                itemView.findViewById<TextView>(R.id.label_number).text = value?.toString()
                field = value
            }
        init{
            itemView.setOnClickListener{
                table?.let{

                    itemClickListener?.invoke(table as Table,adapterPosition)
                }
            }
        }
    }
}