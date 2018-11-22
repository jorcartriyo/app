package com.example.jorge.ejercicioluisreciclerview


import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.ImageView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.frangent_datos1.view.*


class DatosAdapter1(val items : ArrayList<Motos>, val context: Context) : RecyclerView.Adapter<ViewHolder2>() {
    // Obtiene el número de datos
    override fun getItemCount(): Int {
        return items.size
    }

    //infla el layout activity_datos
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder2 {
        return ViewHolder2(LayoutInflater.from(context).inflate(R.layout.frangent_datos1, parent, false))
    }

    // carga datos del ArrayList aL TEXTVIEW view
    override fun onBindViewHolder(holder: ViewHolder2, position: Int) {
        holder?.tvDatosA?.text = items.get(position).CLIENTE
        holder?.tvDatosB?.text = items.get(position).MARCA
        holder?.tvDatosC?.text = items.get(position).MODELO
        holder?.tvDatosD?.text = items.get(position).MATRICULA
        holder?.tvDatosE?.text = items.get(position).PRECIO
        holder?.ivDatos?.loadUrl(items.get(position).IMAGEN)
        holder?.itemView?.setOnClickListener(View.OnClickListener {
            Toast.makeText(
                    context,
                    items.get(position).MARCA+ " " + items.get(position).MODELO,

                    Toast.LENGTH_SHORT
            ).show()
        })
    }
    fun ImageView.loadUrl(url: String) {
        Picasso.with(context).load(url).into(this)
    }
    fun removeItem(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, items.size)
    }
}

class ViewHolder2(view: View) : RecyclerView.ViewHolder(view) {
    // Mantiene el TextView
    val tvDatosA = view.textViewDatos
    val tvDatosB = view.textViewDatos2
    val tvDatosC = view.textViewDatos3
    val tvDatosD = view.textViewDatos4
    val tvDatosE = view.textViewDatos5
    val ivDatos= view.ivDatos
}


