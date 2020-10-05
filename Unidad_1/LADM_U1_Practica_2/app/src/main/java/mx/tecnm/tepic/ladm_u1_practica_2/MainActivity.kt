package mx.tecnm.tepic.ladm_u1_practica_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        menuppal.setOnItemClickListener { parent, view, itemSeleccionado, id ->

            when(itemSeleccionado){
                0 -> {
                    //Invoca activity2
                    var act2 = Intent(this, MainActivity2::class.java)
                    startActivity(act2)
                }
                1 -> {
                    //Invoca activity3
                    var act3 = Intent(this, MainActivity3::class.java)
                    startActivity(act3)
                }
                2 -> {
                    AlertDialog.Builder(this)
                            .setMessage("(c) Miguel Leopoldo Arciniega Ramirez. LADM. ITTepic. 2020")
                            .setTitle("ACERCA DE...")
                            .setPositiveButton("Aceptar") {d,i ->
                                d.dismiss()
                            }
                            .show()
                }
                3 -> {
                    finish()
                }
            }
        }
    }
}