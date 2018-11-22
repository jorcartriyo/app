package com.example.jorge.ejercicioluisreciclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_inserta.*
import java.io.IOException
import java.net.URL

class inserta : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inserta)
        val bundle: Bundle? = intent.extras
        if (bundle != null) {
            editTextMarca.setText(bundle.getString("marca"))
            editTextModelo.setText(bundle.getString("modelo"))
            editTextMatricula.setText(bundle.getString("matricula"))
        }

    }

    fun insertar(v: View) {
        if ((editTextNombre.length() > 0) and (editTextPoblacion.length() > 0) and (editTextTelefono.length() > 0)) {
            val url = "http://iesayala.ddns.net/jorge/insertmoto.php/?NOMBRE=" + editTextNombre.text.toString() + "&TELEFONO=" + editTextPoblacion.text.toString() + "&POBLACION=" + editTextTelefono.text.toString() + "&MARCA=" + editTextMarca.text.toString() + "&MODELO=" + editTextModelo.text.toString() + "&MATRICULA=" + editTextMatricula.text.toString()+ "&ESTADO="+ "1"
            // +"&FECHA=NOW()"
            leerUrl(url)
            textView2.setText("Datos cargados con exito, en breve un operario nuestro se pondrá en contacto con usted")
            print("URL " + url)
        } else {
            textView2.setText("Los campos no opueden quedar vacios")
        }

    }
    fun volver(v : View){
        finish()
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

}
