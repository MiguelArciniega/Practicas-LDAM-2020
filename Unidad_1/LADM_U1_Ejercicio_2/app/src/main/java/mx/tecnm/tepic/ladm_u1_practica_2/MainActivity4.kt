package mx.tecnm.tepic.ladm_u1_practica_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main4.*

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        var extra = intent.extras;

        var cadena = extra?.getString("texto")
        var entero = extra?.getString("entero")
        var decimal = extra?.getString("decimal")

        etiquetacadena.setText(cadena)
        etiquetaentero.setText(entero)
        etiquetadecimal.setText(decimal)

        reg.setOnClickListener {
            finish()
        }
    }
}