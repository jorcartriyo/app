package com.example.jorge.ejercicioluisreciclerview

import android.content.Context
import android.graphics.*
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_recycler.*
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
 * [FracmentRecicler1.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [FracmentRecicler1.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class FracmentRecicler1 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var param3: String? = null
    private var listener: OnFragmentInteractionListener? = null

    var datos: ArrayList<Motos> = ArrayList()

    private val p = Paint()
    private var adaptera : DatosAdapter1?=null
    //private var view: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recycler, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        URLJsonObjeto()
        recyclerViewFragment.layoutManager = LinearLayoutManager(context)
        recyclerViewFragment.layoutManager = GridLayoutManager(context,1)
        recyclerViewFragment.adapter=DatosAdapter1(datos,context!!)
        adaptera= DatosAdapter1(datos, context!! )
        recyclerViewFragment.adapter=adaptera
        initSwipe()
    }
    // TODO: Rename method, update argument and hook method into UI event

    fun URLJsonObjeto() {
        val gson = Gson()
        try {
            val json = leerUrl("http://iesayala.ddns.net/jorge/motos.php")
            val motos = gson.fromJson(json, MotosArray::class.java)
            for (item in motos.motos!!.iterator()) {
                    var mot: Motos=Motos(item.CLIENTE,item.MARCA,item.MODELO,item.MATRICULA,item.PRECIO,item.IMAGEN,                item.ESTADO)
                    datos.add(mot)}
            }
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
                FracmentRecicler1().apply {
                    arguments = Bundle().apply {
                        //                    putString(ARG_PARAM1, param1)
/*                    putString(ARG_PARAM2, param2)
                    putString(ARG_PARAM3, param3)*/
                    }
                }
    }
    private fun initSwipe() {
        val simpleItemTouchCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                return false
            }
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                if (direction == ItemTouchHelper.LEFT) {
                    adaptera!!.removeItem(position)
                } else {
                    adaptera!!.removeItem(position)
                }
            }
            private fun removeView() {
                if (view!!.parent != null) {
                    (view!!.parent as ViewGroup).removeView(view)
                }
            }
            /*
            */
            override fun onChildDraw(c: Canvas, recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {
                val icon: Bitmap
                if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
                    val itemView = viewHolder.itemView
                    val height = itemView.bottom.toFloat() - itemView.top.toFloat()
                    val width = height / 3
                    if (dX > 0) {
                        p.color = Color.parseColor("#388E3C")
                        val background = RectF(itemView.left.toFloat(), itemView.top.toFloat(), dX, itemView.bottom.toFloat())
                        c.drawRect(background, p)
                        //  icon = BitmapFactory.decodeResource(resources, R.drawable.ic_edit_white)
                        val icon_dest = RectF(itemView.left.toFloat() + width, itemView.top.toFloat() + width, itemView.left.toFloat() + 2 * width, itemView.bottom.toFloat() - width)
                        //c.drawBitmap(icon, null, icon_dest, p)
                    } else {
                        p.color = Color.parseColor("#D32F2F")
                        val background = RectF(itemView.right.toFloat() + dX, itemView.top.toFloat(), itemView.right.toFloat(), itemView.bottom.toFloat())
                        c.drawRect(background, p)
                        //  icon = BitmapFactory.decodeResource(resources, R.drawable.chico)
                        val icon_dest = RectF(itemView.right.toFloat() - 2 * width, itemView.top.toFloat() + width, itemView.right.toFloat() - width, itemView.bottom.toFloat() - width)
                        // c.drawBitmap(icon, null, icon_dest, p)
                    }
                }
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
            }
        }
        val itemTouchHelper = ItemTouchHelper(simpleItemTouchCallback)
        itemTouchHelper.attachToRecyclerView(recyclerViewFragment)
    }
}
