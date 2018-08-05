package com.juanfoncuberta.resto.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.juanfoncuberta.resto.activity.DishDetailActivity
import com.juanfoncuberta.resto.activity.MenuActivity
import com.juanfoncuberta.resto.model.Dish
import com.juanfoncuberta.resto.R

class MenuAdapter:  RecyclerView.Adapter<MenuAdapter.DishesViewHolder> {


    constructor(itemClickListener: ((Dish, Int)->Unit)):super(){
        this.itemClickListener = itemClickListener
    }
    private val items: MutableList<Dish> = mutableListOf()
    private val itemClickListener:((Dish, Int)->Unit)?
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishesViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_list_dish,parent,false)
        return DishesViewHolder(view)
   }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setDishes(dishes:MutableList<Dish>){
        items.clear()
        items.addAll(dishes)
        notifyDataSetChanged()
    }
    fun showDishDetail(dishId:Int){
        val intent = DishDetailActivity.intent(this@MenuAdapter as Context,dishId)
        startActivity(intent)
    }

    override fun onBindViewHolder(holder: DishesViewHolder, position: Int) {
        val item = items[position]
        holder.dish = item
    }

    inner class DishesViewHolder(itemView:View):RecyclerView.ViewHolder(itemView), View.OnClickListener{
        override fun onClick(v: View?) {


        }

        var dish: Dish? = null
            set(value){

                itemView.findViewById<TextView>(R.id.dishItemName).text = value?.name
                itemView.findViewById<TextView>(R.id.dishItemPrice).text = value?.priceToString()
                itemView.findViewById<ImageView>(R.id.dishitemImage).setImageResource(value!!.image)
                itemView.findViewById<Button>(R.id.button_detail).setOnClickListener {
                    showDishDetail(value.id)
                }
               itemView.findViewById<Button>(R.id.button_add).id = value.id
                itemView.findViewById<Button>(value.id).setOnClickListener {
                    MenuActivity.addButonClicked(it.id)

                }


                field = value
            }

        private fun finish() {
            finish()
        }

        init {
                itemView.setOnClickListener{
                    dish?.let{
                        itemClickListener?.invoke(dish as Dish,adapterPosition)
                    }
                }
            }

    }
}