package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.model.Item
import com.example.myapplication.viewholder.ItemViewHolder

class ItemAdapter(
    private val itens: MutableList<Item>
) : RecyclerView.Adapter<ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_catalogo, parent, false)

        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itens.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itens[position]

        holder.txvNome.text = item.nome
        holder.txvValor.text = item.valor
        
        Glide
            .with(holder.itemView.context)
            .load(item.linkImagem)
            .into(holder.imgItem)

    }
}