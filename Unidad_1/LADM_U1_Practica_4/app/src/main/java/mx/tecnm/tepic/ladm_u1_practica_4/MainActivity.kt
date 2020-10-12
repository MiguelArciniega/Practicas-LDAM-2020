package mx.tecnm.tepic.ladm_u1_practica_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    val vector = arrayOf("La patria es primero", "El respeto al derecho ajeno es la paz", "Aquel que no espera vencer ya está vencido",
                        "Hombres necios que acusais a la mujer sin razón")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}