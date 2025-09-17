package com.example.myapplication.viewholder

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val txvNome = itemView.findViewById<TextView>(R.id.txv_nome)
    val txvValor = itemView.findViewById<TextView>(R.id.txv_valor)
    val imgItem = itemView.findViewById<ImageView>(R.id.img_item)
    val btnExcluir = itemView.findViewById<Button>(R.id.btn_excluir)
}