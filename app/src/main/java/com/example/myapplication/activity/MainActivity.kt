package com.example.myapplication.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.dao.ItensDAO
import com.example.myapplication.model.Item

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val itensDAO = ItensDAO()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val edtNome = findViewById<EditText>(R.id.edt_nome)
        val edtValor = findViewById<EditText>(R.id.edt_valor)
        val edtLinkImagem = findViewById<EditText>(R.id.edt_link_imagem)

        val btnCadastrar = findViewById<Button>(R.id.btn_cadastrar)
        val btnVerItens = findViewById<TextView>(R.id.txv_ver_itens)

        btnCadastrar.setOnClickListener {
            val nome = edtNome.text.toString()
            val valor = edtValor.text.toString()
            val linkImagem = edtLinkImagem.text.toString()

            try {
                valor.toFloat()

                itensDAO.add(
                    Item(nome, valor, linkImagem)
                )

                val builder = AlertDialog.Builder(this)
                builder.setTitle("Sucesso!")
                builder.setMessage("Seu item de colecionador foi adicionado com sucesso")
                builder.create().show()

                edtNome.text.clear()
                edtValor.text.clear()
                edtLinkImagem.text.clear()
            } catch (e: NumberFormatException) {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Erro!")
                builder.setMessage("Campo valor deve ser um valor númerico")
                builder.create().show()
            }
        }

        btnVerItens.setOnClickListener {
            val intent = Intent(this, ListaItens::class.java)
            startActivity(intent)
        }
    }
}