package com.thufik.tableapplication.feature

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.animal_list_item.view.*
import org.json.JSONObject
import java.util.*

class AnimalAdapter(val items : ArrayList<JSONObject>, val context : Context) : RecyclerView.Adapter<ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.animal_list_item,parent,false),context)
    }

    override fun getItemCount(): Int {
        return  items.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtAnimal.text = items.get(position).getString("name")
        holder.animal = items.get(position).getString("name")
    }
}

class ViewHolder : RecyclerView.ViewHolder{

    lateinit var txtAnimal : TextView

    var animal : String? = null

    constructor(view : View, context : Context) : super(view){
        txtAnimal = view.tvAnimalType

        view.setOnClickListener {
            val intent = Intent(context, AnimalDetail::class.java)

            intent.putExtra("name", animal)

            context.startActivity(intent)
            //val toast = Toast.makeText(context, "HUE CLICOU",Toast.LENGTH_SHORT)
            //toast.show()
        }
    }
}