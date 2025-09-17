package com.example.myapplication.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapter.ItemAdapter
import com.example.myapplication.dao.ItensDAO
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaItens : AppCompatActivity(R.layout.activity_lista_itens) {
    private val itensDAO = ItensDAO()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val rvListaItens = findViewById<RecyclerView>(R.id.rv_lista_itens)
        val fabVoltar = findViewById<FloatingActionButton>(R.id.fab_voltar)
        val itens = itensDAO.get()

        rvListaItens.layoutManager = LinearLayoutManager(this)
        rvListaItens.adapter = ItemAdapter(itens)

        fabVoltar.setOnClickListener{
            finish()

        }
    }

}