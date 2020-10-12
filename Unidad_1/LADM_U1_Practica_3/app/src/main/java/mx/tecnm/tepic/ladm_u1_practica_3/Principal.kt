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
                0->{
                    var act = Intent(this, MainActivity::class.java)
                    startActivity(act)
                }
                1->{
                    var act = Intent(this, MainActivity2::class.java)
                    startActivity(act)
                }
                2->{
                    var act = Intent(this, MainActivity3::class.java)
                    startActivity(act)
                }
                3->{
                    var act= Intent(this, MainActivity4::class.java)
                    startActivity(act)
                }
                4->{
                    var act = Intent(this, MainActivity5::class.java)
                    startActivity(act)
                }
                5->{
                    finish()
                }
            }
        }
    }
}
