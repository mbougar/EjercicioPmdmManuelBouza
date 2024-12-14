package com.mbougar.ejerciciopmdmmanuelbouza.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mbougar.ejerciciopmdmmanuelbouza.R
import com.mbougar.ejerciciopmdmmanuelbouza.model.Producto

class MainViewModel : ViewModel() {

    private val _search = MutableLiveData("")
    val search: LiveData<String> get() = _search

    private val productos = mutableListOf<Producto> (
        Producto("Manzana", R.drawable.fruta, "Fruta", "Futeria Manolo", 12.4, false, null, "Una Manzana"),
        Producto("Pera", R.drawable.fruta, "Fruta", "Futeria Manolo", 12.4, false, null, "Una Manzana"),
        Producto("Platano", R.drawable.fruta, "Fruta", "Futeria Manolo", 12.4, false, null, "Una Manzana"),
        Producto("Otro", R.drawable.fruta, "Fruta", "Futeria Manolo", 12.4, false, null, "Una Manzana"),
        Producto("Kiwi", R.drawable.fruta, "Fruta", "Futeria Manolo", 12.4, false, null, "Una Manzana"),
        Producto("Tomate", R.drawable.fruta, "Fruta", "Futeria Manolo", 12.4, false, null, "Una Manzana"),
        Producto("Sandia", R.drawable.fruta, "Fruta", "Futeria Manolo", 12.4, false, null, "Una Manzana"),
        Producto("Mango", R.drawable.fruta, "Fruta", "Futeria Manolo", 12.4, false, null, "Una Manzana"),
        Producto("Coco", R.drawable.fruta, "Fruta", "Futeria Manolo", 12.4, false, null, "Una Manzana"),
        Producto("Naranja", R.drawable.fruta, "Fruta", "Futeria Manolo", 12.4, false, null, "Una Manzana"),
        Producto("Otro", R.drawable.fruta, "Fruta", "Futeria Manolo", 12.4, false, null, "Una Manzana"),
        Producto("Limon", R.drawable.fruta, "Fruta", "Futeria Manolo", 12.4, false, null, "Una Manzana"),
        Producto("Otro", R.drawable.fruta, "Fruta", "Futeria Manolo", 12.4, false, null, "Una Manzana"),
        Producto("Otro", R.drawable.fruta, "Fruta", "Futeria Manolo", 12.4, false, null, "Una Manzana"),
        Producto("Otro", R.drawable.fruta, "Fruta", "Futeria Manolo", 12.4, false, null, "Una Manzana"),
        Producto("Otro", R.drawable.fruta, "Fruta", "Futeria Manolo", 12.4, false, null, "Una Manzana"),
        Producto("Otro", R.drawable.fruta, "Fruta", "Futeria Manolo", 12.4, false, null, "Una Manzana"),

    )

    var searchProductos = productos

    fun onSearchChange(newSearch: String) {
        _search.value = newSearch

        searchProductos = productos.filter { it.nombre.lowercase().contains(newSearch.lowercase()) }.toMutableList()
    }
}