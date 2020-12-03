package com.example.fragmentexample.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentexample.R
import com.example.fragmentexample.adapters.ItemAdapter
import com.example.fragmentexample.model.ItemData

/**
 * A simple [Fragment] subclass.
 * Use the [ListaFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class ListaFragment : Fragment() {

    var activityListener: View.OnClickListener? = null
    var itemSeleccionado: ItemData? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v= inflater.inflate(R.layout.fragment_lista, container, false)

        val recyclerViewLista: RecyclerView = v.findViewById<View>(R.id.recyclerviewlista) as RecyclerView

        var items = ArrayList<ItemData>()
        for (i in 1..20){
            items.add(ItemData(i.toString(), i.toString()))
        }

        val adapter = ItemAdapter(items) { item ->
            itemSeleccionado = item
            if (activityListener != null) {
                activityListener!!.onClick(view)
            }
        }

        recyclerViewLista.setAdapter(adapter)
        recyclerViewLista.setLayoutManager(LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false))



        return v
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ListaFragment().apply {}
    }
}