package mx.tecnm.tepic.ladm_u1_practica_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        button2.setOnClickListener {
            finish()
        }

        button.setOnClickListener {
            var n1 = editTextNumber.text.toString().toInt()
            var n2 = editTextNumber2.text.toString().toInt()
            var op = spinner.selectedItemPosition.toString().toInt()
            var res = 0

            when(op){
                0 ->{
                    res = n1 + n2
                }
                1 -> {
                    res = n1 - n2
                }
                2 -> {
                    res = n1 * n2
                }
                3 -> {
                    res = n1 / n2
                }
            }

            Toast.makeText(this, "RESULTADO: ${res}", Toast.LENGTH_LONG).show()
            editTextNumber.setText("")
            editTextNumber2.setText("")
        }
    }
}