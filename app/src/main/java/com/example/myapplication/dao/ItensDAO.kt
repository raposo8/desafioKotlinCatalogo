package com.example.myapplication.dao

import com.example.myapplication.model.Item

class ItensDAO {
    companion object {
        val itens = mutableListOf<Item>()
    }

    fun get(): MutableList<Item> {
        return itens
    }

    fun add(item: Item) {
        itens.add(item)
    }
}