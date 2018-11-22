package com.example.jorge.ejercicioluisreciclerview
import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.frangent_datos_clientes.view.*

class DatosAdapterClientes(val items : ArrayList<Clientes>, val context: Context) : RecyclerView.Adapter<ViewHolder1>() {
    // Obtiene el número de datos
    override fun getItemCount(): Int {
        return items.size
    }

    //infla el layout activity_datos
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder1 {
        return ViewHolder1(LayoutInflater.from(context).inflate(R.layout.frangent_datos_clientes, parent, false))
    }
    // carga datos del ArrayList aL TEXTVIEW view
    override fun onBindViewHolder(holder: ViewHolder1, position: Int) {
        // holder?.tvDatosA?.text = items.get(position).CLIENTE
        holder?.tvDatosB?.text = items.get(position).NOMBRE
        holder?.tvDatosC?.text = items.get(position).TELEFONO
        holder?.tvDatosD?.text = items.get(position).POBLACION
        holder?.tvDatosE?.text = items.get(position).MARCA
        holder?.tvDatosF?.text = items.get(position).MODELO
        holder?.tvDatosG?.text = items.get(position).MATRICULA
            holder?.itemView?.setOnClickListener(View.OnClickListener {
                val intent= Intent(context,modifica::class.java)
                intent.putExtra("nombre",  items.get(position).NOMBRE)
                intent.putExtra("matricula", items.get(position).MATRICULA)
                context.startActivity(intent)
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

class ViewHolder1(view: View) : RecyclerView.ViewHolder(view) {
    // Mantiene el TextView
    val tvDatosB = view.textViewDatosN
    val tvDatosC = view.textViewDatosT
    val tvDatosD = view.textViewDatosP
    val tvDatosE = view.textViewDatosMa
    val tvDatosF = view.textViewDatosMo
    val tvDatosG = view.textViewDatosMatr

}


