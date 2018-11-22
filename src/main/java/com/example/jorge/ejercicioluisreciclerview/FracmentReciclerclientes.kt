package com.example.jorge.ejercicioluisreciclerview

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_recycler_clientes.*
import java.io.IOException
import java.net.URL


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
/*private const val ARG_PARAM2 = "param2"
private const val ARG_PARAM3 = "param3"*/

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [FracmentReciclerclientes.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [FracmentReciclerclientes.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class FracmentReciclerclientes : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var param3: String? = null
    private var listener: OnFragmentInteractionListener? = null

    var datos1: ArrayList<Clientes> = ArrayList()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recycler_clientes, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        URLJsonObjeto()
        recyclerViewFragment2.layoutManager = LinearLayoutManager(context)
        recyclerViewFragment2.layoutManager = GridLayoutManager(context,1)
        recyclerViewFragment2.adapter=DatosAdapterClientes(datos1,context!!)
    }
    // TODO: Rename method, update argument and hook method into UI event

    fun URLJsonObjeto() {
        val gson = Gson()
        try {
            val json = leerUrl("http://iesayala.ddns.net/jorge/clientes.php")
            val clientes = gson.fromJson(json, ClientesArray::class.java)
            for (item in clientes.clientes!!.iterator()) {
                if(item.ESTADO.equals("1")){
      //          if(!item.ESTADO.equals("RESERVADA")){
                    var cli: Clientes=Clientes(item.NOMBRE,item.TELEFONO,item.POBLACION,item.MARCA,item.MODELO,item.MATRICULA)
                    datos1.add(cli)}
           //}
            }}

        catch (e: Exception){
            Log.d("RESULTADO", "error1")
        }
    }

    private fun leerUrl(urlString:String): String {

        val response = try {
            URL(urlString)
                    .openStream()
                    .bufferedReader()
                    .use { it.readText() }
        } catch (e: IOException) {
            "Error1 with ${e.message}."
        }
        return response
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FracmentRecicler.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                FracmentReciclerclientes().apply {
                    arguments = Bundle().apply {
                        //                    putString(ARG_PARAM1, param1)
/*                    putString(ARG_PARAM2, param2)
                    putString(ARG_PARAM3, param3)*/
                    }
                }
    }
  }
