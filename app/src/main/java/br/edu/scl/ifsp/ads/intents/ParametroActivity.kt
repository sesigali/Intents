package br.edu.scl.ifsp.ads.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.edu.scl.ifsp.ads.intents.databinding.ActivityMainBinding
import br.edu.scl.ifsp.ads.intents.databinding.ActivityParametroBinding

class ParametroActivity : AppCompatActivity() {
    private val apb by lazy {
        ActivityParametroBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(apb.root)
        supportActionBar?.subtitle = "ParametroActivity"

//        val parametroRecebido: String = intent.getStringExtra(MainActivity.PARAMETRO_EXTRA) ?: ""
//        //problema com a String, p/ resover pode transformar em nulo; ou se for nulo, voltar vazio.
//        apb.parametroEt.setText(parametroRecebido)

        //let é uma função
        intent.getStringExtra(MainActivity.PARAMETRO_EXTRA)?.let { parametro ->
            apb.parametroEt.setText(parametro)
        }

        apb.enviarParametroBt.setOnClickListener {
            val intentRetorno = Intent()
            intentRetorno.putExtra(MainActivity.PARAMETRO_EXTRA, apb.parametroEt.text.toString())
            setResult(RESULT_OK, intentRetorno)
            //RESULT_OK, qr dizer que voltou tudo ok
            finish()
        }
    }
}