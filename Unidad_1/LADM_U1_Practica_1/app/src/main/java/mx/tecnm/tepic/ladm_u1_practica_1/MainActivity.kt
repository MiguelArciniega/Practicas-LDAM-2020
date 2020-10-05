package mx.tecnm.tepic.ladm_u1_practica_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //ATRIBUTOS Y OBJETOS GLOBALES

    var entero = 19
    var nombre = "Juanito Gonzalez"
    var w = true
    var s = 19.30
    var m = 19.30f

    var nom : String  ?= null
    var enter : Int ?= 0
    var boton : Button ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Carga la VISTA al controlador

        button.setOnClickListener{
            var nn = editText.text.toString();

            Toast.makeText( this, "Hola "+nn, Toast.LENGTH_LONG).show()
            editText.setText("")
        }

        button2.setOnClickListener{
            var otraVentana = Intent(this, MainActivity2::class.java)
            startActivity(otraVentana)
        }

        imageView2.setOnClickListener{
            AlertDialog.Builder(this).setTitle("ATENCION")
                    .setMessage("ESTO ES UN CUADRO DE DIALOGO")
                    .setPositiveButton("Aceptar") { d, i ->
                        d.dismiss()
                    }
                    .setNeutralButton("NO") { d, i ->
                        d.cancel()
                    }
                    .setNegativeButton("CANCELAR") { d, i ->
                        d.cancel()
                    }
                    .show()
        }
    }
}