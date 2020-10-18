package mx.tecnm.tepic.ladm_u1_practica_2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        guardar.setOnClickListener {
            if(rInt.isChecked()) {
                if (guardarEnMemoriaInterna() == true) {
                    AlertDialog.Builder(this).setTitle("ATENCIÓN")
                        .setMessage("SE GUARDÓ LOS DATOS")
                        .setPositiveButton("ACEPTAR") { d, i -> d.dismiss() }
                        .show()
                }
            }else{
                if (guardarEnMemoriaExterna() == true) {
                    AlertDialog.Builder(this).setTitle("ATENCIÓN")
                        .setMessage("SE GUARDÓ LOS DATOS")
                        .setPositiveButton("ACEPTAR") { d, i -> d.dismiss() }
                        .show()
                }
            }
        }
        abrir.setOnClickListener {
            if(rInt.isChecked()){
                if (!name.text.toString().isEmpty()){
                    if(AbrirEnMemoriaInterna().isEmpty() == false){
                        AlertDialog.Builder(this).setTitle("ATENCION")
                            .setMessage("SE LEYÓ LA DATA")
                            .setPositiveButton("ok"){d,i->d.dismiss()}
                            .show()
                    }else{
                        AlertDialog.Builder(this).setTitle("ERROR")
                            .setMessage("ARCHIVO NO ENCONTRADO")
                            .setPositiveButton("ACEPTAR"){d,i->d.dismiss()}
                            .show()
                    }
                } else{
                    AlertDialog.Builder(this).setTitle("ERROR")
                        .setMessage("ARCHIVO NO ENCONTRADO")
                        .setPositiveButton("ACEPTAR"){d,i->d.dismiss()}
                        .show()
                }
            }else{
                if (!name.text.toString().isEmpty()){
                    if(AbrirEnMemoriaExterna().isEmpty() == false){
                        AlertDialog.Builder(this).setTitle("ATENCION")
                            .setMessage("SE LEYÓ LA DATA")
                            .setPositiveButton("ok"){d,i->d.dismiss()}
                            .show()
                    }else{
                        AlertDialog.Builder(this).setTitle("ERROR")
                            .setMessage("ARCHIVO NO ENCONTRADO")
                            .setPositiveButton("ACEPTAR"){d,i->d.dismiss()}
                            .show()
                    }
                } else{
                    AlertDialog.Builder(this).setTitle("ERROR")
                        .setMessage("ARCHIVO NO ENCONTRADO")
                        .setPositiveButton("ACEPTAR"){d,i->d.dismiss()}
                        .show()
                }
            }
        }
    }

    private fun guardarEnMemoriaInterna(): Boolean {
        try {
            var archivo = name.text.toString()
            var flujoSalida = OutputStreamWriter(openFileOutput(archivo, Context.MODE_PRIVATE))
            var data = data.text.toString()
            flujoSalida.write(data)
            flujoSalida.flush()
            flujoSalida.close()
        } catch (io:IOException){
            return false
        }
        return true
    }

    private fun guardarEnMemoriaExterna(): Boolean {
        var myExternalFile = File(getExternalFilesDir("mExterna"), name.text.toString())
        try {
            val fileOutPutStream = FileOutputStream(myExternalFile)
            fileOutPutStream.write(data.text.toString().toByteArray())
            fileOutPutStream.close()
        } catch (e: IOException) {
            return false
            e.printStackTrace()
        }
        return true
    }

    private fun AbrirEnMemoriaInterna() : String {
        var contenido = ""
        var archivo = name.text.toString()
        try {
            var flujoEntrada = BufferedReader(InputStreamReader(openFileInput(archivo)))
            contenido = flujoEntrada.readLine()
            flujoEntrada.close()
            data.setText(contenido)
        }catch (io:IOException){
            return ""
        }
        return contenido
    }

    //File(getExternalFilesDir(filepath), fileName.text.toString())

    private fun AbrirEnMemoriaExterna() : String {
        var contenido = ""
        try{
            var myExternalFile = File(getExternalFilesDir("mExterna"), name.text.toString())
            val filename = name.text.toString()
            var fileInputStream =FileInputStream(myExternalFile)
            var inputStreamReader: InputStreamReader = InputStreamReader(fileInputStream)
            val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)
            val stringBuilder: StringBuilder = StringBuilder()
            var text: String? = null
            while ({ text = bufferedReader.readLine(); text }() != null) {
                stringBuilder.append(text)
            }
            fileInputStream.close()
            contenido = stringBuilder.toString()
            data.setText(contenido)
        } catch (io:IOException){
            return ""
        }
        return contenido
    }
}