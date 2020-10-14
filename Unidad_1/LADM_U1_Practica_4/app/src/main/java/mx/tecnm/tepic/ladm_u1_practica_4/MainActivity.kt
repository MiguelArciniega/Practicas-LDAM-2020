package mx.tecnm.tepic.ladm_u1_practica_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val vector = arrayOf("La patria es primero", "El respeto al derecho ajeno es la paz", "Aquel que no espera vencer ya está vencido",
                        "Hombres necios que acusais a la mujer sin razón")
    var contador = 0
    var activarTimer = false
    var arreglo1 = ArrayList<String>()
    var matriz : Array<Array<Int>> = Array(10,{Array(5,{0})})
    var arreglo2:Array<Int> = Array(10,{0})
    var arreglo3:Array<String> = Array(100,{"vacío"})
    var arreglo4 = charArrayOf('h','p','m')
    var arreglo5 = intArrayOf(0,0,0,0,0)
    var timer = object : CountDownTimer(20000, 20000){
        override fun onFinish() {
            start()
        }

        override fun onTick(millisUntilFinished: Long) {
            textView.setText(vector[contador])
            contador++
            if (contador == vector.size){
                contador = 0
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            arreglo1.add("hola")
            arreglo1.add("como")
            arreglo1.add("estas")
            arreglo1.removeAt(0)

            timer.start()

            if(activarTimer==false){
                timer.start()
                activarTimer=true
            }else{
                Toast.makeText(this, "ERROR TIMER YA INICIADO", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }
}