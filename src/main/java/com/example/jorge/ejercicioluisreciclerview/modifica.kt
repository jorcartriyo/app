package com.example.jorge.ejercicioluisreciclerview

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_inserta.*
import kotlinx.android.synthetic.main.activity_modifica.*
import kotlinx.android.synthetic.main.frangent_datos_clientes.*
import java.io.IOException
import java.net.URL

class modifica : AppCompatActivity(), FracmentReciclerclientes.OnFragmentInteractionListener,FracmentRecicler1.OnFragmentInteractionListener   {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modifica)
        val bundle:Bundle?=intent.extras
        if (bundle!=null) {
            var mombre = bundle.getString("nombre")
            var matricula = bundle.getString("matricula")
            editText.setText(bundle.getString("nombre"))
            editText2.setText(bundle.getString("matricula"))
        }
    }

    fun modificar(view: View){
        if ((editText2.length() > 0) and (editText.length() > 0)) {
            val url = "http://iesayala.ddns.net/jorge/modificaMotos.php/?CLIENTE=" + editText.text.toString() + "&MATRICULA=" + editText2.text.toString() + "&ESTADO= 'RESERVADO'"
            textView8.setText("La moto con matrícula " + editText2.text.toString() + " se ha reservado al cliente " + editText.text.toString())
            leerUrl(url)
        } else {
            textView8.setText("Los campos no opueden quedar vacios")
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
    fun volver(view: View){
        finish()
    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    fun cargarFragmentClientes(view: View) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.constraint_mod, FracmentReciclerclientes.newInstance("a","b"), "rageComicList")
                .commit()
    }
    fun cargarFragment(view: View) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.constraint_mod, FracmentRecicler1.newInstance("a","b"), "rageComicList")
                .commit()
    }
}
