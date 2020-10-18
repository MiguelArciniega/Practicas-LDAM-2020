package mx.tecnm.tepic.ladm_u1_practica_5

import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*
import java.nio.file.Files

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        permiso.setOnClickListener {
            if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),0)
            }
        }

        concedido.setOnClickListener {
            if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                AlertDialog.Builder(this)
                    .setMessage("SI TIENES PERMISO DE ESCRITURA")
                    .show()
            }else{
                AlertDialog.Builder(this)
                    .setMessage("NO HAY PERMISOS DE ESCRITURA")
                    .show()
            }
        }

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
            if(AbrirEnMemoriaInterna().isEmpty() == false){
                AlertDialog.Builder(this).setTitle("ATENCION")
                    .setMessage("SE LEYÓ LA DATA")
                    .setPositiveButton("ok"){d,i->d.dismiss()}
                    .show()
            }else{
                AlertDialog.Builder(this).setTitle("ERROR")
                    .setMessage("NO SE PUDO ABRIR EL ARCHIVO")
                    .setPositiveButton("ok"){d,i->d.dismiss()}
                    .show()
            }
        }
    }

    private fun AbrirEnMemoriaInterna() : String {
        var contenido = ""
        var name = "archivo.txt"
        try {
            var flujoEntrada = BufferedReader(InputStreamReader(openFileInput(name)))
            contenido = flujoEntrada.readLine()
            flujoEntrada.close()
            AlertDialog.Builder(this).setTitle(name)
                .setMessage(contenido)
                .setPositiveButton(contenido){d,i->d.dismiss()}
                .show()
        }catch (io:IOException){
            return ""
        }
        return contenido
    }

    private fun guardarEnMemoriaInterna(): Boolean {
        try {
            var name = "archivo.txt"
            var flujoSalida = OutputStreamWriter(openFileOutput(name, Context.MODE_PRIVATE))
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