package com.example.ladm_u1_ejercicio_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    var contadorTimer = 0
    var contadorHilo = 0
    val LAPSO = 2000 // 2000 milisegundos = 2 segundos
    val TIEMPOTOTAL = 20000 // 20000 milisegundos = 20 segundos
    var hilito = Hilo(this)

    // Sintaxis del Timer, TIEMPO TOTAL Y LAPSO EN MILISEGUNDOS
    var timer = object : CountDownTimer(TIEMPOTOTAL.toLong(), LAPSO.toLong()){
        override fun onTick(p0: Long) {
            /*
                On TICK = Se ejecuta cuando el tiempo "LAPSO" llega a ser 0
             */
            contadorTimer ++
            textView.text = "Timer: $contadorTimer"
        }

        override fun onFinish() {
            /*
            OnFinish = Se ejecuta cuando el tiempo "TOTAL" llega a 0

            Una vez se ejecuta el onFinish el Timer se DETIENE, a menos
            que se invoque un START dentro de OnFinish, empezando de nuevo
             */
            start()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            timer.start()
        }

        button2.setOnClickListener{
            try {
                hilito.start() /* Hago que el objeto hilito, construido a partir de la clase HILO
                            se ejecute en 2do plano */
            }catch (c:Exception){
                AlertDialog.Builder(this)
                    .setMessage("EL HILO NO SE PUEDE VOLVER A EJECUTAR")
                    .setTitle("ATENCION")
                    .setPositiveButton("ok")  { d,i->d.dismiss() }
                    .show()
            }
        }

        button3.setOnClickListener {
            hilito.pausar()
        }

        button4.setOnClickListener {
            hilito.terminarHilo()
        }
    }
}

// CLASE HILO
class Hilo(p:MainActivity) : Thread(){

    var puntero = p
    var mantener = true
    var despausado = true

    fun terminarHilo(){
        mantener = false
    }

    override fun run() {
        super.run()
        /*
            es el método que funciona SIMILAR al ONTICK, es decir, esta siempre el TIEMPO
            en ejecución, siempre que se cicle.
            Realmente run solo se ejecuta 1 vez en 2do plano.
        */

        fun pausar(){
            despausado = !despausado
        }

        while (mantener) {

            if(despausado == true){
                puntero.contadorHilo ++
                puntero.runOnUiThread {
                    /*Se debe usar el runOnUiThread debido a que, la INTERFAZ GRAFICA
                    * le pertence al MainActivity, y Kotlin no permite que de MANERA DIRECTA
                    * OTRA CLASE modifique una interfaz gráfica que no le pertenece.
                    * La otra clase se entiende que es el HILO. Por ello usamos
                    * el bloque runOnUiThread para aplicar permisos de modificación*/
                    puntero.textView2.text = "Hilo: " + puntero.contadorHilo
                }
            }

            // AL HILO LE AFECTA EL STRESS
            sleep(2000)
        }
        // CORRUTINAS   CLASE DEPRECIADA = AsyncTask (obsoleta)
    }
    /*
    override  fun  onCreate(savedInstanceState: Bundle?){
        super.run()
    }*/

}