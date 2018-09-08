package com.juanfoncuberta.resto.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.juanfoncuberta.resto.activity.DishDetailActivity
import com.juanfoncuberta.resto.model.Dish
import com.juanfoncuberta.resto.R
import com.juanfoncuberta.resto.model.Allergens

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
        holder.bindAllergens(item.allergens)

    }

    inner class DishesViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val dishItemName =  itemView.findViewById<TextView>(R.id.dish_item_name)
        val dishItemPrice =  itemView.findViewById<TextView>(R.id.dish_item_price)
        val dishItemImage = itemView.findViewById<ImageView>(R.id.dish_item_image)


        var dish: Dish? = null
            set(value){
                field = value
               dishItemName.text = value?.name
                dishItemPrice.text = value?.priceToString()
                dishItemImage.setImageResource(value!!.image)

            }
        init {
            itemView.setOnClickListener{
                dish?.let{
                    itemClickListener?.invoke(it,adapterPosition)
                }
            }
        }
        fun bindAllergens(allergens: List<Allergens>){
                allergens.map {
                    itemView.findViewById<ImageView>(it.allergenId).visibility = View.VISIBLE
                    }
        }




    }
}