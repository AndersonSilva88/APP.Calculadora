package com.anderson.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()

        //numeros 1..9
        numero_zero.setOnClickListener{ AcrescentarUmaExpessao("0", true)}
        numero_um.setOnClickListener{AcrescentarUmaExpessao("1", true)}
        numero_dois.setOnClickListener{AcrescentarUmaExpessao("2", true)}
        numero_tres.setOnClickListener{AcrescentarUmaExpessao("3", true)}
        numero_quatro.setOnClickListener{AcrescentarUmaExpessao("4", true)}
        numero_cinco.setOnClickListener{AcrescentarUmaExpessao("5", true)}
        numero_seis.setOnClickListener{AcrescentarUmaExpessao("6", true)}
        numero_sete.setOnClickListener{AcrescentarUmaExpessao("7", true)}
        numero_oito.setOnClickListener{AcrescentarUmaExpessao("8", true)}
        numero_novo.setOnClickListener{AcrescentarUmaExpessao("9", true)}
        ponto.setOnClickListener{AcrescentarUmaExpessao(".", true)}

        //operadores

        adicao.setOnClickListener{AcrescentarUmaExpessao("+", false)}
        subtracao.setOnClickListener{AcrescentarUmaExpessao("-", false)}
        multiplicacao.setOnClickListener{AcrescentarUmaExpessao("*", false)}
        divisao.setOnClickListener{AcrescentarUmaExpessao("/", false)}

        //botão limpar

        limpa.setOnClickListener{
            expression.text = ""
            result.text = ""
        }

        //backSpace

        backspace.setOnClickListener{

            val string = expression.text.toString()
            if (string.isNotBlank()){
                expression.text = string.substring(0,string.lenght-1)
            }
            result.text = ""
        }

        //botão igual

        igual.setOnClickListener{
            try {
                val expressao = ExpressionBuilder(expressao.text.toString()).build()
                val resultado = expressao.evaluate()
                val longResult = resultado.toString()

                if (resultado == longResult.toDouble()){
                    result.text = longResult.toString()
                } else
                    result.text = resultado.toString()

            }catch (e: Exception){

            }
        }

    }
    fun AcrescentarUmaExpessao(string : String, limpar_dados : Boolean){
        if (result.text.isNotEmpty()){
            expression.text = ""
        }

        if (limpar_dados){
            result.text = ""
            expression.append(string)
        }else{
            expression.append(result.text)
            expression.append(string)
            result.text = ""
        }
    }
}
