package com.example.fragmentexample.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.fragmentexample.R
import com.example.fragmentexample.model.ItemData


/**
 * A simple [Fragment] subclass.
 * Use the [FichaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FichaFragment : Fragment() {

    var textViewNombre: TextView? = null
    var textViewDireccion: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v =  inflater.inflate(R.layout.fragment_ficha, container, false)

        textViewNombre = v.findViewById<View>(R.id.textViewFichaNombre) as TextView
        textViewDireccion = v.findViewById<View>(R.id.textViewFichaDireccion) as TextView
        return v
    }

    fun updateData(item: ItemData?) {
        if (item!=null) {
            textViewNombre!!.text = item.nombre
            textViewDireccion!!.text = item.direccion
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FichaFragment().apply {
            }
    }
}