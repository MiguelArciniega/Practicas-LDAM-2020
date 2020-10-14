package mx.tecnm.tepic.ladm_u1_practica_5

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*
import java.nio.file.Files

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        guardar.setOnClickListener {
            if(guardarEnMemoriaInterna()==true){
                AlertDialog.Builder(this).setTitle("ATENCION")
                    .setMessage("SE GUARDO DATA")
                    .setPositiveButton("ok"){d,i->d.dismiss()}
                    .show()
            }else{
                AlertDialog.Builder(this).setTitle("ERROR")
                    .setMessage("NO SE PUDO GUARDAR")
                    .setPositiveButton("ok"){d,i->d.dismiss()}
                    .show()
            }
        }
        abrir.setOnClickListener {
            if(LeerDeMemoria()==true){
            }else{
                AlertDialog.Builder(this).setTitle("ERROR")
                    .setMessage("NO SE PUDO ABRIR EL ARCHIVO")
                    .setPositiveButton("ok"){d,i->d.dismiss()}
                    .show()
            }
        }
    }

    private fun LeerDeMemoria() : Boolean {
        try {
            var flujoEntrada = BufferedReader(InputStreamReader(openFileInput("archivo.txt")))
            AlertDialog.Builder(this).setTitle("TEXTO GUARDADO")
                .setMessage(flujoEntrada.readLine().toString())
                .setPositiveButton("ok"){d,i->d.dismiss()}
                .show()
        }catch (io:IOException){
            return false;
        }
        return true;
    }

    private fun guardarEnMemoriaInterna(): Boolean {
        try {
            var flujoSalida = OutputStreamWriter(openFileOutput("archivo.txt", Context.MODE_PRIVATE))
            var data = texto.text.toString()
            flujoSalida.write(data)
            flujoSalida.flush()
            flujoSalida.close()
        }catch (io:IOException){
            return false;
        }
        return true;
    }
}