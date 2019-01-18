package com.thufik.tableapplication.feature


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class FirstFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_first, container, false)
        val firstFragment = R.layout.fragment_first
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

        val animals = ArrayList<Animal>()
        val animal = Animal("teste","teste")
        animals.add(animal)

        val recyclerViewAdapter = RecyclerViewAdapter(animals, this.context)

        if (recyclerView != null) {
            recyclerView.adapter = recyclerViewAdapter
            val linearLayoutManager = LinearLayoutManager(this.context)
            //print(activity)
            recyclerView.layoutManager = linearLayoutManager
        }

        return view
    }
}

class RecyclerViewAdapter(val items : ArrayList<Animal>, val context: Context?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        var ViewHolder = AnimalViewHolder(LayoutInflater.from(context).inflate(R.layout.animal_list_item,parent,false))

        return ViewHolder
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        //val holder = holder as AnimalViewHolder

    }

}

class AnimalViewHolder : RecyclerView.ViewHolder {

    //val txtName : String

    constructor(view : View?) : super(view) {

    }
}