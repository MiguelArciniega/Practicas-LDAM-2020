package mx.tecnm.tepic.ladm_u1_practica_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_principal.*

class Principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        menuppal.setOnItemClickListener { adapterView, view, pos, l ->
            when(pos){
                pos -> 0 {
                    var act1 = Intent(this, MainActivity::class.java)
                }
                pos -> 1
                    var act2 = Intent(this, MainActivity2::class.java)
                pos -> 2
                    var act3 = Intent(this, MainActivity3::class.java)
                pos -> 3
                    var act4 = Intent(this, MainActivity4::class.java)
                pos -> 4
                    var actP = Intent(this, Principal::class.java)
            }
        }
    }
}
