package mx.tecnm.tepic.ladm_u1_practica_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        enviar.setOnClickListener {
            var cad = campo1.text.toString()
            var ent = campo2.text.toString()
            var dec = campo3.text.toString()

            var act4 = Intent(this, MainActivity4::class.java)

            act4.putExtra("texto",cad)
            act4.putExtra("entero",ent)
            act4.putExtra("decimal",dec)

            startActivity(act4)
        }
        regresar.setOnClickListener {
            finish()
        }
    }
}