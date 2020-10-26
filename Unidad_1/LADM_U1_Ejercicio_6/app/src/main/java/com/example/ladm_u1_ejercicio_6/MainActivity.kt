package com.example.ladm_u1_ejercicio_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var contadorTimer = 0
    var contadorHilo = 0
    val LAPSO = 2000 // 2000 milisegundos = 2 segundos
    val TIEMPOTOTAL = 20000 // 20000 milisegundos = 20 segundos
    // Sintaxis del Timer, TIEMPO TOTAL Y LAPSO EN MILISEGUNDOS
    var timer = object : CountDownTimer(TIEMPOTOTAL.toLong(), LAPSO.toLong()){
        override fun onTick(millisUntilFinished: Long) {
            /*
                On TICK = Se ejecuta cuando el tiempo "LAPSO" llega a ser 0
             */
            contadorTimer ++
            textView.text = "Timer:  " + contadorTimer.toString()
        }

        override fun onFinish() {
            /*
            OnFinish = Se ejecuta cuando el tiempo "TOTAL" llega a 0

            Una vez se ejecuta el onFinish el Timer se DETIENE, a menos
            que se invoque un START dentro de OnFinish, empezando de nuevo
             */
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            timer.start()
        }

        button2.setOnClickListener{
            timer.start() /* Hago que el objeto hilito, construido a partir de la clase HILO
                            se ejecute en 2do plano */
        }
    }
}

// CLASE HILO
class Hilo(p:MainActivity) : Thread(){

    var puntero = p

    override fun run() {
        super.run()
        /*
            es el método que funciona SIMILAR al ONTICK, es decir, esta siempre el TIEMPO
            en ejecución, siempre que se cicle.
            Realmente run solo se ejecuta 1 vez en 2do plano.
        */

        while (true) {
            puntero.runOnUiThread {
                /*Se debe usar el runOnUiThread debido a que, la INTERFAZ GRAFICA
                * le pertence al MainActivity, y Kotlin no permite que de MANERA DIRECTA
                * OTRA CLASE modifique una interfaz gráfica que no le pertenece.
                * La otra clase se entiende que es el HILO. Por ello usamos
                * el bloque runOnUiThread para aplicar permisos de modificación*/
                puntero.textView2.text = "Hilo: " + puntero.contadorHilo
            }

            // AL HILO LE AFECTA EL STRESS
            sleep(100)
        }
        // CORRUTINAS   CLASE DEPRECIADA = AsyncTask (obsoleta)
    }
    /*
    override  fun  onCreate(savedInstanceState: Bundle?){
        super.run()
    }*/

}