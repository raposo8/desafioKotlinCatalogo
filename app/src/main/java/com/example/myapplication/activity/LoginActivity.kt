package com.example.myapplication.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class LoginActivity : AppCompatActivity(R.layout.activity_login_page) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val NOME = "nome"
        val SENHA = "senha"

        val edtNome = findViewById<EditText>(R.id.edt_nome)
        val edtSenha = findViewById<EditText>(R.id.edt_senha)

        val btnLogin = findViewById<Button>(R.id.btn_login)

        btnLogin.setOnClickListener {
            val nome = edtNome.text.toString()
            val senha = edtSenha.text.toString()

            if (nome.equals(NOME) && senha.equals(SENHA)) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

                edtNome.text.clear()
                edtSenha.text.clear()
            } else {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Erro!")
                builder.setMessage("Nome ou senha incorretos")
                builder.create().show()
            }
        }
    }
}