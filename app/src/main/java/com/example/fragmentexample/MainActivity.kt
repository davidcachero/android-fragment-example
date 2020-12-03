package com.example.fragmentexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import com.example.fragmentexample.fragments.FichaFragment
import com.example.fragmentexample.fragments.ListaFragment

class MainActivity : AppCompatActivity() {

    var frameLayoutFragment: FrameLayout? = null
    var frameLayoutLista: FrameLayout? = null
    var frameLayoutFicha:FrameLayout? = null

    var listaFragment: ListaFragment? = null
    var fichaFragment: FichaFragment? = null

    var segundoFragmentActivo = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        frameLayoutFragment = findViewById(R.id.frameLayoutFragment)
        frameLayoutFicha = findViewById(R.id.frameLayoutFicha)
        frameLayoutFragment = findViewById(R.id.frameLayoutFragment)

        listaFragment = ListaFragment.newInstance()
        listaFragment!!.activityListener = activityListener

        fichaFragment = FichaFragment()

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        if (frameLayoutFragment ==null){
            // HORIZONTAL
            fragmentTransaction.add(R.id.frameLayoutLista, listaFragment!!)
            fragmentTransaction.add(R.id.frameLayoutFicha, fichaFragment!!)
        }
        else {
            fragmentTransaction.add(R.id.frameLayoutFragment, listaFragment!!)
        }
        fragmentTransaction.commit()
    }

    var activityListener = View.OnClickListener {
        if (frameLayoutFragment!=null) {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frameLayoutFragment, fichaFragment!!)
            fragmentTransaction.commit()
            fragmentManager.executePendingTransactions()
            segundoFragmentActivo = true
        }


        fichaFragment!!.updateData(listaFragment!!.itemSeleccionado)
    }

    override fun onBackPressed() {
        if (segundoFragmentActivo && frameLayoutFragment != null){
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frameLayoutFragment, listaFragment!!)
            fragmentTransaction.commit()
            fragmentManager.executePendingTransactions()
            segundoFragmentActivo = false
        }
        else{
            super.onBackPressed()
        }
    }
}